import unit4.collectionsLib.Node;

public class checksIfTargetNumIsPresentInNode {

    public static void main(String[] args) {
        Node<Double> list = createList(new double[]{1.2, 3.5, 4.0, 6.7}); // Example list
        double number = 4.0; // Target number
        System.out.println("The number " + number + " is found in the list: " + containsNumber(list, number));

        number = 5.5;
        System.out.println("The number " + number + " is found in the list: " + containsNumber(list, number));
    }

    /**
     * Checks if a target number is present in the linked list.
     * complexity: O(n), where n is the number of nodes in the linked list. Each node is visited once.
     * @param head   the head node of the linked list
     * @param target the target number to search for
     * @return true if the target number is found in the list, false otherwise
     */
    public static boolean containsNumber(Node<Double> head, double target) {
        Node<Double> current = head;

        while (current != null) {
            if (current.getValue() == target) {
                return true; // The number is found
            }
            current = current.getNext();
        }

        return false; // The number is not found
    }

    /**
     * Creates a linked list of floating-point numbers from an array.
     * @param values an array of floating-point numbers to be converted into a linked list
     * @return the head node of the created linked list
     */
    public static Node<Double> createList(double[] values) {
        Node<Double> head = null;
        Node<Double> current = null;

        for (double value : values) {
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
