import unit4.collectionsLib.Node;

public class elementsGreater_100_AtBeginning {

    public static void main(String[] args) {
        int[] array = {101, 12, 400, 55, 99, 601, 109, 1, 3, 9, 10};

        Node<Integer> result = null;
        Node<Integer> test = createIntLinkedList(array);

        result = sortEleGreater_100_AtBeginning(test);

        printLinkedList(result);
    }

    /**
     * Moves all elements greater than 100 to the beginning while maintaining relative order
     * Time Complexity: O(n) because for a single-pass traversal
     *
     * @param head the head of the linked list
     * @return {@code Node<Integer>} the modified head of the linked list
     */
    public static Node<Integer> sortEleGreater_100_AtBeginning(Node<Integer> head) {
        if (head == null) return null;

        Node<Integer> greaterHead = null;
        Node<Integer> greaterTail = null;

        Node<Integer> otherHead = null;
        Node<Integer> otherTail = null;

        Node<Integer> tmpNode = head;

        while (tmpNode != null) {
            Node<Integer> newNode = new Node<Integer>(tmpNode.getValue(), null);

            if (tmpNode.getValue() > 100) {
                if (greaterHead == null) {
                    greaterHead = newNode;
                    greaterTail = newNode;
                } else {
                    greaterTail.setNext(newNode);
                    greaterTail = newNode;
                }
            } else {
                if (otherHead == null) {
                    otherHead = newNode;
                    otherTail = newNode;
                } else {
                    otherTail.setNext(newNode);
                    otherTail = newNode;
                }
            }
            tmpNode = tmpNode.getNext();
        }

        if (greaterHead == null) return otherHead;

        greaterTail.setNext(otherHead);

        return greaterHead;
    }


    /**
     * Function creates a linked list (Node) of integers
     *
     * @param array the array of integers to create the linked list
     * @return {@code Node<Integer>} heat of the created linked list
     */
    public static Node<Integer> createIntLinkedList(int[] array) {
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
    public static void printLinkedList(Node<Integer> head) {
        Node<Integer> tmp = head;

        for (; tmp != null; tmp = tmp.getNext())
            System.out.print(tmp.getValue() + ", ");
        System.out.println();

    }
}
