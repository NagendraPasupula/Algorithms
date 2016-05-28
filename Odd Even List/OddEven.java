
/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
   The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.
The first node is considered odd, the second node even and so on ...
 * @author Venkata Nagendra Kumar pasupula
 *
 */
public class OddEven extends LinkedList{
	Node oddevenlist(Node head){
		if(head==null || head.next==null || head.next.next==null) return head;
		Node p= head;
		Node q=head.next;
		Node temp= q;
		while(p.next!=null && q.next !=null){
			p.next = p.next.next;
			q.next = q.next.next;
			p=p.next;
			q=q.next;
		}
		p.next =temp;
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
		l1.add(8);
		OddEven rl = new OddEven();
		Node temp = rl.oddevenlist(l1.head);
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
