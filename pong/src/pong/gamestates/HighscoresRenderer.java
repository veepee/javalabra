package pong.gamestates;

import java.awt.Color;
import java.awt.Graphics2D;
import pong.framework.GraphicsUtilities;
import pong.framework.Renderer;
import pong.highscores.Highscore;
import pong.swing.CanvasPanel;

/**
 * The renderer for the Highscores game state
 * @author veepee
 */
public class HighscoresRenderer extends Renderer {

    /**
     * The Highscores game state this renderer belongs to
     */
    private HighscoresState highscoresState;
    
    /**
     * Creates a new renderer for the Highscores game state
     * @param highscoreEntryState The Highscores game state this input handler belongs to
     * @param canvas The CanvasPanel this renderer will draw to
     */
    public HighscoresRenderer(HighscoresState highscoresState,CanvasPanel canvas) {
        super(canvas);
        
        this.highscoresState = highscoresState;
    }
     
    @Override
    public void onRender(Graphics2D g) {
        GraphicsUtilities.setDefaultFont(g);

        Highscore[] scores = highscoresState.getHighscores().getHighscores();

        g.setColor(Color.RED);
        GraphicsUtilities.printCenteredString(g, "Highscores - top 10", 315, 30);
        
        g.setColor(Color.WHITE);
        for(int i = 0; i < 10; i++) {
            if(!(i+1 > scores.length || scores[i] == null)) {
                GraphicsUtilities.printCenteredString(g, (i+1) + ". " + scores[i].getName() + " (" + scores[i].getPoints() + " points)", 315, 70 + (i*35));
            }
        }
        
        g.setColor(Color.RED);
        GraphicsUtilities.printCenteredString(g, "Press ESC to return", 315, 425);
    }

}