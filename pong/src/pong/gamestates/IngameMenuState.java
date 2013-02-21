package pong.gamestates;

import pong.framework.GameState;
import pong.framework.GameStateManager;
import pong.swing.GUI;

/**
 * The IngameMenu game state for handling the in-game menu with resume and exit game options
 * @author veepee
 */
public class IngameMenuState implements GameState {

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
    private IngameMenuRenderer renderer;
    /**
     * The input handler of this game state
     */
    private IngameMenuInputHandler inputHandler;
    
    /**
     * The current ingame-menu item selected by the user
     */
    private int userSelection;
    
    /**
     * The PongState calling this game state
     */
    private PongState pongState;
    
    /**
     * Creates a new IngameMenu game state
     * @param manager The GameStateManager of this game instance
     * @param gui The GUI of this game instance
     * @param pongState The PongState calling this game state
     */
    public IngameMenuState(GameStateManager manager, GUI gui, PongState pongState) {
        this.manager = manager;
        this.gui = gui;
        
        this.pongState = pongState;
    }
    
    @Override
    public void onEnter() {
        renderer = new IngameMenuRenderer(this, gui.getCanvasPanel());
        inputHandler = new IngameMenuInputHandler(this);
        
        userSelection = 0;
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
     * Returns the current ingame-menu item selected by the user
     * @return The current ingame-menu item selected by the user
     */
    protected int getUserSelection() {
        return userSelection;
    }

    /**
     * Sets the user ingame-menu selection
     * @param userSelection Index of the ingame-menu item user selection will be set to
     */
    protected void setUserSelection(int userSelection) {
        this.userSelection = userSelection;
    }
    
    /**
     * Returns the PongState calling this game state
     * @return The PongState calling this game state
     */
    protected PongState getPongState() {
        return pongState;
    }
    
    /**
     * Resumes the game
     */
    protected void resume() {
        manager.exit();
    }
    
    /**
     * Exits the game
     */
    protected void exit() {
        pongState.exit();
        manager.exit();
    }

}