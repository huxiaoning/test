package org.aidan;

import java.util.LinkedList;

public class StackDemo {
    public static void main(String[] args) {
        // 头部为栈顶
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1); // addFirst
        stack.push(2); // addFirst
        stack.push(3); // addFirst
        stack.push(4); // addFirst

        Integer peek = stack.peek(); // 4 (查看栈顶元素) peekFirst
        System.out.println("peek = " + peek);

        stack.pop(); // removeFirst()
        stack.pop(); // removeFirst()
        stack.pop(); // removeFirst()
        stack.pop(); // removeFirst()

        boolean empty = stack.isEmpty(); // true
        System.out.println("empty = " + empty);
    }
}
