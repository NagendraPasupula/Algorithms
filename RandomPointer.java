/**
 * 
 * @author Venkata Nagendra Kumar
 * __________ 
 * |      __|__                         _____    __
 * |     |  !  !                       |     !  !  |
 * 1->2->3->4->5      =====>>          5->4->3->2->1  
 * ^  |^ ^  |  |                       ^  |^_|  |  ^
 * |__|| |__|  |                       |  |_____|__|
 *     |_______|                       |________|
 */
import java.util.Map;
import java.util.HashMap;
class Node{
	int val;
	Node next;
	Node random;
	Node head;
	Node(int x){
		this.val = x;}
	Node add(int[] x){
		for(int i=x.length-1;i>=0;i--){
			Node temp= new Node(x[i]);
			temp.next = head;
			head = temp;
		}
		return head;
	}
}
public class RandomPointer {

	public static Node reverse(Node head){
		Map<Integer, Integer> rand = new HashMap<>();
		Map<Integer, Node> map = new HashMap<>();
		Node temp = head;
		while(temp!=null){
			rand.put(temp.random.val, temp.val);
			temp = temp.next;
		}
		// Reverse list
		Node p=head;
		Node q= head.next;
		p.next = null;
		p.random = null;
		map.put(p.val,p);
		while(q != null){
			q.random = null;
			Node temp1 = q.next;
			q.next = p;
			p = q;
			map.put(p.val,p);
			q = temp1;
		}
		// assign random
		Node rev = p;
		System.out.println("-----------------");
		while(rev !=null){
			rev.random = map.get(rand.get(rev.val));
			rev = rev.next;
		}
		
		return p;
	}
	public static void main(String[] args){
		Node list1 = new Node(0);
		list1 = list1.add(new int[]{1,2,3,4,5});
		list1.random =list1.next.next.next;   //1->4
		list1.next.random = list1;       // 2->1
		list1.next.next.random = list1.next.next.next.next; //3->5
		list1.next.next.next.random = list1.next.next;            //4->3
		list1.next.next.next.next.random = list1.next;    //5->2
		Node original = list1;
		System.out.println("-------------------original ---------------------------");
		System.out.println("Node\tNext\tRandom");
		while(original!=null){
		System.out.println(original.val+"\t"+((original.next !=null)?original.next.val:"null")+"\t"+original.random.val);
		original=original.next;
		}
		Node result = reverse(list1);
		System.out.println("--------------------reverse-------------------------");
		System.out.println("Node\tNext\tRandom");
		while(result!=null){
		System.out.println(result.val+"\t"+((result.next !=null)?result.next.val:"null")+"\t"+result.random.val);
		result=result.next;
		}
	}
}
