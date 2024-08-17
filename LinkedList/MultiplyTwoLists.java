/*Node is defined as
class Node
{
    int data;
    Node next;
    Node(int data) {
        this.data=data;
        this.next = null;
    }
}*/

class Solution {
    private static final int MOD = 1000000007;

    public long multiplyTwoLists(Node first, Node second) {
        // Initialize the two numbers as 0
        long num1 = 0, num2 = 0;

        // Traverse the first list and calculate its value
        while (first != null) {
            num1 = (num1 * 10 + first.data) % MOD;
            first = first.next;
        }

        // Traverse the second list and calculate its value
        while (second != null) {
            num2 = (num2 * 10 + second.data) % MOD;
            second = second.next;
        }

        // Multiply the two numbers and return the result modulo 10^9+7
        return (num1 * num2) % MOD;
    }
}