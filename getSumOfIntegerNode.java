import unit4.collectionsLib.Node;

/*
 * Time Complexity of sumOfNode
 * Total time O(n) --> O(n)
 * We go through the node only once
 */

public class getSumOfIntegerNode {
    public static void main(String[] args) {
        int[] array1 = {1, 0};
        int[] array2 = {0};
        int[] array3 = {};
        int[] array4 = {1, 2, 3, 4, 4, 5, 6};
        int[][] testArr = {array1, array2, array3, array4};

        for (int[] numArr : testArr) {
            Node<Integer> hTest = null;
            hTest = createLinkedList(numArr);
            printAllNodeVal(hTest);
            System.out.println(sumOfNode(hTest));
        }
    }

    /**
     * Function that sums all integers in the given node
     * The head remains unchanged
     *
     * @param head the head of integers node
     * @return {@code int} sum of the integer node
     */
    public static int sumOfNode(Node<Integer> head) {
        Node<Integer> tmp = head;

        int sum = 0;
        if (tmp != null) {
            while (tmp.hasNext()) {
                sum += tmp.getValue();
                tmp = tmp.getNext();
            }
            return sum + tmp.getValue();
        }
        return sum;
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