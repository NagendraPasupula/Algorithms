
public class SumList_reverse extends LinkedList {

	Node listreverse(Node ll1, Node ll2){
/*************** List1 reverse********************/
		Node l1 = ll1;
		Node p = ll1.next;
		l1.next = null;
		while((l1 != null) && (p != null)){
			Node temp = p.next;
			p.next = l1;
			l1=p;
			if(temp !=null){
				p=temp;}
			else{
			break;}
		}
/********************** List 2 reverse *******************/
		Node l2 = ll2;
		Node q=l2.next;
		l2.next=null;
		while((l2 != null) && (q != null)){
			Node temp = q.next;
			q.next = l2;
			l2=q;
			if(temp != null){
				q=temp;}
			else{
				break;}
		}
/*********************************************************/
		Node result=new Node(0);
		Node result_head = result;
		int carry=0, counter=0;
		while((l1 !=null) || (l2 !=null)){
			int val1 = (l1 != null)?l1.value:0;
			int val2 = (l2 != null)?l2.value:0;
			result.next = new Node((val1+val2+carry)%10);
			if(val1+val2+carry >9)
				carry=1;
			else
				carry=0;
			if(counter==0)
				result_head=result.next;
			counter++;
			result = result.next;
			if(l1 !=null) l1 =l1.next;
			if(l2 !=null) l2 = l2.next;
		}
		if(carry==1){
			result.next = new Node(1);
		}
		
		Node l3 = result_head;
		Node r = l3.next;
		l3.next = null;
		while((l3 !=null) && (r !=null)){
			Node temp = r.next;
			r.next = l3;
			l3=r;
			if(temp !=null)
				r = temp;
			else
				break;
		}
		return l3;
	}
	
	public static void main(String args[]){
		LinkedList ll1 = new LinkedList();
		SumList_reverse lr= new SumList_reverse();
			ll1.add(9);
			ll1.add(3);
			ll1.add(5);
		LinkedList ll2 = new LinkedList();
			ll2.add(3);
			ll2.add(9);
		Node temp = lr.listreverse(ll1.head,ll2.head);
		while(temp !=null){
			System.out.println(temp.value);
			temp = temp.next;
		}
	}	
}
