package Amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * root1 is tree, find root2 in tree, if root2 exists, return 1, else -1
 * Its supposed to be managerial structure, and you're looking for employee at root2.val
 */
public class findsubtree {

    private static class BinaryTreeNode {

        BinaryTreeNode left;

        BinaryTreeNode right;

        int value;

        Map<Integer, Integer> x = new HashMap<Integer, Integer>();

        public BinaryTreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode left = new BinaryTreeNode(6);
        BinaryTreeNode right = new BinaryTreeNode(8);
        BinaryTreeNode root0 = new BinaryTreeNode(7);
        root0.left = left;
        root0.right = right;
        left = new BinaryTreeNode(2);
        right = new BinaryTreeNode(4);
        BinaryTreeNode root1 = new BinaryTreeNode(3);
        root1.left = left;
        root1.right = right;
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.left = root0;
        root.right = root1;

        root0 = new BinaryTreeNode(5);
        left = new BinaryTreeNode(3);
        right = new BinaryTreeNode(7);
        root0.left = left;
        root0.right = right;

        System.out.println("\n::::");
        printTree(root, "");
        System.out.println("\n::::");
        printTree(root0, "");
        System.out.println("\n::::--------------::::");
        System.out.print(isSubTree(root, root0));
    }

    static boolean finder(BinaryTreeNode search, BinaryTreeNode target) {
        if (search.left == null && search.right == null) {
            //LEAF : SEARCH
            //equal
            return target.right == null && target.left == null;
        } else if (search.left == null) {
            //right maybe something
            if (target.left != null) {
                return false;
            } else if (target.right == search.right) {
                return finder(search.right, target.right);
            }
        } else if (search.right == null) {
            if (target.right != null) {
                return false;
            } else if (target.left.value == search.left.value) {
                return finder(search.left, target.left);
            }
        } else {
            //neither child are null compare both
            if (target.right.value == search.right.value && target.left.value == search.left.value) {
                return (finder(search.right, target.right) && finder(search.left, target.left));
            } else {
                return false;
            }
        }
        return false;
    }

    static int isSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1.value == root2.value) {
            return (finder(root1, root2) ? 1 : -1);
        } else if (root1.left == null) {
            return isSubTree(root1.right, root2);
        } else if (root1.right == null) {
            return isSubTree(root1.left, root2);
        } else {
            if (root1.right.value == root2.value && root1.left.value == root2.value) {
                int left = isSubTree(root1.left, root2);
                int right = isSubTree(root1.right, root2);
                return (left == 1 || right == 1) ? 1 : -1;
            } else if (root1.right.value == root2.value) {
                return isSubTree(root1.right, root2);
            } else if (root1.left.value == root2.value) {
                return isSubTree(root1.left, root2);
            } else {
                return -1;
            }
        }
    }

    private static void printTree(BinaryTreeNode root, String indent) {

        if (root != null) {
            System.out.println(indent + root.value);
            printTree(root.left, indent + "  ");
            printTree(root.right, indent + "  ");
        }
    }
}
