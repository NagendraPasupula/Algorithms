
/**
 * Remove all elements from a linked list of integers that have value k.
Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, k = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 * @author Venkata Nagendra Kumar Pasupula
 *
 */

public class RemoveElements extends LinkedList{
	Node removeElements(Node head, int k){
		if(head==null) return null;
		Node dummyhead = new Node(0);
		dummyhead.next = head;
		Node temp =  dummyhead;
		while(temp.next != null){
			if(temp.next.value == k){
				temp.next = temp.next.next;
			}else{
				temp =temp.next;
			}
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
		RemoveElements rl = new RemoveElements();
		Node temp = rl.removeElements(l1.head,6);
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