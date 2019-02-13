import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BitOperation2 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("input.txt"));
		
//		Scanner reader = new Scanner(System.in);
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		String s = reader.readLine();
		
		for(int i=-5; i<6; i++) {
			System.out.printf("%3d = ", i);
			BbitPrint(i);
			System.out.println();
		}
	}

	static void BbitPrint(int i) {
		for(int j=7; j>=0; j--) {
			System.out.printf("%d", (i&(1<<j)) != 0 ? 1:0);
		}
	}
}
