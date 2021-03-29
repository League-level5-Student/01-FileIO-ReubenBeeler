package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/encrypted.txt");
		System.out.println("Enter a message: ");
		char[] chars = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
		for (int i = 0; i < chars.length; i++) {
			chars[i] += 3 + 2*(i % 2) + Math.pow(i, 2);
		}
		fw.write(String.copyValueOf(chars));
		fw.close();
	}
}
