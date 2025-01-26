import unit4.collectionsLib.Node;

public class countTheNumOfSequencesOfTargetNumInNode {

    public static void main(String[] args) {
        Node<Integer> list = createList(new int[]{2, 7, 5, 3, 2, 2, 1, 1, 2, 2}); // Example list
        printList(list);
        int targetNum = 2;
        System.out.println("Number of sequences of " + targetNum + ": " + countSequences(list, targetNum));
    }

    /**
     * Counts the number of sequences of a target number in a linked list.
     * A sequence is defined as one or more consecutive occurrences of the target number.
     * complexity: O(n), where n is the number of nodes in the linked list. The list is traversed once.
     * @param head   the head node of the linked list
     * @param target the target number to count sequences for
     * @return the number of sequences of the target number
     */
    public static int countSequences(Node<Integer> head, int target) {
        if (head == null) {
            return 0;
        }

        int count = 0;
        boolean inSequence = false;
        Node<Integer> current = head;

        while (current != null) {
            if (current.getValue() == target) {
                if (!inSequence) {
                    count++;
                    inSequence = true;
                }
            } else {
                inSequence = false;
            }
            current = current.getNext();
        }

        return count;
    }

    /**
     * Creates a linked list of integers from an array.
     * @param values an array of integers to be converted into a linked list
     * @return the head node of the created linked list
     */
    public static Node<Integer> createList(int[] values) {
        Node<Integer> head = null;
        Node<Integer> current = null;

        for (int value : values) {
            if (head == null) {
                head = new Node<>(value);
                current = head;
            } else {
                current.setNext(new Node<>(value));
                current = current.getNext();
            }
        }

        return head;
    }

    /**
     * Prints the elements of a linked list of integers.
     * @param head the head node of the linked list
     */
    public static void printList(Node<Integer> head) {
        Node<Integer> current = head;

        while (current != null) {
            System.out.print(current.getValue());
            if (current.getNext() != null) {
                System.out.print(" -> ");
            }
            current = current.getNext();
        }
        System.out.println();
    }
}
