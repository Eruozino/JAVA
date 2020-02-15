/**
	Author: Eruozino Kagho
	Decription: A simple program that reads text files and returns it in string form.
**/


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile{
	
	public String readFile(){
		String text = "";
		try{
			text = new String(Files.readAllBytes(Paths.get("README.txt")));
		}
		catch(IOException e){
			e.printStackTrace();
		}

		return text;
	}
}