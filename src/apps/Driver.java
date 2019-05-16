package apps;

import graphics.GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

public class Driver {
	public static void main(String[] args) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		EventQueue.invokeLater(() -> {
			try {
				GUI window = new GUI("Simple Calculator", (screenSize.width / 2) - 200, (screenSize.height / 2) - 332, 400, 664);
				window.setVisibility(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
