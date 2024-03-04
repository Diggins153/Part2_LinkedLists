package utils;

import business.Song;

/**
 *
 * @author michelle
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int size;


    public int size() {
        return size;
    }
    public Song get(int position)
    {
        if (position < 0 || position >= size)
        {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        Node current = head;
        for (int i = 0; i < position; i++)
        {
            current = current.next;
        }

        return current.data;
    }
    public int indexOf(Song song)
    {
        Node current = head;
        int index = 0;

        while (current != null)
        {
            if (current.data.equals(song))
            {
                return index;
            }

            current = current.next;
            index++;
        }

        return -1;
    }

    public void add(Song song) {
        if (!contains(song)) {
            Node newNode = new Node(song);

            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            size++;
        }
    }
    public boolean isEmpty()
    {
        return size == 0;
    }

    public Song tail()
    {
        if (isEmpty())
        {
            throw new IllegalStateException("List is empty");
        }

        return tail.data;
    }

    public void addAll(Song[] songs) {
        for (Song song : songs) {
            add(song);
        }
    }

    private boolean contains(Song song) {
        Node current = head;

        while (current != null) {
            if (current.data.equals(song)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    private static class Node {
        public Song data;
        public Node next;
            public Node(Song data) {
                this.data = data;
                this.next = null;
               }
    }
}
