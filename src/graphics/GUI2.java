package methods;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JToolBar;
import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;

import javax.swing.JPopupMenu;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Window.Type;

/*
*
* Reference GUI using WindowBuilder by Eclipse
*
*/

public class GUI2 {

	private JFrame frmWindow;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI2 window = new GUI2();
					window.frmWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWindow = new JFrame();
		frmWindow.setResizable(false);
		frmWindow.setTitle("WINDOW");
		frmWindow.setBounds(100, 100, 640, 360);
		frmWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmWindow.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[:100.00%:]", "[24.00px][][]"));
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel, "cell 0 0,alignx center,aligny center");
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnNewButton, "flowx,cell 0 1");
		
		JPopupMenu popupMenu_2 = new JPopupMenu();
		addPopup(btnNewButton, popupMenu_2);
		
		JButton btnNewButton_5 = new JButton("New button");
		popupMenu_2.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		popupMenu_2.add(btnNewButton_6);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1, "cell 0 1");
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		addPopup(btnNewButton_1, popupMenu_1);
		
		JButton btnNewButton_7 = new JButton("New button");
		popupMenu_1.add(btnNewButton_7);
		
		JButton btnNewButton_3 = new JButton("New button");
		popupMenu_1.add(btnNewButton_3);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == 2) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
