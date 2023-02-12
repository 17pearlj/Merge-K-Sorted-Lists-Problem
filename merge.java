/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public class Entry implements Comparable<Entry> {
        private ListNode node;

        public Entry(ListNode node) {
            this.node = node;
        }

        @Override
        public int compareTo(Entry other) {
            return Integer.compare(this.node.val, other.node.val);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Entry> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(new Entry(lists[i]));
            }
            
        }

        ListNode head = null;
        ListNode prev = null;
        ListNode node;
        
        while (!pq.isEmpty()) {
            node = pq.poll().node;
            if (head == null) {
                head = node;
            }
            if (node.next != null) {
                pq.add(new Entry(node.next)); 
            }
            if (prev != null) {
                prev.next = node;
            }
            node.next = null;
            prev = node;
        }

        return head;
    }
}


