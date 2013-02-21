package pong.gamestates;

import pong.framework.GameState;
import pong.framework.GameStateManager;
import pong.framework.Renderer;
import pong.logic.Game;
import pong.swing.GUI;

/**
 * The Pong game state containing the main game logic
 * @author veepee
 */
public class PongState implements GameState {

    /**
     * The GameStateManager of this game instance
     */
    private GameStateManager manager;
    /**
     * The GUI of this game instance
     */
    private GUI gui;
    
    /**
     * The Game instance currently active
     */
    private Game game;
    /**
     * The input handler of this game state
     */
    private PongInputHandler inputHandler;
    /**
     * The renderer of this game state
     */
    private PongRenderer renderer;
    
    /**
     * Is the game running
     */
    private boolean isRunning = true;
    
    /**
     * Creates a new Pong game state
     * @param manager The GameStateManager of this game instance
     * @param gui The GUI of this game instance
     */
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
    
    /**
     * Returns the currently active Game instance
     * @return The currently active Game instance
     */
    protected Game getGame() {
        return game;
    }
    
    /**
     * Returns the renderer for this game state
     * @return The renderer for this game state
     */
    protected Renderer getRenderer() {
        return renderer;
    }
    
    /**
     * Enters the ingame-menu
     */
    protected void enterIngameMenu() {
        manager.enter(new IngameMenuState(manager, gui, this));
    }

    /**
     * Exits this game state
     */
    protected void exit() {
        isRunning = false;
    }
}
