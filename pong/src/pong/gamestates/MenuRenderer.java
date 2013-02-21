package pong.gamestates;

import java.awt.Color;
import java.awt.Graphics2D;
import pong.framework.GraphicsUtilities;
import pong.framework.Renderer;
import pong.swing.CanvasPanel;

/**
 * The renderer for the Menu game state
 * @author veepee
 */
public class MenuRenderer extends Renderer {
    
    /**
     * Enum holding all the menu items
     */
    enum MenuItems {
        NEW_GAME("New Game"), HIGHSCORES("Highscores"), QUIT("Exit Game");
        
        private String text;
        
        private MenuItems(String text) {
            this.text = text;
        }
        
        public String getText() {
            return text;
        }
    }
    
    /**
     * The Menu game state this renderer belongs to
     */
    private MenuState menuState;

    /**
     * Creates a new renderer for the Menu game state
     * @param menuState The Menu game state this renderer belongs to
     * @param canvas The CanvasPanel this renderer will draw to
     */
    public MenuRenderer(MenuState menuState, CanvasPanel canvas) {
        super(canvas);
        
        this.menuState = menuState;
    }
    
    @Override
    public void onRender(Graphics2D g) {
        GraphicsUtilities.setDefaultFont(g);
        for(int i = 0; i < MenuItems.values().length; i++) {
            if(menuState.getUserSelection() == i) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.WHITE);
            }
            GraphicsUtilities.printCenteredString(g,
                    MenuItems.values()[i].getText(), 315, 140 + (i*35));
        }
    }
    
}
