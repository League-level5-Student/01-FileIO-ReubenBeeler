package _02_File_Encrypt_Decrypt;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("src/_02_File_Encrypt_Decrypt/encrypted.txt");
		List<Character> characters = new ArrayList<>();
		for(int c = fr.read(); c != -1; c = fr.read()) {
			characters.add((char) c);
		}
		char[] chars = new char[characters.size()];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = (char) (characters.get(i) - 3 - 2*(i % 2) - Math.pow(i, 2));
		}
		JOptionPane.showMessageDialog(new JFrame(), String.copyValueOf(chars));
		fr.close();
	}
}
