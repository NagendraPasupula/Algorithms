

public class SumLists extends LinkedList {

Node AddLists(Node l1,Node l2){
	Node list1 = l1;
	Node list2 = l2;
	Node result = new Node(0);
	Node result_head =result;
	int counter=0;
	int carry =0;
	while((list1.next !=null) || (list2.next !=null)){
		int val1 = (list1.next != null)?(list1.value): 0 ;
		int val2= (list2.next != null)?(list2.value): 0 ;
		carry = (val1+val2+carry >9)?1:0;
		result.value = (val1+val2+carry)%10;
		if(counter==0){
			result_head= result;
			counter++;
		}
		if(list1.next !=null){
			list1 = list1.next;
		}
		if(list2.next != null){
			list2 = list2.next;
		}
}
	if(carry == 1){
		result.next = new Node(1);
	}
	return result_head;
}
	
public static void main(String args[]){
	LinkedList ll1 = new LinkedList();
	AddList al= new AddList();
		ll1.add(9);
		ll1.add(3);
		ll1.add(5);
	LinkedList ll2 = new LinkedList();
		ll2.add(3);
		ll2.add(9);
	Node temp = al.AddNumbers(ll1.head,ll2.head);
	while(temp !=null){
		System.out.println(temp.value);
		temp = temp.next;
	}
}
	
	
}

