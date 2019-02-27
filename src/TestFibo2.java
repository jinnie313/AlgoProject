import java.util.ArrayList;

public class TestFibo2 {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		int size = a.size();
		for(int i = 0; i < size; i++) {
			
		}
		int n = 8;
		int num = fibo(n);
		System.out.println(num);
	}

	private static int fibo(int n) {
		if(n < 2) return n;
		else return fibo(n - 1) + fibo(n - 2);
	}

}
