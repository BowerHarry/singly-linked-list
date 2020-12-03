public class LinkedList {
    private ListNode head = null;
    private ListNode tail = null;
    private int n = 0;

    public Object get(int i) {
        if (i<0 || i>=n) {
            return null;
        }
        ListNode node = head;
        for (int j=0; j<i; j++) {
            node = node.next;
        }
        return node.element;
    }
    public void insert(Object o, int i) {
        if (i<0 || i>n) {
            return;
        }
        if (i==0) {
            addFirst(o);
            return;
        }
        if (i==n){
            add(o);
            return;
        }
        ListNode node = head;
        for (int j=0; j<i-1; j++){
            node = node.next;
        }
        node.next = new ListNode(o, node.next);
        n++;
    }

    public void remove(int i) {
        if (i<0 || i>=n){
            return;
        }
        if (i==0) {
            head = head.next;
            if (n==1) {
                tail = null;
            }
            n--;
            return;
        }

        ListNode node = head;
        for (int j=0; j<i-1; j++){
            node = node.next;
        }
        node.next = node.next.next;
        if (i==n-1){
            tail = node;
        }
        n--;
    }

    public void addFirst(Object o) {
        if (head==null) {
            head = new ListNode (o, null);
            tail = head;
            n++;
            return;
        }
        head = new ListNode (o, head);
        n++;
    }

    public void add(Object o) {
        if (n==0){
            addFirst(o);
            return;
        }
        ListNode node = new ListNode(o, null);
        tail.next = node;
        tail = node;
        n++;
    }
}

