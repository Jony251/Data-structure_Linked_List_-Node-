import unit4.collectionsLib.Node;

public class reduceSequencesOfCharsInLinkedList {
    public static void main(String[] args) {
        char[] array = {'a', 'a', 'a', 'a', 'b', 'b', 'b', 'b', 'c', 'w', 'w', 'w', 'w', 'w', 'w'};

        Node<Character> result = null;
        Node<Character> test = createCharLinkedList(array);
        printAllNodeVal(test);

        result = reduceSequencesOfChars(test);
        printAllNodeVal(result);


    }

    /**
     * Removes consecutive duplicate characters from a linked list of characters
     * Time Complexity: O(n) + O(n) = O(n)  runs in O(n) because for a single-pass traversal
     *
     * @param head the head of characters linked list
     */
    private static Node<Character> reduceSequencesOfChars(Node<Character> head) {
        Node<Character> tmpHead = head;
        Node<Character> resHead = null;

        while (tmpHead != null) {
            resHead = new Node<Character>(tmpHead.getValue(), resHead);

            for (; tmpHead.hasNext() && tmpHead.getValue() == tmpHead.getNext().getValue(); tmpHead = tmpHead.getNext())
                ;
            tmpHead = tmpHead.getNext();
        }

        head = null;

        while (resHead != null) {
            head = new Node<Character>(resHead.getValue(), head);
            resHead = resHead.getNext();
        }

        return head;
    }

    /**
     * Function creates a linked list (Node) from array
     *
     * @param array the array of chars to create the linked list
     * @return {@code Node<Character>} heat of the created linked list
     */
    public static Node<Character> createCharLinkedList(char[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        Node<Character> head = null;
        for (int i = array.length - 1; i > -1; i--) {
            head = new Node<Character>(array[i], head);

        }
        return head;
    }


    /**
     * Function prints a linked list (Node)
     *
     * @param head the head of linked list to print
     */
    public static void printAllNodeVal(Node<Character> head) {
        Node<Character> tmp = head;

        for (; tmp != null; tmp = tmp.getNext())
            System.out.print(tmp.getValue() + ", ");
        System.out.println();

    }
}
