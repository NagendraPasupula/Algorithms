
/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * @author Venkata Nagendra Kumar Pasupula
 *
 */
public class CycleStarts extends LinkedList{
	Node cycle(Node head){
		if(head==null || head.next==null) return null;
		Node p = head.next;
		Node q = head.next.next;
		Node temp =null;
		while(q!=null && q.next!=null){
			if(p==q){
				temp= p;
				break;
			}
			else{
				p =p.next;
				q=q.next.next;
			}
		}
		if(temp != null){
			Node r = head;
			while(r!=temp){
				r =r.next;
				temp =temp.next;
			}
			return r;
		}
	return null;
	}
	
	public static void main(String[] args){
		LinkedList list = new LinkedList();
		Node p = list.new Node(2);
		p.next = list.new Node(3);
		p.next.next = list.new Node(4);
		p.next.next.next = list.new Node(5);
		p.next.next.next.next = list.new Node(6);
//		p.next.next.next.next.next=null;
		p.next.next.next.next.next =p.next.next;
		CycleStarts cl = new CycleStarts();
		Node temp = cl.cycle(p);
		if(temp !=null)
			System.out.println(temp.value);
		else 
			System.out.println("no cycle exists");
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