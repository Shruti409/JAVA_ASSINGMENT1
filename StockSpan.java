import java.util.*;

public class Main {
//optimised approach
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int heightarr[]= new int[n];
		for(int i=0;i<heightarr.length;i++)
		{
           heightarr[i]=sc.nextInt();
		}
		int span[]=new int[n];
		Stack <Integer>st=new Stack<>();
		span[0]=1; //span of leftmost element will be always 1
		//we will be using stack because we are visiting array in forward direction 
		//and revisiting in backword direction 
		//it is lifo order
		st.push(0);//we are pushing index 0 in stack
		for(int i=1;i<heightarr.length;i++) //traverse each building
		{

        while(!st.isEmpty()&&heightarr[st.peek()]< heightarr[i])// we use while loop till we get bigger element  than current index element
		
		{
          st.pop(); //if element at index( which is present in stack)is smaller than current one
		  //we will pop that index and will look for expansion or check next previous index

		}

		span[i]= st.isEmpty()? i+1 : i-st.peek(); //if stack is empty then current index+1 will be span
		//else current index-top index of stack
		st.push(i);

		}
    for(int i=0;i<n;i++)//printing span array
{
	System.out.print(span[i]+" ");
}
System.out.print("END");
	}

}
