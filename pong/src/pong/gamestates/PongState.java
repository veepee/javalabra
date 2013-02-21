package pong.gamestates;

import pong.framework.GameState;
import pong.framework.GameStateManager;
import pong.framework.Renderer;
import pong.logic.Game;
import pong.swing.GUI;

public class PongState implements GameState {

    private GameStateManager manager;
    private GUI gui;
    
    private Game game;
    private PongInputHandler inputHandler;
    private PongRenderer renderer;
    
    private boolean isRunning = true;
    
    public PongState(GameStateManager manager, GUI gui) {
        this.manager = manager;
        this.gui = gui;
    }    
    
    @Override
    public void onEnter() {
        game = new Game();
        inputHandler = new PongInputHandler(this, game);
        renderer = new PongRenderer(this, game, gui.getCanvasPanel());
    }

    @Override
    public void onExit() {
    }

    @Override
    public void update(long delta) {
        if(!isRunning) {
            manager.exit();
        }
        
        if(game.isGameOver()) {
            manager.exit();
            manager.enter(new HighscoreEntryState(manager, gui, this));
        }
        
        inputHandler.handle(delta, gui.getKeyEventListener().getKeyState());
                
        game.updateLogic(delta);
        renderer.render();
    }
    
    protected Game getGame() {
        return game;
    }
    
    protected Renderer getRenderer() {
        return renderer;
    }
    
    protected void enterIngameMenu() {
        manager.enter(new IngameMenuState(manager, gui, this));
    }

    protected void exit() {
        isRunning = false;
    }
}
