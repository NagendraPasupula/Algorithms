

/**
 * Remove duplicates from a sorted linked list
 * @author Venkata Nagendra Kumar Pasupula
 *
 */
public class DeleteDuplicate extends LinkedList{
	Node duplicates(Node head){
		if(head== null) return head;
		Node p = head;
		Node q = head;
		int prev = 0; int curr = 0;
		prev = q.value;
		p=p.next;
		while(q.next !=null){
			curr = p.value;
			if(curr == prev){
				p=p.next;
				q.next = p;
			}else{
				q=q.next;
				p=p.next;
				prev = q.value;
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
		DeleteDuplicate dd = new DeleteDuplicate();
		Node temp = dd.duplicates(l1.head);
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
