package org.MemoryGame.Cell;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Cell extends AbstractCell{

    private boolean hidden;
    private boolean locked;
    private Picture top_tile;

    public Cell() {
        super();
        this.hidden = true;
        this.top_tile = new Picture(super.getX(), super.getY(), "TopTile.jpg");

    }

    public void setup(Picture picture, int x, int y){
        super.setup(picture,x,y);
    }

    public void redraw() {
        top_tile.draw();
    }
    public void flip() {
        top_tile.delete();
    }
    public boolean isHidden() {
        return hidden;
    }
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    public void lock(boolean locked) {
        this.locked = locked;
    }
    public boolean isLocked() {
        return locked;
    }

    public Picture getTop_tile() {
        return top_tile;
    }
}
