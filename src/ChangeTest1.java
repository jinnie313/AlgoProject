
public class ChangeTest1 {

	public static void main(String[] args) {
//		잔돈 거슬러 주기 1, 4, 6원
//		8원의 잔돈의 갯수가 최소인 값을 구하기
		int money = 10;

		int count = change(money);
		System.out.println(count);
	}

	private static int change(int money) {
		int[] moneys = new int[money + 1];
		
		moneys[0] = 0; moneys[1] = 1;
		for(int i = 2; i <= money; i++) {
			moneys[i] = moneys[i - 1] + 1;
			if(i >= 4) {
				moneys[i] = Math.min(moneys[i - 4] + 1, moneys[i]);
			}
			if(i >= 6) {
				moneys[i] = Math.min(moneys[i - 6] + 1, moneys[i]);
			}
		}
		
		return moneys[money];
	}
}
