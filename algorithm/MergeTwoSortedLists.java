/**
  Merge two sorted linked lists and return it as a new list. 
  The new list should be made by splicing together the nodes of the first two lists.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //如果两个节点都为空，则返回null
         if(l1 == null){
            if(l2 != null){
                return l2;
            }
        }else if(l2 == null){
            if(l1 != null){
                return l1;
            }
        }
        //实例化一个根节点
        ListNode root = new ListNode(0);
        //必须进行引用传递，不能直接对l1,l2操作
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = root;
        while(p != null && q != null){
            // 需要比较节点值的大小
            if(p.val < q.val){
                curr.next = p;
                p = p.next;
            }else{
                curr.next = q;
                q = q.next;
            }
            curr =curr.next;
        }
        if(p != null){
            curr.next = p;
            p= p.next;
            curr =curr.next;
        }
        if(q != null){
            curr.next = q;
            q = q.next;
            curr =curr.next;
        }
        return root.next;
    }
}
