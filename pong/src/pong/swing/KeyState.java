package pong.swing;

import java.util.Arrays;

/**
 * The KeyState class for representing the keyboard state
 * @author veepee
 */
public class KeyState {
    
    /**
     * Boolean array for storing the key states
     */
    private boolean[] keys;

    /**
     * Creates a new KeyState with none of the keys set
     */
    public KeyState() {
        keys = new boolean[256];
    }
    
    /**
     * The copy constructor for KeyState
     * @param toClone The KeyState instance to clone 
     */
    public KeyState(KeyState toClone) {
        keys = Arrays.copyOf(toClone.keys, toClone.keys.length);
    }
    
    /**
     * Sets the key state down
     * @param code Java AWT KeyEvent key code
     */
    public void setKeyPressed(int code) {
        keys[code] = true;
    }
    
    /**
     * Sets the key state up
     * @param code Java AWT KeyEvent key code
     */
    public void setKeyReleased(int code) {
        keys[code] = false;
    }
    
    /**
     * Returns if the specified key is currently pressed
     * @param code Java AWT KeyEvent key code
     * @return Returns true if the key is down, false otherwise
     */
    public boolean isDown(int code) {
        if(code < 0 || code > 255) {
            return false;
        }
        return keys[code];
    }
}