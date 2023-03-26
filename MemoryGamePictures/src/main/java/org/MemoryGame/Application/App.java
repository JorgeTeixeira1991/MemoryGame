package org.MemoryGame.Application;

import org.MemoryGame.GameLogic.Game;

public class App {

    private Game game;

    public App(Game game) {
        this.game = game;
    }

    public void start(){
        try {
            game.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.setup(game);
        App app = new App(game);
        app.start();
    }
}
