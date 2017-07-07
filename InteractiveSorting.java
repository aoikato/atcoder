import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class InteractiveSorting{
	private static BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
	private static int tmp;
	private static String ans;
	private static int[] a;
	private static Scanner scanner=new Scanner(System.in);

	public static void main(String[] args){
//		int n=scanner.nextInt();
//		int q=scanner.nextInt();
		String[] s=scanner.nextLine().split(" ");
		int n=Integer.parseInt(s[0]);

		a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=i;
		}
		for(int i=1;i<n;i++){
			for(int j=i;j>0;j--){
				if(isWrongOrder(j-1,j)){
					tmp=a[j-1];
					a[j-1]=a[j];
					a[j]=tmp;
				}else {
					break;
				}
			}
		}

		System.out.print("! ");
//		System.out.flush();
		for(int i=0;i<n;i++){
			System.out.print((char)('A'+a[i]));
//			System.out.flush();
		}
		System.out.println();
		System.out.flush();
		System.exit(0);
	}
	private static String returnChar(int i, int j){
		return (char)('A'+a[i])+" "+(char)('A'+a[j]);
	}

	private static boolean isWrongOrder(int i, int j){
		System.out.println("? "+returnChar(i,j));
		System.out.flush();
		try{
			ans=scanner.next();
			if(ans.equals(">")){
				return true;
			}else{
				return false;
			}
		}
		catch(Exception e){
			System.out.println("error: "+e);
			return false;
		}
	}
}
