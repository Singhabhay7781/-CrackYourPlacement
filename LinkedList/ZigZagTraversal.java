/*Node is as follows:

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    Node zigZag(Node head) {
        // add code here.
        if(head == null || head.next == null) {
             return head;
            }
    
        Node node = head;
        boolean flag = true;
    
        while(node.next != null) {
            if(flag) {
                if(node.data > node.next.data) {
                int t = node.data;
                node.data = node.next.data;
                node.next.data = t;
            }
            flag = !flag;
            } 
            else {
                if(node.data < node.next.data) {
                int t = node.data;
                node.data = node.next.data;
                node.next.data = t;
                }
                flag = !flag;
            }
            node = node.next;
        }
        return head;
    }
}