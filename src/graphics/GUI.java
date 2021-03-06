package graphics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.StyleConstants;

import structures.Button;
import structures.NumberButton;

import net.miginfocom.swing.MigLayout;

public class GUI {

	private static final long serialVersionUID = 1L;
	private JFrame window;
	private JLabel console;
	private JLabel entry;
	private final Font segoeUI = new Font("Segoe UI", Font.BOLD, 33);
	private final Dimension defaultButtonSize = new Dimension(96, 66);

	public GUI(String windowTitle, int x, int y, int width, int height) {
		createWindow(windowTitle, x, y, width, height);
	}

	public GUI(String windowTitle) {
		createWindow(windowTitle, 320, 180, 1280, 720);
	}

	private void createWindow(String windowTitle, int x, int y, int width, int height) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		window = new JFrame(windowTitle);
		window.setBounds(x, y, width, height);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		JPanel consolePanel = new JPanel(new MigLayout("", "[:100%:]", "[25px]"));
		window.add(consolePanel, BorderLayout.SOUTH);
		console = new JLabel("Placeholder Text", SwingConstants.CENTER);
		console.setVisible(false);
		consolePanel.add(console, "cell 0 0,alignx center,aligny center");


		JPanel userInterface = new JPanel(new MigLayout("", "[:100%:]", "[50px]"));
		window.add(userInterface, BorderLayout.NORTH);

		entry = new JLabel("0", SwingConstants.RIGHT);
		entry.setFont(segoeUI.deriveFont(30f));
		userInterface.add(entry, "alignx right, aligny center");
		final boolean[] entryIsZero = {true};

		JPanel buttonPanel = new JPanel(new MigLayout("gap 0px 0px", "[96px:96px:96px]", "[66px:66px:66px]"));
		window.add(buttonPanel, BorderLayout.CENTER);
		buttonPanel.setFocusable(true);

		/*Circle circle = new Circle();
		window.add(circle, BorderLayout.CENTER); //any graphics will be in center*/
		//circle.setForeground(new Color(0,44,128,250)); //change circle foreground
		//System.out.println(screenSize.width + " + " + window.getWidth());

		Button decimal = new Button(".");
		final boolean[] decimalInEntry = {false};
		decimal.addActionListener(action -> {
			if (!decimalInEntry[0] && entryIsZero[0]) {
				entry.setText("0.");
				decimalInEntry[0] = true;
			} else if (!decimalInEntry[0]) {
				entry.setText(entry.getText() + '.');
				decimalInEntry[0] = true;
			}
		});
		buttonPanel.add(decimal, "cell 2 4");

		Button zero = new Button("0");
		zero.addActionListener(action -> {
			if (!entryIsZero[0]) entry.setText(entry.getText() + '0');
		});
		buttonPanel.add(zero, "cell 1 4");

		Button plusMinus = new Button("±");
		final boolean[] entryIsNegative = {false};
		plusMinus.addActionListener(action -> {
			if (!entryIsNegative[0] && !entryIsZero[0]) {
				entry.setText('-' + entry.getText());
				entryIsNegative[0] = true;
			} else if (!entryIsZero[0]) {
				entry.setText(entry.getText().substring(1));
				entryIsNegative[0] = false;
			}
		});
		buttonPanel.add(plusMinus, "cell 0 4");

		Button one = new Button("1");
		one.addNumberAction(entry, entryIsZero, decimalInEntry, 1);
		buttonPanel.add(one, "cell 0 3");

		Button two = new Button("2");
		two.addNumberAction(entry, entryIsZero, decimalInEntry, 2);
		buttonPanel.add(two, "cell 1 3");

		Button three = new Button("3");
		three.addNumberAction(entry, entryIsZero, decimalInEntry, 3);
		buttonPanel.add(three, "cell 2 3");

		Button four = new Button("4");
		four.addNumberAction(entry, entryIsZero, decimalInEntry, 4);
		buttonPanel.add(four, "cell 0 2");

		Button five = new Button("5");
		/*font size 33
		five.setFont(new Font("Segoe UI",Font.BOLD,33));*/
		five.addNumberAction(entry, entryIsZero, decimalInEntry, 5);
		buttonPanel.add(five, "cell 1 2");

		Button six = new Button("6");
		six.addNumberAction(entry, entryIsZero, decimalInEntry,6);
		buttonPanel.add(six, "cell 2 2");

		Button seven = new Button("7");
		seven.addNumberAction(entry, entryIsZero, decimalInEntry, 7);
		buttonPanel.add(seven, "cell 0 1");

		Button eight = new Button("8");
		eight.addNumberAction(entry, entryIsZero, decimalInEntry, 8);
		buttonPanel.add(eight, "cell 1 1");

		Button nine = new Button("9");
		nine.addNumberAction(entry, entryIsZero, decimalInEntry, 9);
		buttonPanel.add(nine, "cell 2 1");

		Button clearEntry = new Button("CE");
		//clearEntry.setFont(clearEntry.getFont().deriveFont(Font.PLAIN,33f));
		clearEntry.addActionListener(action -> {
			entry.setText("0");
			entryIsZero[0] = true;
			entryIsNegative[0] = false;
			decimalInEntry[0] = false;
		});
		buttonPanel.add(clearEntry, "cell 0 0");

		Button clear = new Button("C");
		//clear.setFont(clear.getFont().deriveFont(Font.PLAIN,33f));
		clear.addActionListener(action -> clear());
		buttonPanel.add(clear, "cell 1 0");

		Button delete = new Button("⌫");
		//delete.setFont(new Font("Dialog", Font.PLAIN, 33));
		delete.addActionListener(action -> delete(entryIsZero, entryIsNegative, decimalInEntry, entry));
		buttonPanel.add(delete, "cell 2 0");

		buttonPanel.addKeyListener(new KeyListener() {
			//KeyListeners for chars
			@Override
			public void keyTyped(KeyEvent e) {
				if (entryIsZero[0] && !decimalInEntry[0]) switch (e.getKeyChar()) {
					case '0':
						break;
					case '1':
						entry.setText("1");
						entryIsZero[0] = false;
						break;
					case '2':
						entry.setText("2");
						entryIsZero[0] = false;
						break;
					case '3':
						entry.setText("3");
						entryIsZero[0] = false;
						break;
					case '4':
						entry.setText("4");
						entryIsZero[0] = false;
						break;
					case '5':
						entry.setText("5");
						entryIsZero[0] = false;
						break;
					case '6':
						entry.setText("6");
						entryIsZero[0] = false;
						break;
					case '7':
						entry.setText("7");
						entryIsZero[0] = false;
						break;
					case '8':
						entry.setText("8");
						entryIsZero[0] = false;
						break;
					case '9':
						entry.setText("9");
						entryIsZero[0] = false;
						break;
					case '.':
						entry.setText("0.");
						decimalInEntry[0] = true;
						break;
				}
				else switch (e.getKeyChar()) {
					case '0':
						entry.setText(entry.getText() + '0');
						entryIsZero[0] = false;
						break;
					case '1':
						entry.setText(entry.getText() + '1');
						entryIsZero[0] = false;
						break;
					case '2':
						entry.setText(entry.getText() + '2');
						entryIsZero[0] = false;
						break;
					case '3':
						entry.setText(entry.getText() + '3');
						entryIsZero[0] = false;
						break;
					case '4':
						entry.setText(entry.getText() + '4');
						entryIsZero[0] = false;
						break;
					case '5':
						entry.setText(entry.getText() + '5');
						entryIsZero[0] = false;
						break;
					case '6':
						entry.setText(entry.getText() + '6');
						entryIsZero[0] = false;
						break;
					case '7':
						entry.setText(entry.getText() + '7');
						entryIsZero[0] = false;
						break;
					case '8':
						entry.setText(entry.getText() + '8');
						entryIsZero[0] = false;
						break;
					case '9':
						entry.setText(entry.getText() + '9');
						entryIsZero[0] = false;
						break;
					case '.':
						if (!decimalInEntry[0]) {
							entry.setText(entry.getText() + '.');
							decimalInEntry[0] = true;
						}
						break;
				}
			}

			//KeyListeners for function keys/anything not a normal key
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_F9:
						if (!entryIsNegative[0] && !entryIsZero[0]) {
							entry.setText("-" + entry.getText());
							entryIsNegative[0] = true;
						} else if (!entryIsZero[0]) {
							entry.setText(entry.getText().substring(1));
							entryIsNegative[0] = false;
						}
						break;
					case KeyEvent.VK_ESCAPE:
						clear();
						break;
					case KeyEvent.VK_BACK_SPACE:
						delete(entryIsZero, entryIsNegative, decimalInEntry, entry);
						break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
	}

	private static void delete(boolean[] entryIsZero, boolean[] entryIsNegative, boolean[] decimalInEntry, JLabel entry) {
		if (!entryIsZero[0]) {
			if (entry.getText().charAt(entry.getText().length() - 1) == '.') {
				decimalInEntry[0] = false;
			}
			entry.setText(entry.getText().substring(0, entry.getText().length() - 1));
			if (entry.getText().length() == 1 && entryIsNegative[0]) {
				entry.setText("0");
				entryIsZero[0] = true;
				entryIsNegative[0] = false;
			}
			if (entry.getText().length() == 0 && !entryIsNegative[0]) {
				entry.setText("0");
				entryIsZero[0] = true;
			}
		}
	}

	private void clear() {
		System.out.println("CALCULATOR CLEARED");
	}

	private void disableButtons() {

	}

	public void setWindowName(String windowName) {
		window.setTitle(windowName);
	}

	public void setVisibility(boolean b) {
		window.setVisible(b);
	}

	private void updateWindow() {
		window.revalidate();
		window.repaint();
	}
}
