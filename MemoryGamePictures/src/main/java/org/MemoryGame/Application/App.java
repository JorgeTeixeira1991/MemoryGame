package org.MemoryGame.Application;

public class App {
    public static void main(String[] args) {
        App memoryGame = new App();
        Bootstrap bootstrap = new Bootstrap(memoryGame);
        bootstrap.setup();
        bootstrap.init();
    }
}
