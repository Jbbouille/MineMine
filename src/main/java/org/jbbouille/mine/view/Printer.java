package org.jbbouille.mine.view;

import org.jbbouille.mine.core.Cell;
import org.jbbouille.mine.core.Grid;

/**
 * Created by JB on 30/09/14.
 */
public class Printer {
    public static void gridPrinter(Grid grid) {
        StringBuilder str = new StringBuilder();

        Cell[][] cells = grid.getCells();

        for (int i = 0; i < cells.length; i++) {
            str.append("\t");

            for (int j = 0; j < cells[i].length; j++) {
                str.append(cellToString(cells[i][j]));
            }

            str.append("\n");
        }

        System.out.println(str.toString());
    }

    public static void xPositionQuestionPrinter() {
        System.out.println("What position do you want to reveal X ?");
    }

    public static void yPositionQuestionPrinter() {
        System.out.println("What position do you want to reveal Y ?");
    }

    public static void nbBombQuestionPrinter() {
        System.out.println("What will be th number of Bombs ?");
    }

    public static void widthQuestionPrinter() {
        System.out.println("What is the width of the Minesweeper ?");
    }

    public static void heightQuestionPrinter() {
        System.out.println("What is the height of the Minesweeper ?");
    }

    private static String cellToString(Cell cell) {
        StringBuilder str = new StringBuilder();

        if(cell.isVisible()) {

            if(cell.isaBomb()) {
                str.append("|_").append("*").append("_|");
            }else {
                str.append("|_").append(cell.getValue()).append("_|");
            }

        }else {
            str.append("|___|");
        }

        return str.toString();
    }
}
