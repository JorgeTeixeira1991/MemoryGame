package org.MemoryGame.GameLogic;

import org.MemoryGame.Cell.Cell;
import org.MemoryGame.Player;

public class CellMatchChecker {

    private Player player;

    public boolean checkSelectedCellsMatch() throws InterruptedException {

        while (player.getSelected_cells().size() == 2) {
            Cell cell1 = player.getSelected_cells().get(0);
            Cell cell2 = player.getSelected_cells().get(1);

            if (cell1.getDescription().equals(cell2.getDescription())) {

                cell1.lock(true);
                cell2.lock(true);
                player.getSelected_cells().clear();
                player.setSelection_counter(2);
                return true;

            } else {
                System.out.println();
                player.setMax_number_of_guesses(player.getMax_number_of_guesses() - 1);
                cell1.setHidden(true);
                cell2.setHidden(true);
                cell1.redraw();
                cell2.redraw();

                player.getPicture().delete();
                player.getPicture().draw();

                player.getSelected_cells().clear();
                player.setSelection_counter(2);
                return false;
            }
        }
        return false;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
