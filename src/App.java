import java.util.ArrayList;
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

        // ListNode node1 = new ListNode(2, new ListNode(4, new ListNode(6)));
        // node1.insertAfter(0);
        // while (node1.next != null) {
        // System.out.println("node1:" + node1.val);
        // node1 = node1.next;
        // }
        // System.out.println("node1:" + node1.val);

        // ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        // mergeTwoLists(node1, node2);

        ListNode testingNode = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(1))));
        // while (testingNode.next != null) {
        // System.out.println("node1:" + testingNode.val);
        // testingNode = testingNode.next;
        // }

        printNode(testingNode);
        ListNode testingNodeReversed = reversed(testingNode);
        printNode(testingNodeReversed);

        boolean result = palindromeLinkedListVersionTesting(testingNode);
        System.out.println(result);

    }

    // TestingMethod: Print the god damn node;
    public static void printNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println("endOfList");
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

    // 206. Reverse Linked List.
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null; // declare prev to save the previous node;
        ListNode next_N = null; // devlare next_N to save the next node;
        while (head != null) { // loop condition;
            next_N = head.next; // saving the next object to next_N;
            head.next = prev; // pointing the current node to opposite direction(prev);
            prev = head; // saving the current object to prev;
            head = next_N; // move to the next node.
        }

        return prev;
    }

    // 234. Palindrome Linked List.(Converting Linked list into arrayList, slow but
    // works)
    public static boolean palindromeLinkedListVersion1(ListNode head) {
        ArrayList<Integer> arraylist = new ArrayList<>();
        while (head != null) {
            arraylist.add(head.val);
            head = head.next;
        }
        int leftPointer = 0;
        int rightPointer = arraylist.size() - 1;

        while (leftPointer <= rightPointer) {
            if (arraylist.get(leftPointer) != arraylist.get(rightPointer)) {
                return false;
            }
            leftPointer += 1;
            rightPointer -= 1;
        }
        return true;
    }

    // 234. Palindrome linked List. (Using fast and slow pointer to find the middle
    // position of the linked list)
    public static boolean palindromeLinkedListVersion2(ListNode head) {
        // declare fast and slow pointer;
        ListNode fast = head;
        ListNode slow = head;
        // have both pointers loop thorugh the linked list.
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // again, fast pointer is moving two time faster:)
            slow = slow.next;
        }
        // reset both pointer to its starting positon.
        fast = head;
        slow = reverseList(slow);
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    // 234. Palindrome Linked List (method to reverse the linked list)
    public static ListNode reversed(ListNode head) {
        ListNode prev = null;
        ListNode next_N = null;
        while (head != null) {
            next_N = head.next;
            head.next = prev;
            prev = head;
            head = next_N;
        }
        return prev;
    }

    // TODO: fix this code.
    public static boolean palindromeLinkedListVersionTesting(ListNode head) {
        ListNode originList = head;
        ListNode reversedList = reversed(head);

        while (originList != null) {
            if (originList.val != reversedList.val) {
                return false;
            }
            originList = originList.next;
            reversedList = reversedList.next;
        }
        return true;
    }
}
