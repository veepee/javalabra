package pong.gamestates;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import pong.framework.GraphicsUtilities;
import pong.framework.Renderer;
import pong.swing.CanvasPanel;

/**
 * The renderer for the IngameMenu game state
 * @author veepee
 */
public class IngameMenuRenderer extends Renderer {
    
    /**
     * Enum holding all the ingame menu items
     */
    enum MenuItems {
        
        RESUME("Resume Game"), EXIT("Exit Game");
        
        private String text;
        
        private MenuItems(String text) {
            this.text = text;
        }
        
        public String getText() {
            return text;
        }
    }
    
    /**
     * The IngameMenu game state this renderer belongs to
     */
    private IngameMenuState ingameMenuState;
    
    /**
     * Creates a new renderer for the IngameMenu game state
     * @param ingameMenuState The IngameMenu game state this renderer belongs to
     * @param canvas The CanvasPanel this renderer will draw to
     */
    public IngameMenuRenderer(IngameMenuState ingameMenuState, CanvasPanel canvas) {
        super(canvas);
        
        this.ingameMenuState = ingameMenuState;
    }
    
    @Override
    public void onRender(Graphics2D g) {
        
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.25f));
        ingameMenuState.getPongState().getRenderer().onRender(g);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        
        GraphicsUtilities.setDefaultFont(g);
        
        for(int i = 0; i < IngameMenuRenderer.MenuItems.values().length; i++) {
            if(ingameMenuState.getUserSelection() == i) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.WHITE);
            }
            GraphicsUtilities.printCenteredString(g,
                    IngameMenuRenderer.MenuItems.values()[i].getText(), 315, 140 + (i*35));
        }
    }

}