package org.MemoryGame.GameLogic;

import org.MemoryGame.Application.Bootstrap;
import org.MemoryGame.Cell.PictureRandomizer;
import org.MemoryGame.Grid;
import org.MemoryGame.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Grid grid;
    private CellMatchChecker cellMatchChecker;
    private int hitCounter;

    public void gridGameSetup() {
        grid.fill_grid();
        grid.show();
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void countHits() {
      hitCounter++;
    }


    public void start() throws InterruptedException {

        boolean win = false, gameOver = false, hit;

        while (!win && !gameOver) {
            Thread.sleep(4000);
            if (cellMatchChecker.checkSelectedCellsMatch()) {
                countHits();
                System.out.println("hey");
            }
            if (hitCounter == 2) {
                win = true;
            }

        }

    }

    public void setCellMatchChecker(CellMatchChecker cellMatchChecker) {
        this.cellMatchChecker = cellMatchChecker;
    }
}
