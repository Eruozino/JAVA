/**
	Author: Eruozino Kagho
	Description: 

**/

public class Encryption{
	public static void main(String[] args) {
		//Instance Objects
		Encoder fileToEncrypt = new Encoder();
		ReadFile scrib = new ReadFile();
		Decoder fileToDecode = new Decoder();

		///Reading text file
		String content = scrib.readFile();
		System.out.println("Original Document: \n\n" + content);
		System.out.println();

		///Encrypting text file 
		System.out.println("Encoding text content: \n");
		content = fileToEncrypt.encode(content);
		System.out.println(content);

		///Decrypting text file
		System.out.println("\nDecoding text content:");
		Decoder output = new Decoder();
		content = fileToDecode.decode(content);
		System.out.println(content);
	}
}