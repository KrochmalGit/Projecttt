package p02;

import javax.swing.*;
import p02.game.Board;
import p02.pres.GamePanel;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Board board = new Board();
            GamePanel gamePanel = new GamePanel(board, 1200, 800); // rozmiar panelu = rozmiar okna
            board.setGamePanel(gamePanel);

            JFrame frame = new JFrame("Turtle Bridge");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setContentPane(gamePanel);
            frame.setSize(1200, 800); // stały rozmiar
            frame.setResizable(false);
            frame.addKeyListener(board);

            frame.setVisible(true);
        });
    }
}