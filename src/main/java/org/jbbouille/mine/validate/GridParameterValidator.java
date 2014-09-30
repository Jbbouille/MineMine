package org.jbbouille.mine.validate;

import org.jbbouille.mine.core.GridParameter;
import org.jbbouille.mine.view.Printer;

import java.util.Scanner;

/**
 * Created by JB on 29/09/14.
 */
public class GridParameterValidator {

    private GridParameter params;

    public GridParameterValidator() {

        int width = validateWidth();
        int height = validateHeight();
        int nbBomb = validateNbBomb(width, height);

        params = new GridParameter(nbBomb, width, height);
    }

    private int validateWidth() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            Printer.widthQuestionPrinter();
            int width = sc.nextInt();

            if(width < 20 && width > 0) {
                return width;
            }
        }
    }

    private int validateHeight() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            Printer.heightQuestionPrinter();
            int height = sc.nextInt();

            if(height < 20 && height > 0) {
                return height;
            }
        }
    }

    private int validateNbBomb(int width, int height) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            Printer.nbBombQuestionPrinter();
            int nbBomb = sc.nextInt();

            if(nbBomb < (width * height) && nbBomb > 0) {
                return nbBomb;
            }
        }
    }

    public GridParameter getParams() {
        return params;
    }

    public void setParams(GridParameter params) {
        this.params = params;
    }
}
