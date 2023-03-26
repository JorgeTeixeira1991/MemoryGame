package org.MemoryGame;

import org.MemoryGame.Cell.AbstractCell;
import org.MemoryGame.Cell.Cell;
import org.MemoryGame.GameLogic.CellMatchChecker;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


import java.util.ArrayList;
import java.util.List;

public class Player extends AbstractCell implements KeyboardHandler {

    private Grid grid;
    private List<Cell> selected_cells;
    private int max_number_of_guesses;
    private int selection_counter = 2;
    private CellMatchChecker cellMatchChecker;

    public Player() {
        this.selected_cells = new ArrayList<>();
        Picture playerFrame = new Picture();
        playerFrame.load("mover.png");
        playerFrame.translate(Grid.PADDING, Grid.PADDING);
        setPicture(playerFrame);
        setX(Grid.PADDING);
        setY(Grid.PADDING);
        show();
        init();
    }

    public void flip_tile(Cell[][] cells) {

        for (int i = 0; i < grid.getCols(); i++) {
            for (int j = 0; j < grid.getRows(); j++) {
                if (getX() == cells[i][j].getX()
                        && getY() == cells[i][j].getY()
                        && cells[i][j].isHidden()
                        && selection_counter > 0
                        && !cells[i][j].isLocked()) {
                    cells[i][j].flip();
                    cells[i][j].setHidden(false);
                    if (selected_cells.size() < 2) {
                        selected_cells.add(cells[i][j]);
                        selection_counter--;
                    }
                }
            }
        }
    }

    public void setCellMatchChecker(CellMatchChecker cellMatchChecker) {
        this.cellMatchChecker = cellMatchChecker;
    }

    public List<Cell> getSelected_cells() {
        return selected_cells;
    }

    public int getMax_number_of_guesses() {
        return max_number_of_guesses;
    }

    public void setMax_number_of_guesses(int max_number_of_guesses) {
        this.max_number_of_guesses = max_number_of_guesses;
    }

    public void setSelection_counter(int selection_counter) {
        this.selection_counter = selection_counter;
    }

    public void move_left() {
        if (getX() > Grid.PADDING) {
            this.setX(getX() - Grid.CELLSIZE);
            getPicture().translate(-Grid.CELLSIZE, 0);
        }
    }

    public void move_right() {
        if (getX() < grid.getWidth() - Grid.CELLSIZE) {
            this.setX(getX() + Grid.CELLSIZE);
            getPicture().translate(Grid.CELLSIZE, 0);
        }
    }

    public void move_up() {
        if (getY() > Grid.PADDING) {
            this.setY(getY() - Grid.CELLSIZE);
            getPicture().translate(0, -Grid.CELLSIZE);
        }
    }

    public void move_down() {
        if (getY() < grid.getHeight() - Grid.CELLSIZE) {
            this.setY(getY() + Grid.CELLSIZE);
            getPicture().translate(0, Grid.CELLSIZE);
        }
    }

    public void init() {

        Keyboard kb = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        kb.addEventListener(right);


        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        kb.addEventListener(left);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        kb.addEventListener(up);


        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        kb.addEventListener(down);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        kb.addEventListener(space);


    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT -> this.move_left();
            case KeyboardEvent.KEY_RIGHT -> this.move_right();
            case KeyboardEvent.KEY_UP -> this.move_up();
            case KeyboardEvent.KEY_DOWN -> this.move_down();
            case KeyboardEvent.KEY_SPACE -> this.flip_tile(grid.getCells());
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
