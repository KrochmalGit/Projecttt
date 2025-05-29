package p02.game;

import p02.game.events.PlusOneEvent;
import p02.game.events.ResetEvent;
import p02.game.events.StartEvent;
import p02.pres.SevenSegmentDigit;

import java.util.ArrayList;
import java.util.List;

public class ScoreManager {
    private List<SevenSegmentDigit> digits;

    public ScoreManager() {
        digits = new ArrayList<>();
    }

    public void addDigit(SevenSegmentDigit digit) {
        digits.add(digit);
    }

    public void resetScore() {
        for (SevenSegmentDigit digit : digits) {
            digit.reset();
        }
    }

    public void incrementScore() {
        if (!digits.isEmpty()) {
            digits.get(0).increment(); // Start incrementing from the units digit
        }
    }

    public void handleEvent(Object event) {
        if (event instanceof ResetEvent) {
            resetScore();
        } else if (event instanceof PlusOneEvent) {
            incrementScore();
        } else if (event instanceof StartEvent) {
            resetScore();
        }
    }
}
