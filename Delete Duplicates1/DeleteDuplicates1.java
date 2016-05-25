/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 * @author Venkata Nagendra Kumar Pasupula
 *
 */
public class DeleteDuplicates1 extends LinkedList{
	Node duplicates1(Node head){
		if(head== null) return head;
		Node p = head;
		int prev = 2147483647;   
		while(p == head && head !=null){
			if(head.next==null && head.value==prev) return null;
			else if(head.next==null && head.value !=prev) return head;
			if((head.value==head.next.value) || (head.value == prev)){
				prev = head.value;
				head = head.next;
				p =head;
			}else{
				p=p.next;
			}
		}
		p=head;
		Node q = p.next;
		while(q != null){
			int qval = (q.next!=null)?(q.next.value):-1;
			if(q.value != prev && q.value != qval){
				prev=q.value;
				q = q.next;
				p=p.next;
			}else{
				prev = q.value;
				q=q.next;
				p.next = q;
			}
		}
		return head;
	}
	public static void main(String[] args){
		LinkedList l1 = new LinkedList();
		l1.add(1);
		l1.add(2);
		l1.add(2);
		l1.add(2);
		l1.add(3);
		l1.add(3);
		l1.add(3);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		DeleteDuplicates1 dd = new DeleteDuplicates1();
		Node temp = dd.duplicates1(l1.head);
		while(temp != null){
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
	public Node reverse(Node list){
		Node l1 = list;
		Node l2 = list.next;
		list.next = null;
		while(l1!=null && l2!=null){
			Node temp = l2.next;
			l2.next = l1;
			l1=l2;
			if(temp != null)
				l2=temp;
			else
				break;
		}
		return l1;
	}
	void display(){
		Node temp = head;
		while(temp != null){
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
}