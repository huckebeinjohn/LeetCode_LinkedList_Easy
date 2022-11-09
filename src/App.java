import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.management.ListenerNotFoundException;
import javax.swing.event.ListSelectionListener;

public class App {
    public static void main(String[] args) throws Exception {
        // LinkedList<Integer> list1 = new LinkedList<>();
        // LinkedList<Integer> list2 = new LinkedList<>();

        // list1.add(1);
        // list1.add(2);
        // list1.add(4);

        // list2.add(1);
        // list2.add(3);
        // list2.add(4);
        // System.out.println("list1: " + list1);
        // System.out.println("list2: " + list2);

        // mergeTwoLinkedList(list1, list2);

        ListNode node1 = new ListNode(2, new ListNode(4, new ListNode(6)));
        node1.insertAfter(0);
        while (node1.next != null) {
            System.out.println("node1:" + node1.val);
            node1 = node1.next;
        }
        System.out.println("node1:" + node1.val);

        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        mergeTwoLists(node1, node2);

    }

    public static LinkedList mergeTwoLinkedList(LinkedList l1, LinkedList l2) {
        LinkedList<Integer> mergedLinkedList = new LinkedList<>();
        for (int i = 0; i < l1.size(); i++) {
            System.out.println(l1.get(i));
        }
        return mergedLinkedList;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode temp_node = new ListNode(0);
        ListNode current_node = temp_node;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current_node.next = l1;
                l1 = l1.next;
            } else {
                current_node.next = l2;
                l2 = l2.next;
            }

            current_node = current_node.next;
        }

        if (l1 != null) {
            current_node.next = l1;
            l1 = l1.next;
        }
        if (l2 != null) {
            current_node.next = l2;
            l2 = l2.next;
        }
        while (temp_node.next != null) {
            System.out.println(temp_node.next);
            temp_node = temp_node.next;
        }
        temp_node.toString();
        return temp_node.next;
    }

    // Linked List Cycle.
    public static boolean hascycle(ListNode head) {

        if (head == null) {
            return false;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;

        while (slowPointer != fastPointer) {

            if (fastPointer == null || fastPointer.next == null) {
                return false;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return true;
    }

    // 160. Intersection of Two Linked Lists
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        while (pointerA != pointerB) {
            if (pointerA == null) {
                pointerA = headB;
            } else {
                pointerA = pointerA.next;
            }

            if (pointerB == null) {
                pointerB = headA;
            } else {
                pointerB = pointerB.next;
            }
        }

        return pointerA;
    }

}
