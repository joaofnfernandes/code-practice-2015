package week2;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;



// todo: check why algs4 grader only accepts In, and not StdIn
public class Subset {
    // todo: we only need rq of length k
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            rq.enqueue(StdIn.readString());
        }
        Iterator<String> iter = rq.iterator();
        for (int i = 0; i < k && iter.hasNext(); i++) {
            if(i > 0) {
                StdOut.println();
            }
            StdOut.print(iter.next());
        }
    }
}
