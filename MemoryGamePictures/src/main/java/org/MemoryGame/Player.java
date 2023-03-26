package org.MemoryGame;

import org.MemoryGame.Cell.AbstractCell;
import org.MemoryGame.Cell.Cell;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


import java.util.List;

public class Player extends AbstractCell implements KeyboardHandler {

    private Grid grid;
    private Cell cell;
    private List<Cell> selected_cells;
    private int max_number_of_guesses;
    private static int selection_counter = 2;

    public Player() {
        Picture playerFrame = new Picture();
        playerFrame.load("mover.png");
        cell.setPicture(playerFrame);
    }


    public void move_left() {
        if (getX() > Grid.CELLSIZE) {
            this.setX(getX() - Grid.CELLSIZE);
            cell.getPicture().translate(-Grid.CELLSIZE, 0);
        }
    }

    public void move_right() {
        if (getX() < grid.getWidth() - Grid.CELLSIZE) {
            this.setX(getX() + Grid.CELLSIZE);
            cell.getPicture().translate(Grid.CELLSIZE, 0);
        }
    }

    public void move_up() {
        if (getY() > Grid.CELLSIZE) {
            this.setY(getY() - Grid.CELLSIZE);
            cell.getPicture().translate(0, -Grid.CELLSIZE);
        }
    }

    public void move_down() {
        if (getY() < grid.getHeight() - Grid.CELLSIZE) {
            this.setY(getY() + Grid.CELLSIZE);
            cell.getPicture().translate(0, Grid.CELLSIZE);
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
            /*case KeyboardEvent.KEY_SPACE:
                this.flip_tile(grid.getCells());
                break;*/
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
