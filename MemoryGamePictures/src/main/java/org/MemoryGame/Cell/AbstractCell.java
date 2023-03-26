package org.MemoryGame.Cell;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class AbstractCell {
    private int x, y;
    private Picture picture;

    public void show() {
        picture.draw();
    }


    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
