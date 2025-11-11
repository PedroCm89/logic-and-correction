package org.example.date.structure.linkedList;

/**
 * Class implementing a simple Singly Linked List data structure
 * to manage objects of type Book.
 * <p>
 * This implementation provides core linked list operations such as
 * insertion, deletion, and retrieval by position.
 * </p>
 * * @author [Pedro Carrasco Mora]
 * @version 1.1
 * @since 2025-11-11
 */
public class List {
    private Node head = null;
    private int length = 0;

    /**
     * Default constructor for the list.
     * Initializes the list to an empty state.
     */
    public List() {
    }

    /**
     * Inner class representing each element (node) in the list.
     */
    private class Node {
        public Book book;
        public Node next = null;

        /**
         * Creates a new node with the specified book.
         * @param book The Book object this node will contain.
         */
        public Node(Book book) {
            this.book = book;
        }
    }

    /**
     * Inserts a new node at the beginning (head) of the list.
     * This is an O(1) operation.
     * @param book The book to insert.
     */
    public void insertFirst(Book book) {
        Node node = new Node(book);
        node.next = head;
        head = node;
        length++;
    }
    /**
     * Inserts a new node at the end of the list.
     * If the list is empty, it behaves like {@link #insertFirst(Book)}.
     * This is an O(n) operation due to list traversal.
     * @param book The book to insert.
     */
    public void insertEnd(Book book) {

        if (isEmpty()) {
            insertFirst(book);
        } else {
            Node pointer = head;
            Node node = new Node(book);

            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = node;
            length++;
        }

    }

    /**
     * Inserts a new node at a specific position (0-based index) in the list.
     * If position is 0 or the list is empty, it delegates to {@link #insertFirst(Book)}.
     * If position is greater than the current length, the book is inserted at the end.
     * @param position The position (0-based index) where the book will be inserted.
     * @param book The book to insert.
     */
    public void insertPosition(int position, Book book) {
        Node node = new Node(book);

        if (isEmpty()||position==0) {
            insertFirst(book);
        } else {
            Node pointer = head;
            int counter = 0;

            while (counter < (position - 1) && pointer!= null) {
                pointer = pointer.next;
                counter++;
            }
            node.next = pointer.next;
            pointer.next = node;
            length++;
        }

    }

    /**
     * Retrieves the Book object located at the specified position (0-based index).
     * @param position The position of the book to retrieve.
     * @return The Book object at the position, or {@code null} if the position is invalid
     * or the list is empty.
     */
    public Book getBookPosition(int position) {
        if (isEmpty()) {
            return null;
        } else {
            Node pointer = head;
            int counter = 0;

            while (counter < position && pointer.next != null) {
                pointer = pointer.next;
                counter++;
            }
            if (counter != position) {
                return null;
            } else {
                return pointer.book;
            }

        }
    }

    /**
     * Returns the current number of elements in the list.
     * @return The length of the list.
     */
    public int getLength() {
        return length;
    }

    /**
     * Checks if the list is empty.
     * @return {@code true} if head is null, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Deletes the first node (head) of the list.
     * Ensures the deleted node is unlinked.
     * If the list is empty, it does nothing (robustness check).
     */
    public void delteFirst() {
        Node delte = head;
        head = head.next;
        delte.next = null;
        length--;
    }
    /**
     * Deletes the last node of the list.
     * If the list is empty, it does nothing.
     */
    public void deleteEnd() {
        if (!isEmpty()) {
            if (head.next == null) {
                head = null;
                length--;
            } else {
                Node pointer = head;
                while (pointer.next.next != null) {
                    pointer = pointer.next;
                }
                pointer.next = null;
                length--;
            }
        }
    }
/**
 * Deletes the node located at the specified position (0-based index).
 * Delegates to {@link #deleteFirst()} if position is 0.
 * If the position is out of range [0, length-1], it does nothing.
 * @param position The position of the node to delete.
 *      */
    public void deleteBookPsition(int position) {
        if (!isEmpty()) {
            if (position == 0) {
                Node first = head;
                head = head.next;
                first.next = null;
                length--;
            } else if (position < length) {
                Node pounter = head;
                int counter = 0;
                while (counter < (position - 1)) {
                    pounter = pounter.next;
                    counter++;
                }
                Node temporal = pounter.next;
                pounter.next = temporal.next;
                temporal.next = null;
                length--;
            }
        }
    }
}
