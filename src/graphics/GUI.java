package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class GUI {

	private static final long serialVersionUID = 1L;
	private JFrame window;
	private JLabel console;
	private JLabel expression;

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

		expression = new JLabel("0",SwingConstants.RIGHT);
		expression.setFont(new Font("Segoe UI",Font.BOLD,30));
		userInterface.add(expression,"alignx right, aligny center");
		final Boolean[] expressionIsZero = {true};

		JPanel buttonPanel = new JPanel(new MigLayout("", "-1[:96px:]", "-1[66px]"));
		window.add(buttonPanel, BorderLayout.CENTER);
		buttonPanel.setFocusable(true);

		/*Circle circle = new Circle();
		window.add(circle, BorderLayout.CENTER); //any graphics will be in center*/

		System.out.println(screenSize.width + " + " + window.getWidth());
		//circle.setForeground(new Color(0,44,128,250));

		JButton plusMinus = new JButton("±");
		plusMinus.setPreferredSize(new Dimension(96,66));
		final Boolean[] expressionIsNegative = {false};
		plusMinus.setFont(new Font("Segoe UI",Font.BOLD,33));
		plusMinus.addActionListener(action -> {
			if (!expressionIsNegative[0] && !expressionIsZero[0]){
				expression.setText('-' + expression.getText());
				expressionIsNegative[0] = true;
			}else {
				expression.setText(expression.getText().substring(1));
				expressionIsNegative[0] = false;
			}
		});
		buttonPanel.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F9){
					if (!expressionIsNegative[0] && !expressionIsZero[0]){
						expression.setText("-" + expression.getText());
						expressionIsNegative[0] = true;
					}else {
						expression.setText(expression.getText().substring(1));
						expressionIsNegative[0] = false;
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		buttonPanel.add(plusMinus,"cell 0 3");
		plusMinus.setFocusable(false);
		plusMinus.setFocusPainted(false);

		JButton zero = new JButton("0");
		zero.setPreferredSize(new Dimension(96,66));
		zero.setFont(new Font("Segoe UI",Font.BOLD,33));
		zero.addActionListener(action -> {
			if (!expressionIsZero[0]){
				expression.setText(expression.getText()+'0');
			}
		});
		buttonPanel.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '0' && !expressionIsZero[0]){
					expression.setText(expression.getText()+'0');
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		buttonPanel.add(zero,"cell 1 3,alignx left, aligny top");
		zero.setFocusable(false);
		zero.setFocusPainted(false);

		JButton decimal = new JButton(".");
		decimal.setPreferredSize(new Dimension(96,66));
		final Boolean[] decimalInExpression = {false};
		decimal.setFont(new Font("Segoe UI",Font.BOLD,33));
		decimal.addActionListener(action -> {
			if (!decimalInExpression[0]){
				expression.setText(expression.getText()+'.');
				decimalInExpression[0] = true;
			}
		});
		buttonPanel.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '.'){
					if (!decimalInExpression[0]){
						expression.setText(expression.getText()+'.');
						decimalInExpression[0] = true;
					}
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		buttonPanel.add(decimal,"cell 2 3,alignx left, aligny top");
		decimal.setFocusable(false);
		decimal.setFocusPainted(false);

		JButton one = new JButton("1");
		one.setPreferredSize(new Dimension(96,66));
		one.setFont(new Font("Segoe UI",Font.BOLD,33));
		one.addActionListener(action -> {
			if (expressionIsZero[0]){
				expressionIsZero[0] = false;
				expression.setText("1");
			}else {
				expression.setText(expression.getText()+'1');
			}
		});
		buttonPanel.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '1' && !expressionIsZero[0]){
					expression.setText(expression.getText()+'1');
				} else if (e.getKeyChar() == '1' && expressionIsZero[0]){
					expression.setText("1");
					expressionIsZero[0] = false;
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		buttonPanel.add(one,"cell 0 2,alignx left, aligny top");
		one.setFocusable(false);
		one.setFocusPainted(false);

		JButton two = new JButton("2");

		two.setFont(new Font("Segoe UI",Font.BOLD,33));
		two.setPreferredSize(new Dimension(96,66));
		two.addActionListener(action -> {

			expression.setText(expression.getText()+'2');
		});
		buttonPanel.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '2'){
					expression.setText(expression.getText()+'2');
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		buttonPanel.add(two,"cell 1 2,gapx -5 -5, gapy -5 -5");
		two.setFocusable(false);
		two.setFocusPainted(false);

		JButton three = new JButton("3");
		three.setPreferredSize(new Dimension(96,66));
		three.setFont(new Font("Segoe UI",Font.BOLD,33));
		three.addActionListener(action -> {
			expression.setText(expression.getText()+'3');
		});
		buttonPanel.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '3'){
					expression.setText(expression.getText()+'3');
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		buttonPanel.add(three,"cell 2 2,alignx left, aligny top");
		three.setFocusable(false);
		three.setFocusPainted(false);

		JButton four = new JButton("4");
		four.setPreferredSize(new Dimension(96,66));
		four.setFont(new Font("Segoe UI",Font.BOLD,33));
		four.addActionListener(action -> {
			expression.setText(expression.getText()+'4');
		});
		buttonPanel.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '4'){
					expression.setText(expression.getText()+'4');
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		buttonPanel.add(four,"cell 0 1,alignx left, aligny top");
		four.setFocusable(false);
		four.setFocusPainted(false);

		JButton five = new JButton("5");
		five.setPreferredSize(new Dimension(96,66));
		five.setFont(new Font("Segoe UI",Font.BOLD,33));
		five.addActionListener(action -> {
			expression.setText(expression.getText()+'5');
		});
		buttonPanel.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '5'){
					expression.setText(expression.getText()+'5');
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		buttonPanel.add(five,"cell 1 1,alignx left, aligny top");
		five.setFocusable(false);
		five.setFocusPainted(false);

		JButton six = new JButton("6");
		six.setPreferredSize(new Dimension(96,66));
		six.setFont(new Font("Segoe UI",Font.BOLD,33));
		six.addActionListener(action -> {
			expression.setText(expression.getText()+'6');
		});
		buttonPanel.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '6'){
					expression.setText(expression.getText()+'6');
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		buttonPanel.add(six,"cell 2 1,alignx left, aligny top");
		six.setFocusable(false);
		six.setFocusPainted(false);

		JButton seven = new JButton("7");
		seven.setPreferredSize(new Dimension(96,66));
		seven.setFont(new Font("Segoe UI",Font.BOLD,33));
		seven.addActionListener(action -> {
			expression.setText(expression.getText()+'7');
		});
		buttonPanel.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '7'){
					expression.setText(expression.getText()+'7');
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		buttonPanel.add(seven,"cell 0 0,alignx left, aligny top");
		seven.setFocusable(false);
		seven.setFocusPainted(false);

		JButton eight = new JButton("8");
		eight.setPreferredSize(new Dimension(96,66));
		eight.setFont(new Font("Segoe UI",Font.BOLD,33));
		eight.addActionListener(action -> {
			expression.setText(expression.getText()+'8');
		});
		buttonPanel.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '8'){
					expression.setText(expression.getText()+'8');
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		buttonPanel.add(eight,"cell 1 0,alignx left, aligny top");
		eight.setFocusable(false);
		eight.setFocusPainted(false);

		JButton nine = new JButton("9");
		nine.setPreferredSize(new Dimension(96,66));
		nine.setFont(new Font("Segoe UI",Font.BOLD,33));
		nine.addActionListener(action -> {
			expression.setText(expression.getText()+'9');
		});
		buttonPanel.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '9'){
					expression.setText(expression.getText()+'9');
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		buttonPanel.add(nine,"cell 2 0,alignx left, aligny top");
		nine.setFocusable(false);
		nine.setFocusPainted(false);

		/*NumberButton seven = new NumberButton("7", KeyEvent.VK_1);
		//NumberButton.setFont(new Font("Times New Roman", Font.BOLD, 40));
		NumberButton eight = new NumberButton("8", KeyEvent.VK_X);

		seven.setPanel(panel, "cell 0 0");
		eight.setPanel(panel, "cell 1 1");
		NumberButton.setNewFont(new Font("Times New Roman", Font.BOLD, 40));*/

	}

	private void setWindowName(String windowName) {
		window.setTitle(windowName);
	}

	public void setVisibility(boolean b) {
		window.setVisible(b);
	}
	private void updateWindow(){
		window.revalidate();
		window.repaint();
	}
}
