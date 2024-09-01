

/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution {
    Node compute(Node head) {
        // your code here
        Node revHead = reverse(head);
        int max = revHead.data;
        
        Node curr = revHead;
        while(curr.next != null){
            if(curr.next.data < max){
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
                max = curr.data;
            }
        }
        
        Node newHead = reverse(revHead);
        return newHead;
    }
    
    public Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}