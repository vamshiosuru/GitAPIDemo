package stepdefinition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class abcd  {
	
	
	
	public static void main(String[] args) {
		
		
		String ip="forgeeksskeegfor";
		//op===geeksskeeg
		int l =ip.length();
		
		int count=l;
		
		
		List<String> values = new ArrayList<String>();
		
		for(int i=0;i<l;i++){
			
			
			
			String t = ip.substring(i,l);
			String temp=abcd.reverseWord(t);
			
			/*System.out.println(t);
			System.out.println(temp);*/
			if(temp.equals(t)){
				
				
				//System.out.println("its a palindrome "+temp);
				values.add(temp);
			}
			else{
			//	System.out.println("not matched");
				l--;
			}
		}
		
		
		System.out.println(values);
		
		
		Collections.sort(values);
		
		
		System.out.println(values);
		
		System.out.println(values.get(values.size()-1));
		
		
		
		
		
		
		
		
	}
	
	
	public static String reverseWord(String s){
		
		String rev="";
		
char c[] = s.toCharArray();
		
		
		for(int i=c.length-1;i>=0;i--){
			
			rev= rev+c[i];
			
		}
		return rev;
		
		
	}
	
}


