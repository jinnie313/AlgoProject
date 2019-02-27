import java.util.Arrays;

public class ChangeTest2 {

	public static void main(String[] args) {
//				잔돈 거슬러 주기 1, 4, 6원
//				8원의 잔돈의 갯수가 최소인 값을 구하기
		int money = 16;
		int[][] datas = new int[3][money + 1];

		int count = change(money, datas);
		System.out.println(count);
	}

	private static int change(int money, int[][] datas) {
		for(int i = 0; i < datas.length; i++) {
			for(int j = 1; j < datas[i].length; j++) {
				datas[i][j] = datas[i][j-1] + 1;

				if(i == 1 && j >= 4) {
					datas[i][j] = Math.min(datas[i-1][j], datas[i][j - 4] + 1);
				}

				if(i == 2) {
					if(j >= 4) {
						datas[i][j] = Math.min(datas[i-1][j], datas[i][j - 4] + 1);
					}
					
					if(j >= 6) {
						datas[i][j] = Math.min(datas[i-1][j], datas[i][j - 6] + 1);
					}
				}
			}
		}

		for(int i = 0; i < datas.length; i++) {
			System.out.println(Arrays.toString(datas[i]));
		}

		return datas[2][money];
	}

}
