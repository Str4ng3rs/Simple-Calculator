package structures;

import java.awt.*;
import javax.swing.*;

public class NumberButton extends JButton {
	private Dimension size = new Dimension(96,66);

	public NumberButton(){
		this.setFont(new Font("Segoe UI",Font.BOLD,33));
		this.setPreferredSize(size);
		this.setFocusable(false);
		this.setFocusPainted(false);
	}
	public NumberButton(String text){
		this.setText(text);
		this.setFont(new Font("Segoe UI", Font.BOLD, 33));
		this.setPreferredSize(size);
		this.setFocusable(false);
		this.setFocusPainted(false);
	}
	public NumberButton(Icon icon){
		this.setIcon(icon);
		this.setFont(new Font("Segoe UI", Font.BOLD, 33));
		this.setPreferredSize(size);
		this.setFocusable(false);
		this.setFocusPainted(false);
	}
	public NumberButton(String text, Icon icon){
		this.setText(text);
		this.setIcon(icon);
		this.setFont(new Font("Segoe UI", Font.BOLD, 33));
		this.setPreferredSize(size);
		this.setFocusable(false);
		this.setFocusPainted(false);
	}
}
