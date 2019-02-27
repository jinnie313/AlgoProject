public class FiboTest1 {

	public static void main(String[] args) {
		int n = 8;
		datas = new int[n+1];
//		datas[0] = 0;
		datas[1] = 1;
		int num = fibo(n);
		System.out.println(num);
		System.out.println(fiboDP(8));
	}
	static int[] datas;
	static int fiboDP(int num) {
		int[] datas = new int[num+1];
		datas[0] = 0;
		datas[1] = 1;
		for(int i = 2; i <= num; i++) {
			datas[i] = datas[i-1]*2 + datas[i-2];
		}
		return datas[num];
	}
	static int fibo(int n) {
		if(n < 2) {
			return n;
		}
		if(datas[n] != 0) {
			return datas[n];
		}
		datas[n] = fibo(n-1) + fibo(n-2);
		return datas[n];
	}

}
