package org.MemoryGame.Application;

import org.MemoryGame.Cell.PictureRandomizer;
import org.MemoryGame.GameLogic.CellMatchChecker;
import org.MemoryGame.GameLogic.Game;
import org.MemoryGame.Grid;
import org.MemoryGame.Player;

public class Bootstrap {

    public void setup(Game game){
        CellMatchChecker cellMatchChecker = new CellMatchChecker();
        Grid grid = new Grid(4,4);
        grid.setPictureRandomizer(new PictureRandomizer());
        game.setGrid(grid);
        game.gridGameSetup();
        Player player = new Player();
        player.setCellMatchChecker(cellMatchChecker);
        player.setGrid(grid);
        cellMatchChecker.setPlayer(player);
        game.setCellMatchChecker(cellMatchChecker);
    }

}
