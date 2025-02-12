public class PrimeNum{
	public static void main(String args[]){
		int num=1345;

		boolean flag=false;
		if(num==0 || num==1 )
			flag= true;
			for(int i=2;i<=num/2;++i)
			{
				if(num%i==0){
				flag = true;
				break;
				}
			}
			if(!flag)
			{

				System.out.println(num+ " is Prime");
			}
			else{
				System.out.println( num+" i not a Prime");
			}
		}
	}
