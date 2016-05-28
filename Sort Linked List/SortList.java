
/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * @author Venkata Nagendra Kumar Pasupula
 **/
public class SortList extends LinkedList{

	Node sort(Node head){
		if(head==null || head.next==null) return head;
		Node left= head, temp=head.next;
		while((temp !=null) && (temp.next != null)){
			head=head.next;
			temp = temp.next.next;
		}
		Node right =head.next;
		head.next=null;
		Node result = merge(sort(left), sort(right));
		return result;
	}

	 Node merge(Node left, Node right) {
		Node dummyhead= new Node(0);
		Node temp = dummyhead;
		while( left!=null && right!=null){
		if(left.value < right.value){
			temp.next = left;
			temp = left;
			left = left.next;
		}else{
			temp.next = right;
			temp =right;
			right = right.next;
		}}
		temp.next = (left==null)?right:left;
		return dummyhead.next;
	}
public static void main(String[] args){
	LinkedList l1 = new LinkedList();
	l1.add(2);
	l1.add(1);
	l1.add(5);
	l1.add(5);
	l1.add(3);
	l1.add(6);
	SortList sl = new SortList();
	Node temp = sl.sort(l1.head);
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