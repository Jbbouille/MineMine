package org.jbbouille.mine.core;

/**
 * Created by excilysJB on 29/09/14.
 */
public class Cell {
    private boolean propagable;
    private boolean aBomb;
    private short value;
    private short length;
    private short height;

    public Cell(short length, short height) {
        this.propagable = false;
        this.aBomb = false;
        this.value = 0;
        this.length = length;
        this.height = height;
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

    public short getValue() {
        return value;
    }

    public void setValue(short value) {
        this.value = value;
    }

    public short getLength() {
        return length;
    }

    public void setLength(short length) {
        this.length = length;
    }

    public short getHeight() {
        return height;
    }

    public void setHeight(short height) {
        this.height = height;
    }
}
