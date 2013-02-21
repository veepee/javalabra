package pong.gamestates;

import pong.framework.GameState;
import pong.framework.GameStateManager;
import pong.swing.GUI;

/**
 * The Menu game state for handling the game main menu
 * @author veepee
 */
public class MenuState implements GameState {

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
    private MenuRenderer renderer;
    /**
     *  The input handler of this game state
     */
    private MenuInputHandler inputHandler;
    
    /**
     * The current menu item selected by the user
     */
    private int userSelection;
    
    /**
     * Creates a new Menu game state
     * @param manager The GameStateManager of this game instance
     * @param gui The GUI of this game instance
     */
    public MenuState(GameStateManager manager, GUI gui) {
        this.manager = manager;
        this.gui = gui;
    }
    
    @Override
    public void onEnter() {        
        renderer = new MenuRenderer(this, gui.getCanvasPanel());
        inputHandler = new MenuInputHandler(this);
        
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
     * Returns the current menu item selected by the user
     * @return The current menu item selected by the user
     */
    protected int getUserSelection() {
        return userSelection;
    }

    /**
     * Sets the user menu selection
     * @param userSelection Index of the menu item user selection will be set to
     */
    protected void setUserSelection(int userSelection) {
        this.userSelection = userSelection;
    }
    
    /**
     * Starts a new Pong game
     */
    protected void startNewGame() {
        manager.enter(new PongState(manager, gui));
    }
    
    /**
     * Shows the highscores
     */
    protected void showHighscores() {
        manager.enter(new HighscoresState(manager, gui));
    }
    
    /**
     * Quits the game
     */
    protected void quit() {
        manager.exit();
    }
}
