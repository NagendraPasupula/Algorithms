import java.util.HashMap;



public class Substring {

	void longSubString(String str){
		if(str.equals("")) System.out.println("String is empty");
		int max_len =0;
		int k=0;
		String longest ="";
		HashMap<Character, Integer> map =  new HashMap<>();
		for(int i=0;i<str.length();i++){
			char alpha = str.charAt(i);
			if(map.containsKey(alpha)){
				if(max_len < map.size()){
					longest="";
					for (char key : map.keySet()) {
						   longest= longest+key;
						}	
				}
				max_len = Math.max(max_len, map.size());
				while(map.containsKey(alpha)){
					map.remove(str.charAt(k));
					k++;
				}
				map.put(alpha, i);
			}else{
				map.put(str.charAt(i), i);
			}
		}
		max_len = Math.max(max_len, map.size());
		if(longest.length()< map.size()){
		System.out.print("Longest Substring of \""+str+"\" is :");
		for (char key : map.keySet()) {
			   System.out.print(key);
			}
		System.out.print("  with a length of: "+max_len +"\n");}
		else{
			System.out.print("Longest Substring of \""+str+"\" is : "+longest+  " with a length of: "+max_len +"\n");
		}
	}
	
	public static void main(String[] args){
		Substring s = new Substring();
		s.longSubString("abcabcdbb");
		
		
	}
}
