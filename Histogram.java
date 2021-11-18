import java.util.*;
public class Main { 
	
	public static void main(String[] args) {
 
 Scanner sc=new Scanner(System.in);
 int n;
 n=sc.nextInt();
 long ht[]=new long[n];
 for(int i=0;i<n;i++) //input height of bars
 {
	 ht[i]=sc.nextInt();
 }
 
 long nse[]=new long[n]; //creating nse array
 long pse[]=new long[n];//creating pse array

 Stack<Integer> st=new Stack<>();
 st.push(0);//pushing 0 index in stack
 for(int i=1;i<n;i++)  
 {
	 while(!st.isEmpty()&&ht[st.peek()]>ht[i]) //mai kis kis ka nse hu for each element
	 {
		nse[st.pop()]= i; //nse [i] par poped index put kardo
	 }
	 st.push(i);
	  
 }
 while(!st.isEmpty()) //jis jis ka nse ni mila unka nse ht.length rakh do
 {

nse[st.pop()]=ht.length;

 }

//for pse
st=new Stack<>();
st.push(0);
pse[0]=-1;
for(int i=1;i<n;i++)
{
	//mera pse kon hai jab tk mera pse nhi milta pop krdo
	while(!st.isEmpty()&& ht[st.peek()]>=ht[i])//jab tk mera nge na mile pop krdo
	{
st.pop();
	}
if(!st.isEmpty())
	pse[i]=st.peek(); //before assigning peek() elent check if stack is empty

	else
	pse[i]=-1;
	st.push(i);
}

long maxArea=Integer.MIN_VALUE;
//formula of width of each bar afer expansion
//nse[i]-pse[i]-1;
for(int i=0;i<n;i++)
//calculation area of each bar on expansion on both side
{
	long area=ht[i]*(nse[i]-pse[i]-1);
	maxArea=Math.max(maxArea,area);
}

System.out.print(maxArea);
 }
 }
