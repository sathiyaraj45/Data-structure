package queue;

import java.util.Iterator;

/**
 * @Author Sathiyaraj created on 16-02-2022
 * <p>
 * TODO
 */


public class QueueAlgorithm {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add("45");
        System.out.println(q);
        q.add("50");
        System.out.println(q);
        q.add("35");
        System.out.println(q);
        q.add("90");
        System.out.println(q);
        System.out.println("List of queue elements");
        System.out.println(q.remove());
        System.out.println(q);
        System.out.println(q.remove());
        System.out.println(q);
        System.out.println(q.remove());
        System.out.println(q);
        System.out.println(q.remove());
        System.out.println(q);
        System.out.println(q.remove());
        System.out.println(q);
    }
}
