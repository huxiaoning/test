package org.aidan;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeNodeDemo2 {

    static class TreeNode {
        int val;         // 节点值
        TreeNode left;   // 左子节点引用
        TreeNode right;  // 右子节点引用

        TreeNode(int x) {
            val = x;
        }
    }


    private Stack<TreeNode> stack = new Stack<>();
    private List<Integer> list = new ArrayList<>();

    /* 前序遍历 */
    void preOrder(TreeNode root) {
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /* 中序遍历 */
    void inOrder(TreeNode root) {
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            // 将当前节点及其左子节点入栈，直至左子树为空
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // 弹出栈顶节点并访问
            curr = stack.pop();
            list.add(curr.val);

            // 将右子树设为当前节点，继续遍历右子树
            curr = curr.right;
        }
    }

    /* 后序遍历 */
    void postOrder(TreeNode root) {
        stack.push(root);
        Stack<Integer> result = new Stack<>();

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.push(node.val);

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        // 输出后序遍历结果
        while (!result.isEmpty()) {
            list.add(result.pop());
        }
    }

    public List<Integer> getList() {
        return list;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        TreeNodeDemo2 treeNodeDemo1 = new TreeNodeDemo2();
        treeNodeDemo1.preOrder(treeNode1);
        System.out.println("list = " + treeNodeDemo1.getList());

        TreeNodeDemo2 treeNodeDemo2 = new TreeNodeDemo2();
        treeNodeDemo2.inOrder(treeNode1);
        System.out.println("list = " + treeNodeDemo2.getList());


        TreeNodeDemo2 treeNodeDemo3 = new TreeNodeDemo2();
        treeNodeDemo3.postOrder(treeNode1);
        System.out.println("list = " + treeNodeDemo3.getList());
    }
}