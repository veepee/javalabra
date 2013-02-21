package pong.gamestates;

import pong.framework.GameState;
import pong.framework.GameStateManager;
import pong.highscores.HighscoresDAO;
import pong.swing.GUI;

/**
 * The Highscores game state for displaying the highscores
 * @author veepee
 */
public class HighscoresState implements GameState {
    
    /**
     * The GUI of this game instance
     */
    private GUI gui;
    /**
     * The GameStateManager of this game instance
     */
    private GameStateManager manager;
    
    /**
     * The renderer of this game state
     */
    private HighscoresRenderer renderer;
    /**
     * The input handler of this game state
     */
    private HighscoresInputHandler inputHandler;
    
    /**
     * The HighscoresDAO object for reading the highscore entries
     */
    private HighscoresDAO highscores;
    
    /**
     * Creates a new Highscores game state
     * @param manager The GameStateManager of this game instance
     * @param gui The GUI of this game instance
     */
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
    
    /**
     * Returns the HighscoresDAO interface for accessing the highscores stored on disk
     * @return The HighscoresDAO interface
     */
    protected HighscoresDAO getHighscores() {
        return highscores;
    }
    
    /**
     * Exits this game state
     */
    protected void exit() {
        manager.exit();
    }

}