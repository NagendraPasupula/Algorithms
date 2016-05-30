/**
 * Check whether linked list had cycle.
 * @author Venkata Nagendra Kumar Pasupula
 *
 */
public class CycleList extends LinkedList{

	boolean hasCycle(Node head){
		if(head==null || head.next==null) return false;
		Node p = head;
		Node q = head.next.next;
		while(q!=null && q.next!=null){
			if(p==q) return true;
			else{
				p =p.next;
				q=q.next.next;
			}
		}
	return false;
	}
	public static void main(String[] args){
		LinkedList list = new LinkedList();
		Node p = list.new Node(2);
		p.next = list.new Node(3);
		p.next.next = list.new Node(4);
		p.next.next.next = list.new Node(5);
	//	p.next.next.next.next=null;
		p.next.next.next.next =p;
		CycleList cl = new CycleList();
		boolean k = cl.hasCycle(p);
		if(k) System.out.println("Has cycle");
		else System.out.println("No cycle");
		
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
}