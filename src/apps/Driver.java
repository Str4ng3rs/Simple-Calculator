package apps;

import methods.GUI;

import java.awt.*;

public class Driver {
	public static void main(String[] args) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//GUI window = new GUI("Algebra Calculator",320,180,854,480);
		EventQueue.invokeLater(() -> {
			try {
				GUI window = new GUI("Algebra Calculator", (screenSize.width/2)-200, (screenSize.height/2)-332,400, 664);
				window.setVisibility(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
    /*JToolBar toolBar = new JToolBar("Menu");
    toolBar.setFloatable(false);
    //"","[128px][72px]","[72px][]"
    JButton evaluateButton = window.newButton("Evaluate", KeyEvent.VK_E);
    toolBar.add(evaluateButton);*/

		//while (window.getButtonStatus() == false){}
		//GUI2.createWindow(Integer.parseInt(s) + 3 + "");
		//System.out.println(Integer.parseInt(s) + 3);

	}
}
