package pong.gamestates;

import java.awt.Color;
import java.awt.Graphics2D;
import pong.framework.GraphicsUtilities;
import pong.framework.Renderer;
import pong.logic.Game;
import pong.swing.CanvasPanel;

/**
 * The renderer for the Pong game state
 * @author veepee
 */
public class PongRenderer extends Renderer {

    /**
     * The Pong game state this renderer belongs to
     */
    private PongState pongState;
    /**
     * The Game instance this renderer is attached onto
     */
    private Game game;
    
    /**
     * Creates a new renderer for the Pong game state
     * @param pongState The Pong game state this renderer belongs to
     * @param game The Game instance this renderer is attached onto
     * @param canvas The CanvasPanel this renderer will draw to
     */
    public PongRenderer(PongState pongState, Game game, CanvasPanel canvas) {
        super(canvas);
        
        this.pongState = pongState;
        this.game = game;
    }
    
    @Override
    public void onRender(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.drawRect(30, 60, 570, 360);
        
        g.setColor(Color.WHITE);
        g.fillRect((int)game.getAIPaddle().getX(), (int)game.getAIPaddle().getY(), 16, 64);
        g.fillRect((int)game.getPlayerPaddle().getX(), (int)game.getPlayerPaddle().getY(), 16, 64);
        
        g.setColor(Color.RED);
        g.fillRect((int)game.getBall().getX(), (int)game.getBall().getY(), 16, 16);
        
        GraphicsUtilities.setDefaultFont(g);
        g.setColor(Color.WHITE);
        GraphicsUtilities.printCenteredString(g, "YOUR SCORE", 90, 25);
        GraphicsUtilities.printCenteredString(g, game.getPlayerScore() + "", 90, 45);
        GraphicsUtilities.printCenteredString(g, "LIVES LEFT", 315, 25);
        GraphicsUtilities.printCenteredString(g, game.getPlayerLives() + "", 315, 45);
        GraphicsUtilities.printCenteredString(g, "HIGH SCORE", 550, 25);
        GraphicsUtilities.printCenteredString(g, game.getHighScore() + "", 550, 45);
    }
    
}
