package pong.swing;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

/**
 * The KeyEventListener class, implementing the KeyEventDispatcher interface,
 * which handles the incoming key events and encapsulates the current keyboard state
 * in an KeyState object
 * @author veepee
 */
public class KeyEventListener implements KeyEventDispatcher {

    /**
     * KeyState object for holding the current keyboard state
     */
    private KeyState keyState;
    
    /**
     * Creates a new KeyEventListener
     */
    public KeyEventListener() {
        keyState = new KeyState();
    }
    
    @Override
    public boolean dispatchKeyEvent(KeyEvent ke) {
        if(ke.getID() == KeyEvent.KEY_PRESSED) {
            keyState.setKeyPressed(ke.getKeyCode());
        } else if(ke.getID() == KeyEvent.KEY_RELEASED) {
            keyState.setKeyReleased(ke.getKeyCode());
        }
        return false;
    }

    /**
     * Returns the KeyState object representing the current keyboard state
     * @return KeyState object representing the current keyboard state
     */
    public KeyState getKeyState() {
        synchronized(keyState) {
            return new KeyState(keyState);
        }
    }
}