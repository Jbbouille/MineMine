package org.jbbouille.mine.main;

import org.jbbouille.mine.core.Grid;
import org.jbbouille.mine.validate.GridParameterValidator;
import org.jbbouille.mine.validate.PositionValidator;
import org.jbbouille.mine.view.Printer;

/**
 * Created by JB on 29/09/14.
 */
public class Main {
    public static void main(String... args) {

        GridParameterValidator gridValidator = new GridParameterValidator();

        Grid grid = new Grid(gridValidator.getParams());

        PositionValidator positionValidator = new PositionValidator(gridValidator.getParams().getWidth(), gridValidator.getParams().getHeight());

        Printer.gridPrinter(grid);

        boolean boom = false;
        while (!boom) {
            int x = positionValidator.validateX();

            int y = positionValidator.validateY();

            boom = grid.reveal(x, y);

            if (boom) System.out.println("BOOM !!!!!!!!!!!!!");

            Printer.gridPrinter(grid);
        }
    }
}
