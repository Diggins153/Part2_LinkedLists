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

    /**
     * Returns the number of songs in the list
     * @return The size of the list.
     */

    public int size() {
        return size;
    }

    /**
     * Retrieves the song at the specified position in the list
     * @param position The position of the song to retrieve
     * @return The Song at the specified position
     * @throws IndexOutOfBoundsException if the position is out of bounds
     */

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

    /**
     * Finds the index of the specified song in the list
     * @param song The Song to find in the list
     * @return The index of the Song or -1 if not found
     */
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

    /**
     * Adds a new song to the end of the list if it doesn't already exist
     * @param song The Song to be added.
     */
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

    /**
     * Checks if the list is empty
     * @return true if the list is empt false otherwise
     */

    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Retrieves the last song in the list
     * @return The last Song in the list
     * @throws IllegalStateException if the list is empty
     */
    public Song tail()
    {
        if (isEmpty())
        {
            throw new IllegalStateException("List is empty");
        }

        return tail.data;
    }

    /**
     * Adds all songs from the given array to the list avoiding duplicates
     * @param songs The array of Songs to be added
     */
    public void addAll(Song[] songs) {
        for (Song song : songs) {
            add(song);
        }
    }

    /**
     * Private helper method to check if the list contains a specific Song
     * @param song The Song to check for in the list
     * @return true if the Song is found in the list false otherwise
     */    private boolean contains(Song song) {
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
