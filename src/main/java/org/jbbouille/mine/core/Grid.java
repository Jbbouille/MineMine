package org.jbbouille.mine.core;

/**
 * Created by excilysJB on 29/09/14.
 */
public class Grid {

    private Cell[][] cells;

    public Grid(Cell[][] cells) {
        this.cells = cells;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}