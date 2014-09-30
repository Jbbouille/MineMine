package org.jbbouille.mine.core;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by JB on 30/09/14.
 */
public class GridTest {

    @Test
    public void setBombTest() {
        Grid grid = new Grid(new GridParameter(5, 7, 5));

        int numberOfBombSet = 0;

        for (int i = 0; i < grid.getCells().length; i++) {
            for (int j = 0; j < grid.getCells()[i].length; j++) {
                if(grid.getCells()[i][j].isaBomb()) {
                    numberOfBombSet++;
                }
            }
        }

        Assert.assertEquals(5, numberOfBombSet);
    }

    @Test
    public void setValuesTest() {
        Grid grid = new Grid(new GridParameter(5, 7, 5));

        for (int i = 0; i < grid.getCells().length; i++) {
            for (int j = 0; j < grid.getCells()[i].length; j++) {
                if(grid.getCell(j, i).getValue() > 5 || grid.getCell(j, i).getValue() < 0) {
                    Assert.fail("Can't have more adjacent bomb than the number of bomb and less than 0");
                }
            }
        }
    }

    @Test
    public void revealTest() {
        Grid grid = new Grid(new GridParameter(5, 7, 5));

        for (int i = 0; i < grid.getCells().length; i++) {
            for (int j = 0; j < grid.getCells()[i].length; j++) {
                checkReveal(j, i, grid, grid.reveal(j, i));
            }
        }
    }

    public void checkReveal(int x, int y, Grid grid, boolean boom) {
        Cell cell = grid.getCell(x, y);

        if(cell.isaBomb() && !boom) {
            Assert.fail("the cell is a bomb it should BOOOM");
        }

        if(cell.getValue() == 0) {
            if (!(cell.isVisible())) Assert.fail("Cell Should be visible after been reveal");
            checkPropagate(cell, grid);

        }else {
            if (!(cell.isVisible())) Assert.fail("Cell Should be visible after been reveal");
        }
    }

    private void checkPropagate(Cell cellRoot, Grid grid) {
        ArrayList<Cell> cellsAdjacent = getAdjacent(cellRoot.getPositionX(), cellRoot.getPositionY(), grid);

        for(Cell cell: cellsAdjacent) {
            if(cell.getValue() == 0 && cell.isPropagable()) {
                cell.setPropagable(false);
                checkPropagate(cell, grid);
                cell.setVisible(true);
            }else {
                cell.setVisible(true);
                cell.setPropagable(false);
            }

            if (!(cell.isVisible())) Assert.fail("Cell Should be visible after been reveal in propagation");
        }
    }


    /**
     * This is the test of a private method, a bit weird but necessary
     */
    @Test
    public void getAdjacentTest() {
        Grid grid = new Grid(new GridParameter(5, 7, 5));

        for (int i = 0; i < grid.getCells().length; i++) {
            for (int j = 0; j < grid.getCells()[i].length; j++) {

                int adjacent = getAdjacent(j, i, grid).size();

                switch (adjacent) {
                    case 3:
                        break;
                    case 5:
                        break;
                    case 8:
                        break;
                    default: Assert.fail("Can't have adjacent other than 3, 5, 8");
                        break;
                }

            }
        }
    }

    private ArrayList<Cell> getAdjacent(int positionX, int positionY, Grid grid) {
        ArrayList<Cell> cellsAdjacent = new ArrayList<>();

        if(positionY - 1 >= 0) {
            if(positionX - 1 >= 0) {
                cellsAdjacent.add(grid.getCell(positionX - 1, positionY - 1));
            }

            cellsAdjacent.add(grid.getCell(positionX, positionY - 1));

            if(positionX + 1 <= grid.getWidth()) {
                cellsAdjacent.add(grid.getCell(positionX + 1, positionY - 1));
            }
        }

        if(positionY + 1 <= grid.getHeight()) {
            if(positionX - 1 >= 0) {
                cellsAdjacent.add(grid.getCell(positionX - 1, positionY + 1));
            }

            cellsAdjacent.add(grid.getCell(positionX, positionY + 1));

            if(positionX + 1 <= grid.getWidth()) {
                cellsAdjacent.add(grid.getCell(positionX + 1, positionY + 1));
            }
        }

        if(positionX - 1 >= 0) {
            cellsAdjacent.add(grid.getCell(positionX - 1, positionY));
        }

        if(positionX + 1 <= grid.getWidth()) {
            cellsAdjacent.add(grid.getCell(positionX + 1, positionY));
        }

        return cellsAdjacent;
    }
}
