import unit4.collectionsLib.Node;

public class insertAnIntegerToSortedNode {
    public static void main(String[] args) {
        Node<Integer> testNode = null;
        int[] array = {2, 8, 15, 21};
        Node<Integer> hTest = createLinkedList(array);

        printAllNodeVal(hTest);

        testNode = (insertToSortedNode(hTest, 1));
        printAllNodeVal(testNode);
        testNode = (insertToSortedNode(testNode, 12));
        printAllNodeVal(testNode);
        testNode = (insertToSortedNode(testNode, 1100));
        printAllNodeVal(testNode);

    }

    /**
     * Inserts an integer into a sorted linked list while maintaining the sorted order
     *
     * @param head the head of the sorted linked list
     * @param num  the integer to insert
     * @return {@code Node<Integer>} updated head of the linked list
     */
    public static Node<Integer> insertToSortedNode(Node<Integer> head, int num) {
        Node<Integer> tmp = head;
        Node<Integer> numNode = new Node<Integer>(num);

        if (tmp != null) {

            if (head.getValue() < num) {
                for (; tmp.getNext() != null && tmp.getNext().getValue() < num; tmp = tmp.getNext()) ;
                numNode.setNext(tmp.getNext());
                tmp.setNext(numNode);
            } else {
                numNode.setNext(head);
                head = numNode;
            }

        } else head = numNode;
        return head;
    }

    /**
     * Function creates a linked list (Node) of integers
     *
     * @param array the array of integers to create the linked list
     * @return {@code Node<Integer>} heat of the created linked list
     */
    public static Node<Integer> createLinkedList(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        Node<Integer> head = null;
        for (int i = array.length - 1; i > -1; i--) {
            head = new Node<Integer>(array[i], head);

        }
        return head;
    }

    /**
     * Function prints a linked list (Node) of integers
     *
     * @param head the head of linked list to print
     */
    public static void printAllNodeVal(Node<Integer> head) {
        Node<Integer> tmp = head;

        for (; tmp != null; tmp = tmp.getNext())
            System.out.print("" + tmp.getValue() + ", ");
        System.out.println();

    }
}
