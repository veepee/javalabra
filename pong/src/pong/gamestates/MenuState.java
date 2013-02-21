package pong.gamestates;

import pong.framework.GameState;
import pong.framework.GameStateManager;
import pong.swing.GUI;

public class MenuState implements GameState {


    private GUI gui;
    private GameStateManager manager;
    
    private MenuRenderer renderer;
    private MenuInputHandler inputHandler;
    
    private int userSelection;
    
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
    
    protected int getUserSelection() {
        return userSelection;
    }

    protected void setUserSelection(int userSelection) {
        this.userSelection = userSelection;
    }
    
    protected void startNewGame() {
        manager.enter(new PongState(manager, gui));
    }
    
    protected void showHighscores() {
        manager.enter(new HighscoresState(manager, gui));
    }
    
    protected void quit() {
        manager.exit();
    }
}
