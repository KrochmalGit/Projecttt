package p02.pres;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SevenSegmentDigit extends JPanel {
    private int value;
    private List<SevenSegmentDigit> listeners;

    public SevenSegmentDigit() {
        value = 0;
        listeners = new ArrayList<>();
        setPreferredSize(new Dimension(50, 80)); // Adjust the size of the digit display
    }

    public void addListener(SevenSegmentDigit listener) {
        listeners.add(listener);
    }

    public void increment() {
        value++;
        if (value > 9) {
            value = 0;
            for (SevenSegmentDigit listener : listeners) {
                listener.increment();
            }
        }
        repaint();
    }

    public void reset() {
        value = 0;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(10, 10, 30, 10); // Top segment
        g.fillRect(40, 20, 10, 30); // Right-top segment
        g.fillRect(40, 50, 10, 30); // Right-bottom segment
        g.fillRect(10, 70, 30, 10); // Bottom segment
        g.fillRect(0, 50, 10, 30);  // Left-bottom segment
        g.fillRect(0, 20, 10, 30);  // Left-top segment
        g.fillRect(10, 40, 30, 10); // Middle segment

        g.setColor(Color.BLACK);
        if (value != 8) {
            if (value == 0 || value == 1 || value == 7) g.fillRect(10, 40, 30, 10);
            if (value == 0 || value == 4 || value == 7 || value == 9) g.fillRect(10, 70, 30, 10);
            if (value == 0 || value == 4 || value == 5 || value == 6 || value == 8 || value == 9) g.fillRect(0, 50, 10, 30);
            if (value == 0 || value == 2 || value == 3 || value == 5 || value == 6 || value == 8 || value == 9) g.fillRect(0, 20, 10, 30);
            if (value == 0 || value == 2 || value == 3 || value == 5 || value == 6 || value == 7 || value == 8 || value == 9) g.fillRect(40, 50, 10, 30);
            if (value == 0 || value == 1 || value == 2 || value == 3 || value == 4 || value == 7 || value == 8 || value == 9) g.fillRect(40, 20, 10, 30);
        }
    }
}
