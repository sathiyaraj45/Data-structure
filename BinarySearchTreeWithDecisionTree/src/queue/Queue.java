package queue;

/**
 * @Author Sathiyaraj created on 16-02-2022
 * <p>
 * TODO
 */


public class Queue {
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

    private Node front;
    private Node rear;

    public boolean isEmpty() {
        return front == null;
    }

    public Object peek() {
        return front.data;
    }

    public void add(Object data){
        Node node = new Node(data);
        if(rear != null) {
            rear.next = node;
        }
        rear = node;
        if(front == null) {
            front = node;
        }
    }

    public Object remove() {
        if(!isEmpty()){
            Object data = front.data;
            if(front.next != null) {
                front = front.next;
            } else {
                front = null;
            }
            return data;
        } else {
            rear = null;
            return "Nodes not available in the queue";
        }
    }

    @Override
    public String toString() {
        return "Queue{" +
                "front=" + front +
                ", rear=" + rear +
                '}';
    }
}
