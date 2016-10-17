/** You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            if(l2 != null){
                return l2;
            }
        }else if(l2 == null){
            if(l1 != null){
                return l1;
            }
        }
        // 进位标识，0 或 1
        int carry = 0;
        int sum = 0;
        ListNode p = l1;
        ListNode q = l2;
        // 链表 头结点
        ListNode firstNode = new ListNode(0);
        ListNode curr = firstNode;
        while(p != null || q != null){
            // x,y 设置为局部变量
            int x = 0;
            int y = 0;
            if(p != null){
               x = p.val;
               p = p.next;
            }
            if(q != null){
               y= q.val;
               q = q.next;
            }
            sum = x + y + carry;
            // 计算 进位 结果
            carry = sum / 10;
            // 创建新节点，val 为 sum % 10
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        // 循环结束，如果进位大于0, 说明还需创建后一个节点，val 为 carry
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
       return firstNode.next;
    }
}
