/**
	Author: Eruozino Kagho
	Description: 
**/

import java.util.Random;

public class Encoder{
	private String encryptionKey = "!\"#$%&'()*+,-./0123456789:;<=>?@\\\\]^_`abcdefghijklmnopqrstuvwxyz}|{~";
	
	public String encode(String toEncode){
		String encodeLC = toEncode.toLowerCase();
		String encoded = "";
		Random rand = new Random();
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


		for (int i = 0, n = encodeLC.length(); i < n; i++){
			char c = encodeLC.charAt(i);
			char order0 = '0';
			char order1 = '1';
			char guess = encryptionKey.charAt(rand.nextInt(encryptionKey.length()));
			char first = upperCase.charAt(rand.nextInt(upperCase.length()));
			char second = upperCase.charAt(rand.nextInt(upperCase.length()));
			char third = upperCase.charAt(rand.nextInt(upperCase.length()));
			char fourth = upperCase.charAt(rand.nextInt(upperCase.length()));
			switch(c){
				///Lower case letters
				case 'a':
					encoded = encoded + first + second + third + guess + ++guess + order0;
				break;
				case 'b':
					encoded = encoded + third + guess + --guess + guess + guess + order0;
				break;
				case 'c':
					encoded = encoded + first + guess + --guess + ++guess + --guess + order0;
				break;
				case 'd':
					encoded = encoded + first + second + guess + --guess + guess + order0;
				break;
				//special
				case 'e':
					encoded = encoded + first + second + third + fourth + guess + order0;
				break;
				case 'f':
					encoded = encoded + first + guess + guess + ++guess + --guess + order0;
				break;
				case 'g':
					encoded = encoded + first + second + guess + guess + --guess + order0;
				break;
				//special
				case 'h':
					encoded = encoded + first + guess + guess + guess + guess + order0;
				break;
				//special
				case 'i':
					encoded = encoded + first + second + third + guess + guess + order0;
				break;
				case 'j':
					encoded = encoded + first + guess + ++guess + guess + guess + order0;
				break;
				case 'k':
					encoded = encoded + first + second + guess + --guess + ++guess + order0;
				break;
				case 'l':
					encoded = encoded + first + guess + ++guess + --guess + guess + order0;
				break;
				//special
				case 'm':
					encoded = encoded + first + second + third + guess + guess + order1;
				break;
				case 'n':
					encoded = encoded + first + second + third + guess + --guess + order0;
				break;
				case 'o':
					encoded = encoded + first + second + guess + guess + guess + order0;
				break;
				case 'p':
					encoded = encoded + first + guess + ++guess + guess + --guess + order0;
				break;
				case 'q':
					encoded = encoded + first + guess + guess +  --guess + ++guess + order0;
				break;
				case 'r':
					encoded = encoded + first + second + guess + ++guess + --guess + order0;
				break;
				//special
				case 's':
					encoded = encoded + first + second + guess + guess + guess + order1;
				break;
				//special
				case 't':
					encoded = encoded + first + second + third + fourth + guess + order1;
				break;
				case 'u':
					encoded = encoded + first + second + guess + guess + ++guess + order0;
				break;
				case 'v':
					encoded = encoded + first + guess + guess + guess + ++guess + order0;
				break;
				case 'w':
					encoded = encoded + first + second + guess + ++guess + guess + order0;
				break;
				case 'x':
					encoded = encoded + first + guess + --guess + guess + ++guess + order0;
				break;
				case 'y':
					encoded = encoded + first + guess + --guess + ++guess + guess + order0;
				break;
				case 'z':
					encoded = encoded + first + guess + guess + --guess + guess + order0;
				break;
				///Spacing and Punctuations
				case ' ':
					encoded = encoded + guess + guess + guess + guess + guess + ' ';
				break;
				case '.':
					encoded = encoded + guess + --guess + guess++ + guess + guess + '.';
				break;
				case ',':
					encoded = encoded + ++guess + guess + --guess + guess + guess + ',';
				break;
				case '\n':
					encoded = encoded + guess + guess + ++guess + guess + guess + '\n';
				break;
				case '\'':
					encoded = encoded + guess + guess + ++guess + guess + guess + '\'';
				break;
				//Numbers
				case '0':
					encoded = encoded + guess + guess + ++guess + guess + guess + '0';
				break;
				case '1':
					encoded = encoded + guess + guess + ++guess + guess + guess + '1';
				break;
				case '2':
					encoded = encoded + guess + guess + ++guess + guess + guess + '2';
				break;
				case '3':
					encoded = encoded + guess + guess + ++guess + guess + guess + '3';
				break;
				case '4':
					encoded = encoded + guess + guess + ++guess + guess + guess + '4';
				break;
				case '5':
					encoded = encoded + guess + guess + ++guess + guess + guess + '5';
				break;
				case '6':
					encoded = encoded + guess + guess + ++guess + guess + guess + '6';
				break;
				case '7':
					encoded = encoded + guess + guess + ++guess + guess + guess + '7';
				break;
				case '8':
					encoded = encoded + guess + guess + ++guess + guess + guess + '8';
				break;
				case '9':
					encoded = encoded + guess + guess + ++guess + guess + guess + '9';
				break;
			}
		}

		return encoded;
	}

}