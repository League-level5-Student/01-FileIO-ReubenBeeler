package _01_File_Recorder;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("src/_01_File_Recorder/message.txt");
		System.out.println("Type a message: ");
		fw.write(new BufferedReader(new InputStreamReader(System.in)).readLine());
		fw.close();
	}
}
