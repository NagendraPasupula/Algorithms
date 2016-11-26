/**
 * 
 * @author Venkata Nagendra Kumar Pasupula
 *Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
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
class TreeNode {
	  int val;
	  TreeNode left;
	  TreeNode right;
	  TreeNode(int x) { val = x; }
}
public class ListToBST {
	static Node list1 = null;
	public static TreeNode sortedListToBST(Node head) {
		if(head==null) return null;
		int length=0;
		Node temp = head;
		while(temp != null){
			temp=temp.next;
			length++;
		}
		TreeNode result = toBST(length);
        return result;
    }
	public static TreeNode toBST(int length){
		if(length <= 0) return null;
		TreeNode left = toBST(length/2);
		TreeNode root = new TreeNode(list1.val);
		root.left = left;
		list1 = list1.next;
		root.right = toBST(length-(length/2)-1);
		return root;
	}
	static void preOrder(TreeNode root) 
    {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
	public static void main(String[] args){
		list1 = new Node(0);
		list1 = list1.add(new int[]{1,2,3,4,5});
		TreeNode result = sortedListToBST(list1);
		preOrder(result);
	}
	
}
