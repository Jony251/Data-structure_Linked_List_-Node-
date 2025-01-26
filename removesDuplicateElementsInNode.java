import unit4.collectionsLib.Node;

public class removesDuplicateElementsInNode {

    public static void main(String[] args) {
        Node<Double> list = createList(new double[]{1.2, 3.5, 4.0, 3.5, 6.7, 1.2, 4.0}); // Example list
        System.out.println("Original list:");
        printList(list);

        Node<Double> uniqueList = removeDuplicates(list);
        System.out.println("List without duplicates:");
        printList(uniqueList);
    }

    /**
     * Removes duplicate elements from a linked list of floating-point numbers.
     * complexity: O(n^2), where n is the number of nodes in the linked list.
     * @param head the head node of the linked list
     * @return the head node of the linked list with duplicates removed
     */
    public static Node<Double> removeDuplicates(Node<Double> head) {
        if (head == null) {
            return null;
        }

        Node<Double> current = head;

        while (current != null) {
            Node<Double> runner = current;
            while (runner.getNext() != null) {
                if (runner.getNext().getValue().equals(current.getValue()))
                    runner.setNext(runner.getNext().getNext());
                else
                    runner = runner.getNext();

            }
            current = current.getNext();
        }

        return head;
    }

    /**
     * Creates a linked list of floating-point numbers from an array.
     *
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
     * Prints the elements of a linked list of floating-point numbers.
     *
     * @param head the head node of the linked list
     */
    public static void printList(Node<Double> head) {
        Node<Double> current = head;

        while (current != null) {
            System.out.print(current.getValue());
            if (current.getNext() != null)
                System.out.print(" -> ");

            current = current.getNext();
        }
        System.out.println();
    }
}
