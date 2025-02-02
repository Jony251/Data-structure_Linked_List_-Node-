import unit4.collectionsLib.Node;

public class sequenceOfN_InLinkedList {
    public static void main(String[] args) {

        int[] array = {3, 4, 5, 10, 11, 12, 13, 20, 19, 18, 17};
        Node<Integer> hTest = createLinkedList(array);
        System.out.println(ifSequenceInLinkedList(hTest, 3)); // true (3,4,5)
        System.out.println(ifSequenceInLinkedList(hTest, 4)); // true (10,11,12,13)
        System.out.println(ifSequenceInLinkedList(hTest, 5)); // false (20,19,18,17 is only 4 elements)
        System.out.println(ifSequenceInLinkedList(hTest, 6));
    }
    /**
     * Prints the elements of a linked list of integers.
     * @param head the head node of the linked list
     */
    public static void printAllNodeVal(Node<Integer> head) {
        Node<Integer> tmp = head;

        for (; tmp != null; tmp = tmp.getNext())
            System.out.print("" + tmp.getValue() + ", ");
        System.out.println();

    }

    /**
     * Creates a linked list of integers from an array.
     * @param array an array of integers to be converted into a linked list
     * @return the head node of the created linked list
     */
    public static Node<Integer> createLinkedList(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        Node<Integer> head = null;
        for (int i = array.length-1; i > -1 ; i--) {
            head = new Node<Integer>(array[i],head);

        }
        return head;
    }

    /**
     * Checks if the linked list contains a sequence of n consecutive numbers (ascending or descending)
     * Time Complexity: O(n), where n is the number of nodes in the list (single pass)
     * @param head the head of the linked list
     * @param num the required length of the consecutive sequence
     * @return  {@code boolean} True if there is a sequence of n consecutive numbers, false otherwise.
     */
    public static boolean ifSequenceInLinkedList(Node<Integer> head, int num){
        if (head == null || num <= 1) return false;

        int diff;
        int ascendingCount = 1;
        int descendingCount = 1;

        Node<Integer> current = head;

        while (current.getNext() != null) {
            diff = current.getNext().getValue() - current.getValue();

            if (diff == 1) {
                ascendingCount++;
                descendingCount = 1;
            } else if (diff == -1) {
                descendingCount++;
                ascendingCount = 1;
            } else {
                ascendingCount = 1;
                descendingCount = 1;
            }

            if (ascendingCount == num || descendingCount == num) {
                return true;
            }

            current = current.getNext();
        }

        return false;
    }

}
