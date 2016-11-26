/**
 * 
 * @author Venkata Nagendra Kumar Pasupula
 *You are given two linked lists representing two non-negative numbers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 */

class Node{
	int val;
	Node next;
	Node head=null;
	Node(int val){
		this.val = val;
	}
	Node add(int[] x){
		for(int i=x.length-1;i>=0;i--){
			Node temp = new Node(x[i]);
			temp.next = head;
			head= temp;
		}
		return head;
	}
}
public class AddTwoNumbers {
	static int carry=0;
	public static Node AddTwoLists(Node list1, Node list2){
		if(list1 == null || list1 == null)
            return (list1 == null)?list2:list1;
		int length1=0, length2=0;
		Node temp1=list1, temp2=list2;
		while(temp1 != null || temp2 !=null){
			if(temp1!=null){
				length1++;
				temp1 = temp1.next;
			}
			if(temp2!=null){
				length2++;
				temp2 = temp2.next;
			}
		}
		Node result = addLists(list1, list2, (length1-length2));
		if(carry >0) {
		Node newNode = new Node(1);
		newNode.next = result;
		result = newNode;
		}
		return result;	
	}
	public static Node addLists(Node l1, Node l2, int diff){
		 if(l1 == null && l2==null) return null;
	        Node result = new Node(0);
	        if(diff >0){
	            result.next = addLists(l1.next, l2, diff-1);
	            result.val = l1.val+carry;
	        }
	        if(diff<0){
	            result.next = addLists(l1, l2.next, diff+1);
	            result.val = l2.val+carry;
	        }
	        if(diff==0){
	            result.next = addLists(l1.next, l2.next, diff);
	            result.val = l1.val+l2.val+carry;
	        }
	        carry = (result.val)/10;
	        result.val =(result.val)%10;
	        return result;
	}
	public static void main(String[] args){
		Node list1 = new Node(0);
		list1 = list1.add(new int[]{9});
		Node list2 = new Node(0);
		list2=	list2.add(new int[]{9});
		Node result = AddTwoLists(list1,list2);
	while(result != null) {
		System.out.println(result.val);	
		result = result.next;
	}
	}
	
}

