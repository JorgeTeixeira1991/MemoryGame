package org.MemoryGame.Cell;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Cell extends AbstractCell{

    private boolean hidden;
    private boolean locked;
    private Picture top_tile;
    private String description;

    public Cell() {
        super();
        this.hidden = true;
        this.top_tile = new Picture(super.getX(), super.getY(), "TopTile.jpg");

    }

    @Override
    public void show() {
        super.show();
        top_tile.draw();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
