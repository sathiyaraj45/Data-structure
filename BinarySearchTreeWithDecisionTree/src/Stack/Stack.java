package Stack;

/**
 * @Author Sathiyaraj created on 16-02-2022
 * <p>
 * TODO
 */


public class Stack {
    private static class Node {
        private Object data;
        private Node next;

        private Node(Object data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
    private Node top;

    public boolean isEmplty() {
        return top == null ? true: false;
    }

    public Object peek() {
        return top.data;
    }

    public void push(Object data) {
        Node node = new Node(data);
        if(top == null){
            top = node;
        } else {
            node.next = top;
            top = node;
        }
    }

    public Object pop() {
        if(!isEmplty()) {
            Object obj = top.data;
            if(top.next != null) {
                top = top.next;
            } else{
                top = null;
            }
            return obj;
        } else{
            return "No records available in stack";
        }
    }

    @Override
    public String toString() {
        return "Stack{" +
                "top=" + top +
                '}';
    }
}
