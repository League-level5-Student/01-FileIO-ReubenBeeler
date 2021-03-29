package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import util.ListUtil;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
	
	JFrame frame = new JFrame("To-Do List");
	JPanel panel = new JPanel();
	JButton add = new JButton("Add Task");
	JButton remove = new JButton("Remove Tasks");
	JButton view = new JButton("View Tasks");
	JButton save = new JButton("Save List");
	JButton load = new JButton("Load List");
	JLabel label = new JLabel();
	
	List<String> tasks = new ArrayList<>();
	String file = "src/_03_To_Do_List/default.txt";
	FileWriter fw;
	
	public static void main(String[] args) {
		new ToDoList().run();
	}
	
	void run() {
		frame.add(panel);
		panel.add(label);
		label.setVisible(false);
		
		panel.add(add); panel.add(remove); panel.add(view); panel.add(save); panel.add(load);
		add.addActionListener(this); remove.addActionListener(this); view.addActionListener(this); save.addActionListener(this); load.addActionListener(this); 

		panel.add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(400, 225);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		if (source == add) {
			String task = JOptionPane.showInputDialog("Add a task: ");
			if (task != null) tasks.add(task);
		} else if (source == remove) {
			String task = JOptionPane.showInputDialog("Remove a task: ");
			if (task == null) {}
			else if (!tasks.contains(task)) {
				JOptionPane.showMessageDialog(remove, "\"" + task + "\" is not on your to-do list.");
			} else {
				tasks.remove(task);
			}
		} else if (source == view) {
			JOptionPane.showMessageDialog(frame, ListUtil.toString(tasks, "\n"), "To-Do List", JOptionPane.PLAIN_MESSAGE);
		} else if (source == save) {
			try {
				fw = new FileWriter(file);
				fw.write(ListUtil.toString(tasks, "\n"));
				fw.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} else if (source == load) {
			String input = JOptionPane.showInputDialog("Enter a filepath: (src/_03_To_Do_List/)");
			if (input != null) {
				file = "src/_03_To_Do_List/" + input;
				// Doesn't save before switching files
				tasks.clear();
				try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					for (String line; (line = br.readLine()) != null;) {
						tasks.add(line);
					}
					br.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(frame, "Couldn't find file \"" + file + "\". Ready to create new one", "Load File", JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
	}
}
