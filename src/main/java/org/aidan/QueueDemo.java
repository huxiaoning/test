package org.aidan;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        // 头部是队首,尾部是队尾
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 在尾部填加
        queue.offer(2); // 在尾部填加
        queue.offer(3); // 在尾部填加
        queue.offer(4); // 在尾部填加

        Integer peek = queue.peek(); // 1 (查看队首元素) 相当于peekFirst
        System.out.println("peek = " + peek);

        queue.poll(); // 从头部弹出
        queue.poll(); // 从头部弹出
        queue.poll(); // 从头部弹出
        queue.poll(); // 从头部弹出

        boolean empty = queue.isEmpty(); // true
        System.out.println("empty = " + empty);
    }
}
