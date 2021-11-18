import java.util.*;
public class Main {

	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();

		
		while(tc-->0){
            int n=sc.nextInt();
            int ht[]=new int[n];
            for(int i=0;i<n;i++)
            {
                ht[i]=sc.nextInt();
            }
            int nge[]= new int[ht.length];
		Stack<Integer> st =new Stack<>();
		st.push(0);//index 0 will be pushed in array
		for(int i=1;i<ht.length;i++) //iterating right wali buildings
		{
			while(!st.isEmpty()&&ht[st.peek()]<ht[i])//jab tak stack empty na ho ya current se bda element na mile pop kro
			{
				nge[st.pop()]=ht[i];// jo index pop hua uska nge current  index ka element hai
			}
			
			st.push(i);
		}
		while(!st.isEmpty()) //agr stack mei kuch element bach jaye unko pop kro and unka nge will be -1
		{
			nge[st.pop()]=-1;
		}
//printing of nge array
		for(int i=0;i<ht.length;i++)
		{
			System.out.println(ht[i]+","+nge[i]);
		}
	}
    }
}
