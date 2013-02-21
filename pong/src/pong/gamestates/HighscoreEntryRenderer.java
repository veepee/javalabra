package pong.gamestates;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import pong.framework.GraphicsUtilities;
import pong.framework.Renderer;
import pong.swing.CanvasPanel;

/**
 * The renderer for the HighscoreEntry game state
 * @author veepee
 */
public class HighscoreEntryRenderer extends Renderer {

    /**
     * The HighscoreEntry game state this renderer belongs to
     */
    private HighscoreEntryState highscoreEntryState;
    
    /**
     * Creates a new renderer for the HighscoreEntry game state
     * @param highscoreEntryState The HighscoreEntry game state this input handler belongs to
     * @param canvas The CanvasPanel this renderer will draw to
     */
    public HighscoreEntryRenderer(HighscoreEntryState highscoreEntryState, CanvasPanel canvas) {
        super(canvas);
        
        this.highscoreEntryState = highscoreEntryState;
    }
    
    @Override
    public void onRender(Graphics2D g) {
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.25f));
        highscoreEntryState.getPongState().getRenderer().onRender(g);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        
        GraphicsUtilities.setDefaultFont(g);
        
        g.setColor(Color.RED);
        GraphicsUtilities.printCenteredString(g, "GAME OVER", 315, 110);
        GraphicsUtilities.printCenteredString(g, "Enter your name: ", 315, 140);
        g.setColor(Color.WHITE);
        GraphicsUtilities.printCenteredString(g, highscoreEntryState.getUserInput(), 315, 200);
    }

}