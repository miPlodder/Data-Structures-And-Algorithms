package datastructures.hashmap;

/**
 * Custom Implementation of Map using Separate Chaining Technique to handle Collisions
 */
public class StringMap {

    private static final float LOAD_FACTOR = 0.7f;

    private Node[] values;
    // # of nodes in map
    private int size;
    // capacity of map
    private int capacity;

    private class Node {
        String key;
        String value;
        Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public StringMap(int initialCapacity) {
        this.size = 0;
        this.capacity = initialCapacity;
        this.values = new Node[this.capacity];
    }

    private int hash(String key) {
        int weightedSum = 0;
        for (int i = 1; i <= key.length(); i++) {
            weightedSum += (key.charAt(i - 1) * i);
        }
        return weightedSum % values.length;
    }

    private void rehash() {
        Node[] oldValues = this.values;
        this.capacity = (this.capacity * 2) + 1;
        this.values = new Node[this.capacity];
        this.size = 0;
        for (Node node : oldValues) {
            Node temp = node;
            while (temp != null) {
                insert(temp.key, temp.value);
                temp = temp.next;
            }
        }
    }

    public void insert(String key, String value) {
        int idx = hash(key);
        Node node = new Node(key, value);

        //Insertion ath head of linkedList
        node.next = values[idx];
        values[idx] = node;
        this.size++;
        if (LOAD_FACTOR < (this.size * 1.0) / this.capacity) {
            rehash();
        }
    }

    public Node search(String key) {
        int idx = hash(key);
        Node node = this.values[idx];

        while (node != null) {
            if (node.key == key) return node;
            node = node.next;
        }
        return null;
    }

    public void delete(String key) {
        int idx = hash(key);
        Node node = values[idx], prev = null;
        while (node != null) {
            if (node.key == key) {
                if (prev == null) {
                    values[idx] = node.next;
                } else {
                    prev.next = node.next;
                }
            }
            prev = node;
            node = node.next;
        }
    }

    public void print() {
        for (Node node : values) {
            System.out.print("[");
            while (node != null) {
                System.out.print(node.value + " , ");
                node = node.next;
            }
            System.out.println("]");
        }
    }
}
