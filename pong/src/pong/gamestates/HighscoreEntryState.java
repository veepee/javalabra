package pong.gamestates;

import pong.framework.GameState;
import pong.framework.GameStateManager;
import pong.highscores.HighscoresDAO;
import pong.swing.GUI;

/**
 * The HighscoreEntry game state for handling the entering of a new high score
 * @author veepee
 */
public class HighscoreEntryState implements GameState {
    
    /**
     * The GameStateManager of this game instance
     */
    private GUI gui;
    /**
     * The GUI of this game instance
     */
    private GameStateManager manager;
    
    /**
     * The renderer of this game state
     */
    private HighscoreEntryRenderer renderer;
    /**
     * The input handler of this game state
     */
    private HighscoreEntryInputHandler inputHandler;
    
    /**
     * The PongState calling this game state
     */
    private PongState pongState;
    /**
     * The HighscoresDAO object for submitting a new highscore entry
     */
    private HighscoresDAO highscores;
    
    /**
     * The user input (player name)
     */
    private String userInput;
    
    /**
     * Creates a new HighscoreEntry game state
     * @param manager The GameStateManager of this game instance
     * @param gui The GUI of this game instance
     * @param pongState The PongState calling this game state
     */
    public HighscoreEntryState(GameStateManager manager, GUI gui, PongState pongState) {
        this.manager = manager;
        this.gui = gui;
        
        this.pongState = pongState;
        
        userInput = "";
        highscores = new HighscoresDAO("highscores.dat");
    }

    @Override
    public void onEnter() {
        inputHandler = new HighscoreEntryInputHandler(this);
        renderer = new HighscoreEntryRenderer(this, gui.getCanvasPanel());
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
     * Returns the PongState game state
     * @return The PongState game state
     */
    protected PongState getPongState() {
        return pongState;
    }
    
    /**
     * Returns the user input entered so far
     * @return The user input entered so far
     */
    protected String getUserInput() {
        return userInput;
    }
    
    /**
     * Sets the user input
     * @param userInput The string user input will be set to
     */
    protected void setUserInput(String userInput) {
        this.userInput = userInput;
    }
    
    /**
     * Submits the highscore entry
     */
    protected void submit() {
        highscores.insertHighscore(userInput, pongState.getGame().getPlayerScore());
        highscores.saveHighscores();
        manager.exit();
    }
    
}