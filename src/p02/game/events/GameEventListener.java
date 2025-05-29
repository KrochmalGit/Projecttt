package p02.game.events;

public interface GameEventListener {
    void onTickEvent();
    void onResetEvent();
    void onPlusOneEvent();
    void onStartEvent();
}
