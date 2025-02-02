import unit4.collectionsLib.Node;

public class copyStringLinkedList {
    public static void main(String[] args) {
        Node<String> testNode = null;
        String[] array = {"ab", "bc", "cd", "de"};
        Node<String> hTest = createLinkedList(array);
        printAllNodeVal(hTest);
        Node<String> resTest = copyOfStringLinkedList(hTest);
        printAllNodeVal(resTest);

    }

    /**
     * Copy of the string linked list
     *
     * @param head the head of string linked list
     * @return {@code Node<String>} new linked list head of strings
     */
    public static Node<String> copyOfStringLinkedList(Node<String> head) {
        Node<String> tmp = head;
        Node<String> newNode = null;
        Node<String> resNode = null;

        if (tmp != null) {
            while (tmp != null) {
                newNode = new Node<String>(tmp.getValue(), newNode);
                tmp = tmp.getNext();
            }
            while (newNode != null) {
                resNode = new Node<String>(newNode.getValue(), resNode);
                newNode = newNode.getNext();
            }
        }
        return resNode;
    }

    /**
     * Function creates a linked list (Node) of integers
     *
     * @param array the array of integers to create the linked list
     * @return {@code Node<Integer>} heat of the created linked list
     */
    public static Node<String> createLinkedList(String[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        Node<String> head = null;
        for (int i = array.length - 1; i > -1; i--) {
            head = new Node<String>(array[i], head);
        }
        return head;
    }

    /**
     * Function prints a linked list (Node) of integers
     *
     * @param head the head of linked list to print
     */
    public static void printAllNodeVal(Node<String> head) {
        Node<String> tmp = head;

        for (; tmp != null; tmp = tmp.getNext())
            System.out.print("" + tmp.getValue() + ", ");
        System.out.println();

    }
}
