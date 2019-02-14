import java.util.Arrays;

public class MargeSortDivision {
	public static void main(String[] args) {
		int[] arr = {69, 10, 30, 2, 16, 8, 31, 22};
		
		System.out.println(Arrays.toString(margeSort(arr)));
		
		
	}
	
	public static int[] margeSort(int[] arr) {
		if(arr.length ==1) {
			return arr;
		}
		
		int middle = arr.length/2;
		int[] left = new int[middle];
		int[] right = new int[arr.length - middle];
		
		for(int i=0; i<middle; i++) {
			left[i] = arr[i];
		}
		
		for(int i=middle; i<arr.length; i++) {
			right[i-middle] = arr[i];
		}
		
		left = margeSort(left);
		right = margeSort(right);
		
		return marge(left, right);
		
	}
	
	public static int[] marge(int[] left, int[] right) {
		int[] result = new int[left.length+right.length];
		int idx=0;
		int lIdx=0, rIdx=0;
		
		while(left.length>lIdx || right.length>rIdx) {
			if(left.length>lIdx && right.length>rIdx) {
				if(left[lIdx] <= right[rIdx]) {
					result[idx++] = left[lIdx++];
				}else {
					result[idx++] = right[rIdx++];
				}
			}else if(left.length>lIdx) {
				result[idx++] = left[lIdx++];
			}else if(right.length>rIdx) {
				result[idx++] = right[rIdx++];
			}
		}
		return result;
	}

}
