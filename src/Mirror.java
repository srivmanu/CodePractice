public class Mirror {

    public static class Tree {

        Tree left = null;

        Tree right = null;

        int x = 0;
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        t.x = 1;
        t.left = new Tree();
        t.left.x = 2;
        t.right = new Tree();
        t.right.x = 3;
        MirrorTree(t);
    }

    void print(Tree t, String indent) {
        System.out.println(indent);
        System.out.println(t.x);
        print(t.left, indent + " ");
        print(t.right, indent + " ");
    }

    static void MirrorTree(Tree t) {
        if (t == null) {
            return;
        } else {
            Tree temp = t.left;
            t.left = t.right;
            t.right = temp;
            MirrorTree(t.left);
            MirrorTree(t.right);
        }
    }
}
