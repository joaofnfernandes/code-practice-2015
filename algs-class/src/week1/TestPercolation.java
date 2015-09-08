package week1;

import org.junit.Test;

import edu.princeton.cs.algs4.In;
import static org.junit.Assert.*;

public class TestPercolation {

    private static final String PATH = System.getenv("TEST_RESOURCES");
    
    @Test
    public void Test1NoPerc() {
        final String file = PATH + "input1-no.txt";
        In in = new In(file);
        int N = in.readInt();
        
        Percolation perc = new Percolation(N);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertFalse("System should not percolate", perc.percolates());
    }
    
    @Test
    public void Test2Perc() {
        final String file = PATH + "input2.txt";
        In in = new In(file);
        int N = in.readInt();
        
        Percolation perc = new Percolation(N);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertTrue("System should percolate", perc.percolates());
    }
    
    @Test
    public void Test2NoPerc() {
        final String file = PATH + "input2-no.txt";
        In in = new In(file);
        int N = in.readInt();

        Percolation perc = new Percolation(N);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertFalse("System should not percolate", perc.percolates());
    }
    
    @Test
    public void Test8Perc() {
        final String file = PATH + "input8.txt";
        In in = new In(file);
        int N = in.readInt();
        
        Percolation perc = new Percolation(N);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertTrue("System should percolate", perc.percolates());
    }
    
    @Test
    public void Test8NoPerc() {
        final String file = PATH + "input8-no.txt";
        In in = new In(file);
        int N = in.readInt();
        
        Percolation perc = new Percolation(N);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertFalse("System should not percolate", perc.percolates());
    }
    
    @Test
    public void Test10Perc() {
        final String file = PATH + "input10.txt";
        In in = new In(file);
        int N = in.readInt();
        
        Percolation perc = new Percolation(N);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertTrue("System should percolate", perc.percolates());
    }
    
    @Test
    public void Test10NoPerc() {
        final String file = PATH + "input10-no.txt";
        In in = new In(file);
        int N = in.readInt();
        
        Percolation perc = new Percolation(N);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertFalse("System should not percolate", perc.percolates());
    }

    @Test
    public void TestNoBackwash() {
        final String file = PATH + "no-backwash4.txt";
        
        In in = new In(file);
        int N = in.readInt();
        
        Percolation perc = new Percolation(N);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertTrue("System should percolate", perc.percolates());
        
        assertTrue("Cell (4,4) should be open but not full", perc.isOpen(N, N));
        assertFalse("Cell (4,4) should be open but not full", perc.isFull(N, N));
    }
}
