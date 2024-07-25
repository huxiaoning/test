package org.aidan;

public class BinarySearchTree {

    private TreeNode root;

    public TreeNode search(int num) {
        for (TreeNode curr = root; curr != null; ) {
            if (num > curr.val) {
                // 向右遍历
                curr = curr.right;
            } else if (num < curr.val) {
                // 向左遍历
                curr = curr.left;
            } else {
                return curr;
            }
        }
        return null;
    }

    public void insert(int num) {
        if (root == null) {
            root = new TreeNode(num);
            return;
        }

        TreeNode curr = root;
        TreeNode pre = null;
        for (; curr != null; ) {
            pre = curr;
            if (num > curr.val) {
                // 向右遍历
                curr = curr.right;
            } else if (num < curr.val) {
                // 向左遍历
                curr = curr.left;
            } else {
                // num == curr.val 查找到重复节点 直接返回
                return;
            }
        }
        if (num > pre.val) {
            pre.right = new TreeNode(num);
        } else {
            pre.left = new TreeNode(num);
        }

    }

    /* 删除节点 */
    public void remove(int num) {
        // 若树为空，直接提前返回
        if (root == null)
            return;
        TreeNode cur = root, pre = null;
        // 循环查找，越过叶节点后跳出
        while (cur != null) {
            // 找到待删除节点，跳出循环
            if (cur.val == num)
                break;
            pre = cur;
            // 待删除节点在 cur 的右子树中
            if (cur.val < num)
                cur = cur.right;
                // 待删除节点在 cur 的左子树中
            else
                cur = cur.left;
        }
        // 若无待删除节点，则直接返回
        if (cur == null)
            return;
        // 子节点数量 = 0 or 1
        if (cur.left == null || cur.right == null) {
            // 当子节点数量 = 0 / 1 时， child = null / 该子节点
            TreeNode child = cur.left != null ? cur.left : cur.right;
            // 删除节点 cur
            if (cur != root) {
                if (pre.left == cur)
                    pre.left = child;
                else
                    pre.right = child;
            } else {
                // 若删除节点为根节点，则重新指定根节点
                root = child;
            }
        }
        // 子节点数量 = 2
        else {
            // 获取中序遍历中 cur 的下一个节点
            TreeNode tmp = cur.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            // 递归删除节点 tmp
            remove(tmp.val);
            // 用 tmp 覆盖 cur
            cur.val = tmp.val;
        }
    }

    static class TreeNode {
        int val;         // 节点值
        TreeNode left;   // 左子节点引用
        TreeNode right;  // 右子节点引用

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        // 构建一棵有序的二叉搜索树 (插入顺序不同会导致树的形态不同,下面的插入顺序会生成一颗和书本中一样的树)
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(8);
        binarySearchTree.insert(4);
        binarySearchTree.insert(12);
        binarySearchTree.insert(2);
        binarySearchTree.insert(6);
        binarySearchTree.insert(10);
        binarySearchTree.insert(14);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);
        binarySearchTree.insert(9);
        binarySearchTree.insert(11);
        binarySearchTree.insert(13);
        binarySearchTree.insert(15);

        System.out.println("binarySearchTree = " + binarySearchTree);


    }
}
