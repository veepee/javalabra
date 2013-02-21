package pong.gamestates;

import pong.framework.GameState;
import pong.framework.GameStateManager;
import pong.swing.GUI;

public class IngameMenuState implements GameState {

    private GUI gui;
    private GameStateManager manager;
    
    private IngameMenuRenderer renderer;
    private IngameMenuInputHandler inputHandler;
    
    private int userSelection;
    private PongState pongState;
    
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
    
    protected int getUserSelection() {
        return userSelection;
    }

    protected void setUserSelection(int userSelection) {
        this.userSelection = userSelection;
    }
    
    protected PongState getPongState() {
        return pongState;
    }
    
    protected void resume() {
        manager.exit();
    }
    
    protected void exit() {
        pongState.exit();
        manager.exit();
    }

}