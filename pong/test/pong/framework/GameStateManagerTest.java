package pong.framework;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameStateManagerTest {
    
    class FakeGameState implements GameState {
        
        private GameStateManager man;
        
        int onEnterCalled = 0;
        int onExitCalled = 0;
        int updateCalled = 0;
        
        public FakeGameState(GameStateManager man) {
            this.man = man;
        }

        @Override
        public void onEnter() {
            onEnterCalled++;
            man.exit();
        }

        @Override
        public void onExit() {
            onExitCalled++;
        }

        @Override
        public void update(long delta) {
            updateCalled++;
        }
    }
    
    @Test
    public void testGameStateManager_OnEnter_CallsOnEnterOnce() {
        GameStateManager manager = new GameStateManager();
        FakeGameState fake = new FakeGameState(manager);
        manager.enter(fake);
        assertEquals(1, fake.onEnterCalled);
    }

    @Test
    public void testGameStateManager_OnEnter_DoesNotCallUpdate() {
        GameStateManager manager = new GameStateManager();
        FakeGameState fake = new FakeGameState(manager);
        manager.enter(fake);
        assertEquals(0, fake.updateCalled);
    }
    
    @Test
    public void testGameStateManager_OnExit_CallsOnce() {
        GameStateManager manager = new GameStateManager();
        FakeGameState fake = new FakeGameState(manager);
        manager.enter(fake);
        manager.exit();
        assertEquals(1, fake.onExitCalled);
    }
    
}