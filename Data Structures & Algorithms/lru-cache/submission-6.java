class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = null;
        tail = null;
    }

    private void moveToHead(Node curr) {

        if (curr == head) return;

        // Remove curr from its current position
        if (curr.prev != null)
            curr.prev.next = curr.next;

        if (curr.next != null)
            curr.next.prev = curr.prev;

        // If curr was the tail, update tail
        if (curr == tail)
            tail = curr.prev;

        // Insert curr at the head
        curr.prev = null;
        curr.next = head;

        if (head != null)
            head.prev = curr;

        head = curr;

        if (tail == null)
            tail = curr;
    }

    public int get(int key) {

        if (!map.containsKey(key))
            return -1;

        Node curr = map.get(key);

        moveToHead(curr);

        return curr.value;
    }

    public void put(int key, int value) {

        // Key already exists
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            curr.value = value;
            moveToHead(curr);
            return;
        }

        // Create new node
        Node curr = new Node(key, value);

        moveToHead(curr);

        map.put(key, curr);

        // Evict least recently used
        if (map.size() > capacity) {

            map.remove(tail.key);

            tail = tail.prev;

            if (tail != null)
                tail.next = null;
        }
    }
}