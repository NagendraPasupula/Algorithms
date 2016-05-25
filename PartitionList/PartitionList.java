/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 * @author Venkata Nagendra Kumar Pasupula
 *
 */
public class PartitionList extends LinkedList{

	Node partition(Node head, int x){
		if(head==null || head.next==null) return head;
		Node p = head;
		Node q = head;
		Node r= head.next;
		int counter =0;
		while(p !=null){
			if(p.value >=x){
				if(counter==0){r = p; counter++;}
				q=p;
				p=p.next;
				}else if(p==head){break;}
			else{
				head=p;
				p=p.next;
				head.next=null;
				head.next =r;
				q.next=p;
				p=head;
				break;
			}
		}
		while(q.next !=null){
			if(q.next.value < x && p==q){
				q=q.next;
				p=p.next;
			}
			else if(q.next.value < x ){
					Node temp =q.next;
					q.next=temp.next;
					temp.next=null;
					p.next = temp;
					temp.next =r;
					p=p.next;
			}else{
				if(counter==0){ r = q.next; counter++;}
				q = q.next;
			}
		}
		return head;
	}
	public static void main(String[] args){
		LinkedList l1 = new LinkedList();
		l1.add(1);
		l1.add(4);
		l1.add(3);
		l1.add(2);
		l1.add(5);
		l1.add(2);
		PartitionList pl = new PartitionList();
		Node temp = pl.partition(l1.head, 1);
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