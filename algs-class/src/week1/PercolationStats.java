package week1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final int N;
    private int T;
    private double mean, stdev;

    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        this.N = N;
        this.T = T;

        runAllSimulations();
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stdev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean - 1.96 * stdev / Math.sqrt(N);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean + 1.96 * stdev / Math.sqrt(N);
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            // default
            args = new String[] { "200", "100" };
        }
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(N, T);
        stats.printResults();
    }

    private void runAllSimulations() {
        double[] experiments = new double[T];
        for (int i = 0; i < T; i++) {
            experiments[i] = runSimulation();
        }
        mean = StdStats.mean(experiments);
        stdev = StdStats.stddev(experiments);
    }

    private double runSimulation() {
        Percolation perc = new Percolation(N);
        StdRandom.setSeed(System.currentTimeMillis());

        int i, j, openCells = 0;
        while (!perc.percolates()) {
            do {
                // choose a random cell that is still closed
                i = (int) (StdRandom.uniform() * N) + 1;
                j = (int) (StdRandom.uniform() * N) + 1;
            } while (perc.isOpen(i, j));
            perc.open(i, j);
            openCells++;
        }
        return (double) (openCells) / (N * N);
    }

    private void printResults() {
        System.out.println(String.format("%1$-24s= %2$f", "mean", mean));
        System.out.println(String.format("%1$-24s= %2$f", "stdev", stdev));
        System.out.println(String.format("%1$-24s= %2$f, %3$f",
                "95% confidence interval", confidenceLo(), confidenceHi()));
    }
}
