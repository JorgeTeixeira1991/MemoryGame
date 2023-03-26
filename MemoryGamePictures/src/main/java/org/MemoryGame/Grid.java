package org.MemoryGame;

import org.MemoryGame.Cell.Cell;
import org.MemoryGame.Cell.PictureRandomizer;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    public static final int CELLSIZE = 200;
    public static final int PADDING = 10;
    private int height, width, cols, rows;
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
        double x = PADDING, y = PADDING;
        PictureRandomizer pictureRandomizer = new PictureRandomizer();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell c = new Cell();
                c.setPicture(pictureRandomizer.randomizePicture());
                cells[j][i] = c;
                cells[j][i].getPicture().translate(x,y);
                cells[j][i].getPicture().draw();
                cells[j][i].getTop_tile().translate(x,y);
                cells[j][i].getTop_tile().draw();
                cells[j][i].setX((int) x);
                cells[j][i].setY((int) y);
                System.out.println(x);
                System.out.println(y);
                x += CELLSIZE;
            }
            x = PADDING;
            y += CELLSIZE;
        }
        drawCells();
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
}
