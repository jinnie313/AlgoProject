import java.util.HashMap;
import java.util.Map;

public class BitOperation3 {
	public static void main(String[] args){
		String input = "0DEC";
		String binary = "";
		String result = "";
		
		String[] binaryMatrix = {
				"0000", "0001", "0010", "0011", "0100", "0101",
				"0110", "0111", "1000", "1001", "1010", "1011",
				"1100", "1101", "1110", "1111"
		};
		Map<String, Integer> keys = new HashMap<>();
		keys.put("001101", 0);
		keys.put("010011", 1);
		keys.put("111011", 2);
		keys.put("110001", 3);
		keys.put("100011", 4);
		keys.put("110111", 5);
		keys.put("001011", 6);
		keys.put("111101", 7);
		keys.put("011001", 8);
		keys.put("101111", 9);
		
		char token;
		for(int i=0; i<input.length(); i++) {
			token = input.charAt(i);
			
			if(Character.isDigit(token)) {
				binary+=binaryMatrix[token-'0'];
			}else {
				binary+=binaryMatrix[token-'A'+10];
			}
		}
		
		binary = binary.substring(2, binary.length()-2);
		
		int val;
		for(int i=0; i<binary.length(); i+=6) {
			val = keys.get(binary.substring(i, i+6));
			System.out.println(val);
		}
	}
}
