import unit4.collectionsLib.Node;

public class isNumAboveBelowEqual_Average {
    public static void main(String[] args) {
        Node<Double> list = createList(new double[]{1.5, 2.0, 3.5, 6.0, 7.5, 9.0}); // Example list
        System.out.println("Result: " + isEqualAboveBelowAverage(list));
    }

    /**
     * Checks if the number of elements greater than the average equals the number of elements less than the average
     * in a linked list of floating-point numbers.
     * Time complexity: O(n), where n is the number of nodes in the linked list. The list is traversed twice.
     * @param head the head node of the linked list
     * @return true if the count of elements above the average equals the count below the average, false otherwise
     */
    public static boolean isEqualAboveBelowAverage(Node<Double> head) {
        if (head == null) return false;

        double sum = 0;
        int count = 0;
        Node<Double> current = head;

        while (current != null) {
            sum += current.getValue();
            count++;
            current = current.getNext();
        }

        double average = sum / count;

        int aboveCount = 0;
        int belowCount = 0;
        current = head;

        while (current != null) {
            if (current.getValue() > average) {
                aboveCount++;
            } else if (current.getValue() < average) {
                belowCount++;
            }
            current = current.getNext();
        }

        return aboveCount == belowCount;
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
}
