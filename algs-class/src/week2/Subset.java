package week2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

public class Subset {
    // todo: we only need rq of length k
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("usage: java Subset n");
            return;
        }
        int k = Integer.parseInt(args[0]);
        if (k <= 0) {
            return;
        }
        In in = new In();
        Out out = new Out();
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        while (!in.isEmpty()) {
            rq.enqueue(in.readString());
        }
        for (String s : rq) {
            out.println(s);
            if (--k <= 0) {
                break;
            }
        }
    }
}
