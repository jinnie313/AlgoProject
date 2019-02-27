public class TestFibo {

	public static void main(String[] args) {
		int n = 29;
		datas = new int[n + 1];
		datas[1] = 1;
		int num = fibo(n);
		System.out.println(num);
		System.out.println(fiboDP(29));
	}

	static int[] datas;
	
	private static int fiboDP(int num) {
		int[] datas = new int[num + 1];
		datas[0] = 0;
		datas[1] = 1;
		
		for(int i = 2; i < num + 1; i++)
			datas[i] = datas[i-1] + datas[i-2];
		return datas[num];
	}
	
	private static int fibo(int n) {
		if(n < 2) return n;
		if(datas[n] != 0) return datas[n];
		
		return datas[n] = fibo(n - 1) + fibo(n - 2);
	}

}
