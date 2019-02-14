
public class GreedyTest {
	public static void main(String[] args) {
		int i=0;
		int inputNumber=0;
		int triple=0;	//트리플 수
		int run=0;		//연속된 수
		int[] arr = new int[12];
		
		inputNumber=123333;
		
		while(i<6) {
			arr[inputNumber%10] += 1;
			inputNumber /=10;
			i++;
		}
		
		i=0;
		
		while(i<10) {
			if(arr[i] >= 3) {
				arr[i] -= 3;
				triple++;
				continue;
			}
			
			if(arr[i]>=1 && arr[i+1]>=1 && arr[i+2]>=1) {
				arr[i]-=1;
				arr[i+1]-=1;
				arr[i+2]-=1;
				run++;
				continue;
			}
			i++;
		}
		
		if(run+triple == 2)	System.out.println("Baby Gin");
		else	System.out.println("Lose");
		
	}
}
