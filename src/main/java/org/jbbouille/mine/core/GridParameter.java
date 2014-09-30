package org.jbbouille.mine.core;

/**
 * Created by JB on 29/09/14.
 */
public class GridParameter {
    private int nbBomb;
    private int width;
    private int height;

    public GridParameter(int nbBomb, int width, int height) {
        this.nbBomb = nbBomb;
        this.width = width;
        this.height = height;
    }

    public int getNbBomb() {
        return nbBomb;
    }

    public void setNbBomb(int nbBomb) {
        this.nbBomb = nbBomb;
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
}
