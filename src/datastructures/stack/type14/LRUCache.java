package datastructures.stack.type14;

import java.util.HashMap;

//https://leetcode.com/problems/lru-cache/
public class LRUCache {

    public static void main(String[] args) {
        LRUCacheImpl cache = new LRUCacheImpl(3);
        System.out.println(cache.get(1));
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        System.out.println(cache.get(1));
        cache.put(4, 40);
        cache.put(5, 50);
        cache.print();
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.put(6, 60);
        cache.put(7, 70);
        cache.put(8, 80);
        cache.print();
    }

    private static class LRUCacheImpl {
        int capacity;
        HashMap<Integer, Node> map;
        Node start, end;

        public LRUCacheImpl(int _capacity) {
            capacity = _capacity;
            map = new HashMap<>();
            start = new Node(0, 0);
            end = new Node(0, 0);
            start.next = end;
            end.prev = start;
        }

        public void put(int key, int val) {
//            update cache and remove in-between node
            if (map.containsKey(key)) {
                remove(map.get(key));
            } else {
//                insert in cache
                if (map.size() == capacity) {
//                    removing from tail end
                    remove(end.prev);
                }
            }
            insert(new Node(key, val));
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node oldNode = map.get(key);
                remove(oldNode);
                insert(new Node(oldNode.key, oldNode.val));
                return oldNode.val;
            }
            return -1;
        }

        public void print() {
            System.out.println("Cache Contents => " + map.keySet());
        }

        /**
         * Insert node next to head always
         *
         * @param node
         */
        private void insert(Node node) {
            map.put(node.key, node);
            node.next = start.next;
            node.prev = start;
            start.next = node;
            node.next.prev = node;
        }

        /**
         * Remove node, either from prev of tail or anywhere in between
         *
         * @param node
         */
        private void remove(Node node) {
            map.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    private static class Node {
        int key, val;
        Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
