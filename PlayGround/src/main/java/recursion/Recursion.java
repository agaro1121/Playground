package recursion;

public class Recursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(factorial(3));
//		System.out.println(fib(5));
		
		char[] myChars = {'a', 'd', 'f', 'b', 'x', 'f'};

		char temp;
		int j = myChars.length-1;

		for(int i=0; i<myChars.length; i++){
		   temp = myChars[i];
		   myChars[i] = myChars[j];
		   myChars[j] = temp;
		   j--;
		    if(j == i || i>j ){
		        break;
		    }
		}
		
	}

	public static long fib(int n) {
		if (n == 1)
			return 1;
		else
			return n + fib(n - 1);

	}

	public static int factorial(int N) {
		if (N == 1){
			return 1;
		}else{
			return N * factorial(N - 1);
		}
	}

}
