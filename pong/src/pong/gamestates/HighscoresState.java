package pong.gamestates;

import pong.framework.GameState;
import pong.framework.GameStateManager;
import pong.highscores.HighscoresDAO;
import pong.swing.GUI;

public class HighscoresState implements GameState {
    
    private GUI gui;
    private GameStateManager manager;
    
    private HighscoresRenderer renderer;
    private HighscoresInputHandler inputHandler;
    
    private HighscoresDAO highscores;
    
    public HighscoresState(GameStateManager manager, GUI gui) {
        this.manager = manager;
        this.gui = gui;
        
        highscores = new HighscoresDAO("highscores.dat");
    }
    
    @Override
    public void onEnter() {
        inputHandler = new HighscoresInputHandler(this);
        renderer = new HighscoresRenderer(this, gui.getCanvasPanel());
    }

    @Override
    public void onExit() {
    }

    @Override
    public void update(long delta) {
        inputHandler.handle(delta, gui.getKeyEventListener().getKeyState());
        renderer.render();
    }
    
    protected HighscoresDAO getHighscores() {
        return highscores;
    }
    
    protected void exit() {
        manager.exit();
    }

}