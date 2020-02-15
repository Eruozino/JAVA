/**
	Author: Eruozino Kagho
	Description:  
**/


public class Decoder{
	public static String charRemoveAt(String str, int p) {  
        return str.substring(0, p) + str.substring(p + 1);  
    }
	
	public String decode(String toDecode){
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String currentChar = "";
		StringBuilder decrypted = new StringBuilder();
		boolean end = true;

		int n = toDecode.length();
		int i = 0;

		while (i < n){
			for (int j = 0; j < 6; j++){
				char c = toDecode.charAt(i);
				currentChar +=c;
				i++;
			}

			int k = 0;
			while (k < currentChar.length()){
				if (upperCase.indexOf(currentChar.charAt(k)) >= 0){
					k--;
					currentChar = charRemoveAt(currentChar, 0);
				}
				k++;
			}

			//Setting Previous and next characters;
			char p = currentChar.charAt(0);
			char next = ++p;
			char prev = --p;
			prev = --p;
			++p;

			int index = 0;

			//CASES
			if (currentChar.length() == 2){
				//E,T
				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == '0'){
					decrypted.append('e');
				}
				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == '1'){
					decrypted.append('t');
				}
			}

			if (currentChar.length() == 3){
				//A,I,M,N
				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == next && currentChar.charAt(index+2) == '0'){
					decrypted.append('a');
				}
				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == p && currentChar.charAt(index+2) == '0'){
					decrypted.append('i');
				}
				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == p && currentChar.charAt(index+2) == '1'){
					decrypted.append('m');
				}
				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == prev && currentChar.charAt(index+2) == '0'){
					decrypted.append('n');
				}
			}

			if (currentChar.length() == 4){
				//D,G,K,O,R,S,U,W
				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == prev && currentChar.charAt(index+2) == prev && currentChar.length() == 4 && currentChar.charAt(index+3) == '0'){
					decrypted.append('d');
				}
				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == p && currentChar.charAt(index+2) == prev && currentChar.charAt(index+3) == '0'){
					decrypted.append('g');
				}
				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == prev && currentChar.charAt(index+2) == p && currentChar.charAt(index+3) == '0'){
					decrypted.append('k');
				}
				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == p && currentChar.charAt(index+2) == p && currentChar.charAt(index+3) == '0'){
					decrypted.append('o');
				}
				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == next && currentChar.charAt(index+2) == p && currentChar.charAt(index+3) == '0'){
					decrypted.append('r');
				}
				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == p && currentChar.charAt(index+2) == p && currentChar.charAt(index+3) == '1'){
					decrypted.append('s');
				}
				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == p && currentChar.charAt(index+2) == next && currentChar.charAt(index+3) == '0'){
					decrypted.append('u');
				}
				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == next && currentChar.charAt(index+2) == next && currentChar.charAt(index+3) == '0'){
					decrypted.append('w');
				}
			}

			if (currentChar.length() == 5){
				//B,C,F,H,J,L,P,Q,V,X,Y,Z
				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == prev && currentChar.charAt(index+2) == prev && currentChar.charAt(index+3) == prev && currentChar.charAt(index+4) == '0' && currentChar.length() == 5){
					decrypted.append('b');
				}

				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == prev && currentChar.charAt(index+2) == p && currentChar.charAt(index+3) == prev && currentChar.charAt(index+4) == '0' && currentChar.length() == 5){
					decrypted.append('c');
				}

				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == p && currentChar.charAt(index+2) == next && currentChar.charAt(index+3) == p && currentChar.charAt(index+4) == '0'){
					decrypted.append('f');
				}

				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == p && currentChar.charAt(index+2) == p && currentChar.charAt(index+3) == p && currentChar.charAt(index+4) == '0'){
					decrypted.append('h');
				}

				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == next && currentChar.charAt(index+2) == next && currentChar.charAt(index+3) == next && currentChar.charAt(index+4) == '0'){
					decrypted.append('j');
				}

				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == next && currentChar.charAt(index+2) == p && currentChar.charAt(index+3) == p && currentChar.charAt(index+4) == '0'){
					decrypted.append('l');
				}

				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == next && currentChar.charAt(index+2) == next && currentChar.charAt(index+3) == p && currentChar.charAt(index+4) == '0'){
					decrypted.append('p');
				}

				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == p && currentChar.charAt(index+2) == prev && currentChar.charAt(index+3) == p && currentChar.charAt(index+4) == '0'){
					decrypted.append('q');
				}

				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == p && currentChar.charAt(index+2) == p && currentChar.charAt(index+3) == next && currentChar.charAt(index+4) == '0'){
					decrypted.append('v');
				}

				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == prev && currentChar.charAt(index+2) == prev && currentChar.charAt(index+3) == p && currentChar.charAt(index+4) == '0'){
					decrypted.append('x');
				}

				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == prev && currentChar.charAt(index+2) == p && currentChar.charAt(index+3) == p && currentChar.charAt(index+4) == '0'){
					decrypted.append('y');
				}

				if (currentChar.charAt(index) == p && currentChar.charAt(index+1) == p && currentChar.charAt(index+2) == prev && currentChar.charAt(index+3) == prev && currentChar.charAt(index+4) == '0'){
					decrypted.append('z');
				}
			}

			if (currentChar.length() == 6){
				if (currentChar.charAt(5) == '.'){
					decrypted.append('.');
				}
				else if(currentChar.charAt(5) == ','){
					decrypted.append(',');
				}
				else if(currentChar.charAt(5) == '\n'){
					decrypted.append('\n');
				}
				else if(currentChar.charAt(5) == '\''){
					decrypted.append('\'');
				}
				else if(currentChar.charAt(5) == '0'){
					decrypted.append('0');
				}
				else if(currentChar.charAt(5) == '1'){
					decrypted.append('1');
				}
				else if(currentChar.charAt(5) == '2'){
					decrypted.append('2');
				}
				else if(currentChar.charAt(5) == '3'){
					decrypted.append('3');
				}
				else if(currentChar.charAt(5) == '4'){
					decrypted.append('4');
				}
				else if(currentChar.charAt(5) == '5'){
					decrypted.append('5');
				}
				else if(currentChar.charAt(5) == '6'){
					decrypted.append('6');
				}
				else if(currentChar.charAt(5) == '7'){
					decrypted.append('7');
				}
				else if(currentChar.charAt(5) == '8'){
					decrypted.append('8');
				}
				else if(currentChar.charAt(5) == '9'){
					decrypted.append('9');
				}
				else{
					decrypted.append(' ');
				}
			}
	
			currentChar = "";
		}

		System.out.println(currentChar);
		return decrypted.toString();
	}

}