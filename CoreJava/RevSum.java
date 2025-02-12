import java.io.*;
import java.util.Scanner;
public class RevSum{
	public static void main(String args[]){
		int rem, rev=0, sum=0;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a number");
		int n = sc.nextInt();
		do{
			rem=n%10;
			rev= rev*10+rem;
			sum=sum+rem;
			n=n/10;
		}
		while(n>0);
		System.out.println("Reversed number is"+rev);
		System.out.println( "Sum of the number is" +sum);
			
		}
}
	
		
		