/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 <= m <= n <= length of list.
 * @author Venkata Nagendra Kumar Pasupula
 *
 */


public class ReverseList2 extends LinkedList{
	Node reverseList2(Node head, int m, int n){
		if(head==null || head.next==null) return head;
		Node dummyhead = new Node(0);
        dummyhead.next = head;
        Node p = dummyhead;
        for(int i = 0 ; i < m-1 ; i++){
            p = p.next;
        }
        Node q = p.next;
        for(int i = 0 ; i < n-m ; i++){
        	Node r = q.next;
            q.next = r.next;
            r.next = p.next;
            p.next = r;
        }
        return dummyhead.next;
	}
	public static void main(String[] args){
		LinkedList l1 = new LinkedList();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		l1.add(6);
		ReverseList2 rl = new ReverseList2();
		Node temp = rl.reverseList2(l1.head,1,6);
		while(temp !=null){
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
}
class LinkedList {
	class Node{
		int value;
		Node next;
		Node(int x){
			value = x;
		}
	}
	Node head;
	public void add(int x){
		Node temp1 = head;
		Node temp = new Node(x);
		temp.next = null;
		if(head == null){
			head = temp;
		}else{
			while(temp1.next != null){
				temp1 = temp1.next;
			}
			temp1.next = temp;
		}
	}
}