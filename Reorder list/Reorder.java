
/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * @author Venkata Nagendra Kumar Pasupula
 *
 */
public class Reorder extends LinkedList{
	Node reorderList(Node head){
		if(head==null || head.next==null) return head;
		Node p = head, q = head.next.next;
		while(q!=null && q.next!=null){
			p=p.next;
			q=q.next.next;
		}
		if(q!=null){
			q = p.next.next;
			p.next.next=null;
		}else{
			q = p.next;
			p.next = null;
		}
		Node dummyhead = new Node(0);
		dummyhead.next = q;
		while(q.next != null){
			Node r = q.next;
			q.next = r.next;
			r.next = dummyhead.next;
			dummyhead.next = r;
		}
		Node temp = head;
		dummyhead = dummyhead.next;
		while(dummyhead !=null){
			Node temp1 = dummyhead.next;
			dummyhead.next= temp.next;
			temp.next = dummyhead;
			temp =temp.next.next;
			dummyhead = temp1;
		} 
		return head;
	}
	public static void main(String[] args){
		LinkedList l1 = new LinkedList();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		l1.add(6);
		l1.add(7);
		Reorder r = new Reorder();
		Node temp = r.reorderList(l1.head);
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