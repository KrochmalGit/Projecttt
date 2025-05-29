package p02.game;

import p02.game.events.GameEventListener;
import p02.game.events.TickEvent;
import p02.game.events.ResetEvent;
import p02.game.events.PlusOneEvent;
import p02.pres.SevenSegmentDigit;

import java.util.ArrayList;
import java.util.List;

public class GameThread extends Thread {
    private static GameThread instance;
    private boolean running;
    private long interval;
    private List<GameEventListener> listeners;

    private GameThread() {
        running = false;
        interval = 1000; // Initial delay between game ticks
        listeners = new ArrayList<>();
    }

    public static GameThread getInstance() {
        if (instance == null) {
            instance = new GameThread();
        }
        return instance;
    }

    public void addListener(GameEventListener listener) {
        listeners.add(listener);
    }

    public void startGame() {
        if (!running) {
            running = true;
            this.start();
        }
    }

    public void stopGame() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(interval);
                notifyListeners(new TickEvent(this));

                if (shouldIncreaseDifficulty()) {
                    interval = Math.max(500, interval - 10); // Gradually speeds up the game
                }
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }

    private boolean shouldIncreaseDifficulty() {
        return listeners.stream().anyMatch(listener -> listener instanceof SevenSegmentDigit);
    }

    private void notifyListeners(Object event) {
        for (GameEventListener listener : listeners) {
            if (event instanceof TickEvent) listener.onTickEvent();
            else if (event instanceof ResetEvent) listener.onResetEvent();
            else if (event instanceof PlusOneEvent) listener.onPlusOneEvent();
        }
    }
}
