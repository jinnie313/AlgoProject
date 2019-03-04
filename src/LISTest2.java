import java.util.Arrays;
import java.util.Stack;

public class LISTest2 {
	public static void main(String[] args) {
		int[] arr = {3, 2, 6, 4, 5, 1};
		doLIS(arr);
	}
	
	static void doLIS(int[] arr) {
		int[] dp = new int[arr.length];
		Data[] tracking = new Data[arr.length];
		dp[0] = arr[0];
		tracking[0] = new Data(0, arr[0]);
		int idx = 0;
		
		for(int i = 1; i < arr.length; i++) {
			if(dp[idx] < arr[i]) {
				dp[++idx] = arr[i];
				tracking[i] = new Data(idx, arr[i]);
			}
			else {
				int ix = lowerBound(dp, idx, arr[i]);
				dp[ix] = arr[i];
				tracking[i] = new Data(ix, arr[i]);
			}
		}
		
		Stack<Integer> stack = new Stack<>();
		for(int i= tracking.length-1; i>=0; i--) {
			if(idx == tracking[i].idx) {
				stack.push(tracking[i].value);
				idx--;
			}
		}
		
		System.out.println(stack.size());
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
//		System.out.println(Arrays.toString(tracking));
//		System.out.println(idx + 1);
	}

	static int lowerBound(int[] dp, int end, int key) {
		int start = 0;
		while(start < end) {
			int mid = ( start + end ) / 2;
			if(dp[mid] >= key) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		return end;
	}
	
	static class Data{
		int idx;
		int value;
		
		public Data(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}
		
		@Override
		public String toString() {
			return "Data [idx=" + idx + ", value=" + value + "]";
		}
	}
}
