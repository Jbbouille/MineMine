package org.jbbouille.mine.core;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by JB on 29/09/14.
 */
public class Grid {

    private Cell[][] cells;
    private int width;
    private int height;

    public Grid(GridParameter params) {
        this.cells = new Cell[params.getHeight()][params.getWidth()];
        this.width = params.getWidth() - 1;
        this.height = params.getHeight() - 1;

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                this.cells[i][j] = new Cell(i, j);
            }
        }

        setBombs(params.getNbBomb());
        setValues();
    }

    private void setBombs(int nbBomb) {

        ArrayList<Boolean> bombs = new ArrayList<>();

        int nbOfCells = (width + 1) * (height + 1);

        for (int i = 0; i < nbOfCells; i++) {
            if(i < nbBomb) bombs.add(true);
            else bombs.add(false);
        }

        Collections.shuffle(bombs);

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if(bombs.get(0)) this.cells[i][j].setaBomb(true);
                bombs.remove(0);
            }
        }
    }

    private void setValues() {
        for (int i = 0; i < getCells().length; i++) {
            for (int j = 0; j < getCells()[i].length; j++) {
                getCells()[i][j].setValue(countAdjacentBomb(i, j));
            }
        }
    }

    public boolean reveal(int positionX, int positionY) {
        Cell cell = getCell(positionX, positionY);

        if(cell.isaBomb()) {
            cell.setVisible(true);
            return true;
        }else {
            if (cell.getValue() == 0) {
                cell.setVisible(true);
                cell.setPropagable(false);
                propagate(cell);
            }

            cell.setVisible(true);
            cell.setPropagable(false);

            return false;
        }

    }

    private void propagate(Cell cellRoot) {
        ArrayList<Cell> cellsAdjacent = getAdjacent(cellRoot.getPositionX(), cellRoot.getPositionY());

        for(Cell cell: cellsAdjacent) {
            if(cell.getValue() == 0 && cell.isPropagable()) {
                cell.setPropagable(false);
                propagate(cell);
                cell.setVisible(true);
            }else {
                cell.setVisible(true);
                cell.setPropagable(false);
            }
        }
    }

    private int countAdjacentBomb(int positionY, int positionX) {
        ArrayList<Cell> cellsAdjacent = getAdjacent(positionX, positionY);
        int count = 0;

        for (Cell cell : cellsAdjacent) {
            if(cell.isaBomb()) count++;
        }

        return count;
    }

    private ArrayList<Cell> getAdjacent(int positionX, int positionY) {
        ArrayList<Cell> cellsAdjacent = new ArrayList<>();

        if(positionY - 1 >= 0) {
            if(positionX - 1 >= 0) {
                cellsAdjacent.add(getCell(positionX - 1, positionY - 1));
            }

            cellsAdjacent.add(getCell(positionX, positionY - 1));

            if(positionX + 1 <= getWidth()) {
                cellsAdjacent.add(getCell(positionX + 1, positionY - 1));
            }
        }

        if(positionY + 1 <= getHeight()) {
            if(positionX - 1 >= 0) {
                cellsAdjacent.add(getCell(positionX - 1, positionY + 1));
            }

            cellsAdjacent.add(getCell(positionX, positionY + 1));

            if(positionX + 1 <= getWidth()) {
                cellsAdjacent.add(getCell(positionX + 1, positionY + 1));
            }
        }

        if(positionX - 1 >= 0) {
            cellsAdjacent.add(getCell(positionX - 1, positionY));
        }

        if(positionX + 1 <= getWidth()) {
            cellsAdjacent.add(getCell(positionX + 1, positionY));
        }

        return cellsAdjacent;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Cell getCell(int positionX, int positionY) {
        return cells[positionY][positionX];
    }
}
