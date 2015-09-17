package week2;

import java.util.Iterator;

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
        Iterator<String> iter = rq.iterator();
        for (int i = 0; i < k && iter.hasNext(); i++) {
            if(i > 0) {
                out.println();
            }
            out.print(iter.next());
        }
    }
}
