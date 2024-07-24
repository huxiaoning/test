package org.aidan;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeDemo {

    static class TreeNode {
        int val;         // 节点值
        TreeNode left;   // 左子节点引用
        TreeNode right;  // 右子节点引用

        TreeNode(int x) {
            val = x;
        }
    }


    /* 前序遍历 */
    void preOrder(TreeNode root) {
        if (root == null)
            return;
        // 访问优先级：根节点 -> 左子树 -> 右子树
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    private List<Integer> list = new ArrayList<>();

    /* 中序遍历 */
    void inOrder(TreeNode root) {
        if (root == null)
            return;
        // 访问优先级：左子树 -> 根节点 -> 右子树
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    /* 后序遍历 */
    void postOrder(TreeNode root) {
        if (root == null)
            return;
        // 访问优先级：左子树 -> 右子树 -> 根节点
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
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

        TreeNodeDemo treeNodeDemo1 = new TreeNodeDemo();
        treeNodeDemo1.preOrder(treeNode1);
        System.out.println("list = " + treeNodeDemo1.getList());

        TreeNodeDemo treeNodeDemo2 = new TreeNodeDemo();
        treeNodeDemo2.inOrder(treeNode1);
        System.out.println("list = " + treeNodeDemo2.getList());


        TreeNodeDemo treeNodeDemo3 = new TreeNodeDemo();
        treeNodeDemo3.postOrder(treeNode1);
        System.out.println("list = " + treeNodeDemo3.getList());
    }
}