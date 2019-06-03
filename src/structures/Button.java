package structures;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton{
	private Dimension size = new Dimension(96,66);

	public Button(){
		this.setFont(new Font("Segoe UI",Font.BOLD,33));
		this.setPreferredSize(size);
		this.setFocusable(false);
		this.setFocusPainted(false);
		/*this = new JButton();
		this.setFont(new Font("Segoe UI", Font.BOLD, 33));
		this.setPreferredSize(size);
		this.setFocusable(false);
		this.setFocusPainted(false);*/
	}
	public Button(String text){
		this.setText(text);
		this.setFont(new Font("Segoe UI", Font.BOLD, 33));
		this.setOpaque(false);
		this.setPreferredSize(size);
		this.setFocusable(false);
		this.setFocusPainted(false);
	}
	public Button(Icon icon){
		this.setIcon(icon);
		this.setFont(new Font("Segoe UI", Font.BOLD, 33));
		this.setPreferredSize(size);
		this.setFocusable(false);
		this.setFocusPainted(false);
	}
	public Button(String text, Icon icon){
		this.setText(text);
		this.setIcon(icon);
		this.setFont(new Font("Segoe UI", Font.BOLD, 33));
		this.setPreferredSize(size);
		this.setFocusable(false);
		this.setFocusPainted(false);
	}
	public void addNumberAction(JLabel entry, boolean[] entryIsZero, boolean[] decimalInEntry, int num){
		this.addActionListener(action -> {
			if (entryIsZero[0] && !decimalInEntry[0]) {
				entryIsZero[0] = false;
				entry.setText(String.valueOf(num));
			} else {
				entry.setText(entry.getText() + num);
				entryIsZero[0] = false;
			}
		});
	}
}
