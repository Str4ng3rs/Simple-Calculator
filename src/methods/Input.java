package methods;

import java.util.Scanner;

/*
*
*  A simple input class for command line.
*
*/

public class Input {

	public static String string(String message) {
		Scanner scan = new Scanner(System.in);
		if (!message.equals("")) {
			System.out.print(message);
		}
		String output = scan.next();
		scan.close();
		return output;
	}

	public static int num(String message) {
		if (!message.equals("")) {
			System.out.print(message);
		}
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				int output = scan.nextInt();
				scan.close();
				return output;
			} catch (Exception e) {
				System.out.print("That is not an integer.  Enter again: ");
			}
		}
	}

	public static double dub(String message) {
		if (!message.equals("")) {
			System.out.print(message);
		}
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				double output = scan.nextDouble();
				scan.close();
				return output;
			} catch (Exception e) {
				System.out.print("That is not a number.  Enter again: ");
			}
		}
	}

	public static char chr(String message) {
		if (!message.equals("")) {
			System.out.print(message);
		}
		String output = null;
		Scanner scan = new Scanner(System.in);
		output = scan.next();
		scan.close();
		while (output.length() != 1) {
			System.out.print("That is not a single character.  Enter again: ");
			output = scan.next();
		}
		return output.charAt(0);
	}

}
