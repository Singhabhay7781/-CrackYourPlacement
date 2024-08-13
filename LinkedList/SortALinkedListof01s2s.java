public class Solution {

    // Sort Linked List of 0s, 1s and 2s by updating data of nodes – O(N) Time and O(1) Space:
    public static void sortList(Node head) {
        // Initialize count of '0', '1' and '2' as 0
        int[] cnt = { 0, 0, 0 };
        Node ptr = head;

        // Traverse and count total number of '0', '1' and '2'
        // cnt[0] will store total number of '0's
        // cnt[1] will store total number of '1's
        // cnt[2] will store total number of '2's
        while (ptr != null) {
            cnt[ptr.data] += 1;
            ptr = ptr.next;
        }

        int idx = 0;
        ptr = head;
        
        // Fill first cnt[0] nodes with value 0
        // Fill next cnt[1] nodes with value 1
        // Fill remaining cnt[2] nodes with value 2
        while (ptr != null) {
            if (cnt[idx] == 0)
                idx += 1;
            else {
                ptr.data = idx;
                cnt[idx] -= 1;
                ptr = ptr.next;
            }
        }
    }


// Sort Linked List of 0s, 1s and 2s by updating link of nodes – O(N) Time and O(1) Space:
    static Node sortList2(Node head) {
        if (head == null || head.next == null) 
            return head; 

        // Create three dummy nodes to point to beginning of 
        // three linked lists. These dummy nodes are created to 
        // avoid null checks. 
        Node zeroD = new Node(0); 
        Node oneD = new Node(0); 
        Node twoD = new Node(0);

        // Initialize current pointers for three 
        // lists 
        Node zero = zeroD, one = oneD, two = twoD; 

        // Traverse list 
        Node curr = head; 
        while (curr != null) { 
            if (curr.data == 0) { 
                  
                // If the data of current node is 0, 
                // append it to pointer zero and update zero
                zero.next = curr; 
                zero = zero.next; 
            } 
            else if (curr.data == 1) { 
                  
                // If the data of current node is 1, 
                // append it to pointer one and update one
                one.next = curr; 
                one = one.next; 
            } 
            else { 
                  
                // If the data of current node is 2, 
                // append it to pointer two and update two
                two.next = curr; 
                two = two.next; 
            } 
            curr = curr.next; 
        } 

        // Combine the three lists
        zero.next = (oneD.next != null) ? (oneD.next) : (twoD.next); 
        one.next = twoD.next; 
        two.next = null; 
          
        // Updated head 
        head = zeroD.next; 

        return head; 
    } 

}