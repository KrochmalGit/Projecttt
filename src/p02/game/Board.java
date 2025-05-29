// src/p02/game/Board.java
package p02.game;

import p02.pres.GamePanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class Board implements KeyListener {
    private static final int ROWS = 12;
    private static final int COLUMNS = 5;
    private int[][] board;
    private int playerX;
    private int playerY;
    private boolean gameStarted = false;
    private GamePanel gamePanel;

    public Board() {
        board = new int[ROWS][COLUMNS];
        initializeBoard();
        playerX = 0;
        playerY = 0;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    private void initializeBoard() {
        for (int[] row : board) {
            Arrays.fill(row, 0);
        }
        board[0][0] = 1;
    }

    public void movePlayerLeft() {
        if (playerX > 0) {
            playerX--;
            if (gamePanel != null) gamePanel.repaint();
        }
    }

    public void movePlayerRight() {
        if (playerX < ROWS - 1) {
            playerX++;
            if (gamePanel != null) gamePanel.repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_S -> {
                gameStarted = true;
                if (gamePanel != null) gamePanel.repaint();
            }
        }
        if (!gameStarted) return;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A -> movePlayerLeft();
            case KeyEvent.VK_D -> movePlayerRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public int[][] getBoard() {
        return board;
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }
}