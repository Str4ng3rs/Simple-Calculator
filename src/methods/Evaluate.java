package methods;

import structures.Stack;
import java.math.*;

/*
*
* Evaluate class used to calculate inputs from GUIBak.
*
*/

public class Evaluate {
    public static double evaluate(String input){

        return -1;
    }
    private static boolean hasEqualParen(String string){
        int parenCount = 0;
        for (int i = 0; i < string.length()-1; i ++){
            if (string.charAt(i) == '('){
                parenCount ++;
            }
        }{
            int i = 0;
            while (parenCount != 0 && i < string.length()-1){
                if (string.charAt(i) == '('){

                }
            }
        }

        for (int i = 0; i < string.length()-1; i ++){
            if (string.charAt(i) == '('){
                parenCount ++;
            } else if (string.charAt(i) == ')'){
                parenCount --;
            }
        }
        return false;
    }
    private static String splitParen (String string){

        return null;
    }
}