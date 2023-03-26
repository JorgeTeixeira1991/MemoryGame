package org.MemoryGame;

import org.MemoryGame.Cell.Cell;
import org.MemoryGame.Cell.PictureRandomizer;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    public static final int CELLSIZE = 200;
    public static final int PADDING = 10;
    private int height, width, cols, rows;
    private PictureRandomizer pictureRandomizer;
    private Cell[][] cells;
    private Rectangle rectangle;
    private Picture bottom;

    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.cells = new Cell[cols][rows];
        this.height = rows * CELLSIZE;
        this.width = cols * CELLSIZE;
        this.rectangle = new Rectangle(PADDING, PADDING, width, height);
        this.bottom = new Picture(PADDING * 2 - 2, height + PADDING, "Bottom.jpg");
    }

    public void show() {
        this.rectangle.draw();
        this.bottom.draw();
    }

    public void fill_grid() {
        int x = PADDING, y = PADDING;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell c = new Cell();
                Picture p = pictureRandomizer.randomizePicture();
                setCellDescription(c, pictureRandomizer.getFilePath());
                setupCellPicture(c, p);
                setTranslation(c,x,y);
                setupCellXY(c,x,y);
                cells[j][i] = c;
                x += CELLSIZE;
            }
            x = PADDING;
            y += CELLSIZE;
        }
        drawCells();
    }

    public void setupCellPicture(Cell c, Picture p){
        c.setPicture(p);
    }
    public void setupCellXY(Cell c, int x, int y){
        c.setX(x);
        c.setY(y);
    }

    public void setTranslation(Cell c,int x, int y){
        c.getPicture().translate(x,y);
        c.getTop_tile().translate(x,y);
    }
    public void setCellDescription(Cell c, String description){
        c.setDescription(description);
    }
    public void drawCells() {
        for (Cell[] row : cells) {
            for (Cell c : row) {
                c.show();
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setPictureRandomizer(PictureRandomizer pictureRandomizer) {
        this.pictureRandomizer = pictureRandomizer;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public Cell[][] getCells() {
        return cells;
    }
}
