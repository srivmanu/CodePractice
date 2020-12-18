/**
 * Created By srivmanu on 11/23/2019 for CodePractice
 * This will always be a test run.
 * Unless you are compiling to submit on play store.
 * In which case, God help your soul.
 */
class MergerOfLists {

    private class LNode {

        int data;

        LNode next;

        public LNode() {
            this.next = null;
        }

        public LNode(final int data) {
            this.data = data;
            this.next = null;
        }
    }

    public LNode mergeList(LNode head1, LNode head2) {
        LNode pointer1 = head1;
        LNode pointer2 = head2;
        LNode newList = null;
        int flag = -1;
        while (true) {
            if (pointer1 == null) {
                flag = 2;
                break;
            }
            if (pointer2 == null) {
                flag = 1;
                break;
            }

            if (pointer1.data > pointer2.data) {
                LNode temp = new LNode(pointer1.data);
                temp.next = newList;
                newList = temp;
                pointer1 = pointer1.next;
            } else {
                LNode temp = new LNode(pointer2.data);
                temp.next = newList;
                newList = temp;
                pointer2 = pointer2.next;
            }
        }
        //todo add remaining left
        LNode temp = null;
        if (flag == 1) {
            temp = pointer1;
        } else if (flag == 2) {
            temp = pointer2;
        }
        while (temp != null) {
            LNode n = new LNode(temp.data);
            n.next = newList;
            newList = n;
            temp = temp.next;
        }
        return newList;
    }
}
