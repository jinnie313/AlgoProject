import java.util.Arrays;

public class BitOperation2 {
	public static void main(String[] args){
		char[] arr= {'0','0','0','0','0','0','1','0','0','0','1','1','0','1'};
		
		char[] left = Arrays.copyOfRange(arr, 0, 7);
		char[] right = Arrays.copyOfRange(arr, 7, 14);
		System.out.println(convert(left)+", "+convert(right));
	}

	static int convert(char[] arr) {
		int val=0;
		for(int i=arr.length-1; i>=0; i--) {
			if(arr[i]=='1') {
				val+=Math.pow(2, 6-i);
			}
		}
		return val;
	}
}
