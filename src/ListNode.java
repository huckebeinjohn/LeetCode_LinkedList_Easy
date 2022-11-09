public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public void insertAfter(int val) {
    this.next/* this is the new value */ = new ListNode(val, next);// this is the old value
  }

  public String toString() {
    return val + "";
  }
}
