import unit4.collectionsLib.Node;
import java.util.Scanner;

public class inputFromUserToLinkedList {
    public static void main(String[] args) {

        Node<Integer> test=createUserLinkedList();
        printAllNodeVal(test);


    }

    public static Scanner scanner = new Scanner(System.in);

    /**
     * Function that creates an integer sorted linked list until user input is -99<br/>
     * Time Complexity: O(n²) because every new insertion traverses a growing list
     *
     * @return {@code Node<Integer>} head of new integer linked list
     */
    public static Node<Integer> createUserLinkedList(){
        Node<Integer> resultNode = null;
        Node<Integer> tmpNode = null;
        int userInput;
        while (true){
            System.out.println("Hello enter an integer, end of function -99:");
            userInput= scanner.nextInt();
            if (userInput== -99) break;

            if(resultNode==null)
                resultNode=new Node<Integer>(userInput, resultNode);

            else {
                tmpNode=insertToSortedNode(resultNode,userInput);
                resultNode=tmpNode;
            }

        }
        return resultNode;
    }
    /**
     * Inserts an integer into a sorted linked list while maintaining the sorted order
     *
     * @param head the head of the sorted linked list
     * @param num  the integer to insert
     * @return {@code Node<Integer>} updated head of the linked list
     */
    public static Node<Integer> insertToSortedNode(Node<Integer> head, int num) {
        Node<Integer> tmp = head;
        Node<Integer> numNode = new Node<Integer>(num);

        if (tmp != null) {

            if (head.getValue() < num) {
                for (; tmp.getNext() != null && tmp.getNext().getValue() < num; tmp = tmp.getNext()) ;
                numNode.setNext(tmp.getNext());
                tmp.setNext(numNode);
            } else {
                numNode.setNext(head);
                head = numNode;
            }

        } else head = numNode;
        return head;
    }
    /**
     * Function prints a linked list (Node) of integers
     *
     * @param head the head of linked list to print
     */
    public static void printAllNodeVal(Node<Integer> head) {
        Node<Integer> tmp = head;

        for (; tmp != null; tmp = tmp.getNext())
            System.out.print(tmp.getValue() + ", ");
        System.out.println();

    }
}
