package Amazon;

import java.util.ArrayList;

public class TreeAvg {

    class CategoryNode {

        ArrayList<CategoryNode> subCategoryNode;

        int value;

        CategoryNode() {
            this.subCategoryNode = new ArrayList<>();
        }

        CategoryNode(int val) {
            this.subCategoryNode = new ArrayList<>();
            this.value = val;
        }
    }

    private CategoryNode maxNode = null;

    public static void main(String[] args) {
        TreeAvg tree = new TreeAvg();
        CategoryNode rootNode = tree.defineTree();
        tree.printTree(rootNode, "");
        System.out.println("return : " + (tree.func1(rootNode)).value);
    }

    public CategoryNode func(CategoryNode rootNode) {
        if (rootNode.subCategoryNode.size() == 0) {
            return maxNode;
        }
        for (CategoryNode node : rootNode.subCategoryNode) {
            if (node.subCategoryNode.size() != 0) {
                if (getAvg(maxNode) < getAvg(node) && node.subCategoryNode.size() != 0) {
                    maxNode = node;
                    func(node);
                }
            }
        }
        return maxNode;
    }

    double getAvg(CategoryNode node) {
        double cal = (getSum(node, 0) / getCount(node, 1));
        return cal;
    }

    double getCount(CategoryNode node, double count) {
        if (node.subCategoryNode.size() == 0) {
            return count;
        } else {
            for (CategoryNode c : node.subCategoryNode) {
                count++;
                count += getCount(c, 0);
            }
            return count;
        }
    }

    double getSum(CategoryNode node, double sum) {
        if (node.subCategoryNode.size() == 0) {
            return node.value;
        } else {
            sum += node.value;
            for (CategoryNode sub : node.subCategoryNode) {
                double val = getSum(sub, 0);
                sum += val;
            }
            return sum;
        }
    }

    private CategoryNode defineTree() {
        CategoryNode treeVal = new CategoryNode(1);
        CategoryNode subtree = new CategoryNode(2);
//        subtree.subCategoryNode.add(new CategoryNode(11));
//        subtree.subCategoryNode.add(new CategoryNode(2));
        subtree.subCategoryNode.add(new CategoryNode(3));
        treeVal.subCategoryNode.add(subtree);
//        subtree = new CategoryNode(10);
//        subtree.subCategoryNode.add(new CategoryNode(9));
////        subtree.subCategoryNode.add(new CategoryNode(8));
//        treeVal.subCategoryNode.add(subtree);
        return treeVal;
    }

    private CategoryNode func1(CategoryNode node) {
        maxNode = node;
        return func(node);
    }

    private void printTree(CategoryNode rootNode, String indent) {
        if (rootNode.subCategoryNode.size() == 0) {
            System.out.println(indent + rootNode.value);
        } else {
            System.out.println(indent + rootNode.value);
            for (CategoryNode node : rootNode.subCategoryNode) {
                printTree(node, "\t" + indent);
            }
        }
    }
}
