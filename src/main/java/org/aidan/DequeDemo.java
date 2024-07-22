package org.aidan;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    public static void main(String[] args) {
        // 头部是队首,尾部是队尾
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(1); // 在尾部填加
        deque.offerLast(2); // 在尾部填加
        deque.offerLast(3); // 在尾部填加
        deque.offerLast(4); // 在尾部填加

        Integer peek = deque.peekFirst(); // 1 (查看队首元素) 相当于peekFirst
        System.out.println("peek = " + peek);

        deque.pollFirst(); // 从头部弹出
        deque.pollFirst(); // 从头部弹出
        deque.pollFirst(); // 从头部弹出
        deque.pollFirst(); // 从头部弹出

        boolean empty = deque.isEmpty(); // true
        System.out.println("empty = " + empty);
    }
}
