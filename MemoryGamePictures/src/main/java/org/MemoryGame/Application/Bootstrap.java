package org.MemoryGame.Application;

import org.MemoryGame.Grid;

public class Bootstrap {

    private App app;

    public Bootstrap(App app) {
        this.app = app;
    }

    public void setup(){
        Grid grid = new Grid(4,4);
        grid.show();
        grid.fill_grid();
    }

    public void init(){

    }

}
