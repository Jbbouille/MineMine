package org.jbbouille.mine.core;

/**
 * Created by JB on 29/09/14.
 */
public class Cell {
    private boolean propagable;
    private boolean aBomb;
    private boolean visible;
    private int value;
    private int positionX;
    private int positionY;

    public Cell(int positionY, int positionX) {
        this.propagable = true;
        this.aBomb = false;
        this.visible = false;
        this.value = 0;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public boolean isPropagable() {
        return propagable;
    }

    public void setPropagable(boolean propagable) {
        this.propagable = propagable;
    }

    public boolean isaBomb() {
        return aBomb;
    }

    public void setaBomb(boolean aBomb) {
        this.aBomb = aBomb;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
