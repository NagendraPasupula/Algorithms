/**
 * Given a list, rotate the list to the right by k places, where k is non-negative and may be greater than length of list.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * @author Venkata Nagendra Kumar Pasupula
 *
 */
public class RotateK extends LinkedList{
	
	Node rotate(Node head, int k){
		 if (head == null || k == 0 || head.next == null) return head;
	        int len_list = 1;
	        Node p = head;
	        Node q = head;
	        while (p.next != null) {
	        	p = p.next;
	        	len_list++;
	        }
	        if (k % len_list == 0) return head;
	        k = len_list - (k % len_list);
	        Node temp = head;
	        for (int i = 1; i < k; i++) {
	            temp = temp.next;
	        }
	        q = temp.next;
	        temp.next = null;
	        p.next = head;         
	        return q;
	    }
	
	public static void main(String[] args){
		LinkedList l1 = new LinkedList();
		l1.add(1);
		l1.add(2);
		l1.add(3);
//		l1.add(4);
//		l1.add(5);
		RotateK rk = new RotateK();
		Node temp = rk.rotate(l1.head, 20);
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

