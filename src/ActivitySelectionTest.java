import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelectionTest {

	public static void main(String[] args) {
		int[][] conferences = {
				{1,4}, {1,6}, {6,10}, {5,7}, {3,8},
				{5,9}, {3,5}, {8,11}, {2,13}, {12,14}
		};
		
		Arrays.sort(conferences, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]==o2[1] ? o1[0]-o2[0] : o1[1]-o2[1];
			}
		});
//		System.out.println(Arrays.deepToString(conferences));
		
		
		int endTime=conferences[0][1];	//종료시간 저장된 변수
		int result = 1;	//회의 열리는 횟수
		
		for(int i=1; i<conferences.length; i++)
		{
			if(endTime<=conferences[i][0]) {
				endTime=conferences[i][1];
				result++;
			}
		}
		
		System.out.println(result);
	}

	
}
