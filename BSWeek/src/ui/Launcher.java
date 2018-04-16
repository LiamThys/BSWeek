package ui;
import javax.swing.JOptionPane;

import domain.Speler;



public class Launcher {

	public static void main(String[] args) {
		Speler speler1 = new Speler(JOptionPane.showInputDialog("Hoe heet je ?"));
		
		JOptionPane.showMessageDialog(null,speler1.toString());
		
		System.out.println(speler1);
	}

}
