package org.jbbouille.mine.validate;

import org.jbbouille.mine.view.Printer;

import java.util.Scanner;

/**
 * Created by JB on 29/09/14.
 */
public class PositionValidator {

    private int width;
    private int height;

    public PositionValidator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int validateX() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            Printer.xPositionQuestionPrinter();
            int x = sc.nextInt();

            if(x <= width && x > 0) {
                return x - 1;
            }
        }
    }

    public int validateY() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            Printer.yPositionQuestionPrinter();
            int y = sc.nextInt();

            if(y <= height && y > 0) {
                return y - 1;
            }
        }
    }
}
