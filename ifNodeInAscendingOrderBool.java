import unit4.collectionsLib.Node;

public class ifNodeInAscendingOrderBool {
    public static void main(String[] args) {
        int[] array_false1 = {1, 0};
        int[] array_false2 = {0};
        int[] array_false3 = {};
        int[] array_false4 = {1, 2, 3, 4, 4, 5, 6};
        int[] array_true = {1, 2, 3, 4, 5};
        int[][] testArr = {array_false1, array_false2, array_false3, array_false4, array_true};

        for (int i = 0; i < testArr.length ; i++) {
            Node<Integer> hTest = null;
            hTest = createLinkedList(testArr[i]);
            printAllNodeVal(hTest);
            System.out.println(ifNodeInAscendingOrder(hTest));
        }
    }

    /**
     * Function that checks if all integers in the given node are in ascending order
     * The head remains unchanged after the check
     *
     * @param head the head of integers node to check
     * @return {@code true} if the node is in ascending order, {@code false} otherwise
     */
    public static boolean ifNodeInAscendingOrder(Node<Integer> head) {
        Node<Integer> tmp = head;
        boolean result = true;
        int first;

        if (tmp != null && tmp.hasNext()) {
            while (tmp.hasNext() && result) {
                first = tmp.getValue();
                tmp = tmp.getNext();

                if (!(first < tmp.getValue()))
                    result = false;
            }
        } else return false;

        return result;
    }

    /**
     * Function to print node of integers
     *
     * @param head of the given node
     */
    public static void printAllNodeVal(Node<Integer> head) {
        Node<Integer> tmp = head;

        for (; tmp != null; tmp = tmp.getNext())
            System.out.print("" + tmp.getValue() + ", ");
        System.out.println();

    }

    /**
     * Function to create a linked list from an array of numbers
     *
     * @param array array of integers
     * @return {@code Node<Integer>} head of the new node
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

}
