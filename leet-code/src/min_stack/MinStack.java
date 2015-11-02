package min_stack;


class MinStack {
    private Node head = null;
    
    public void push(int x) {
        Node node = new Node(x, Math.min(x, getMin()));
        node.next = head;
        head = node;
    }

    public void pop() {
        if(head != null) {
            head = head.next;
        }
    }

    public int top() {
        return head == null ? Integer.MAX_VALUE : head.value;
    }

    public int getMin() {
        return head == null ? Integer.MAX_VALUE : head.min;
    }
    
    private static class Node {
        private int value;
        private Node next;
        int min;
        
        private Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
}