package p02.pres;

import p02.game.Board;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Image playerImage;
    private Image unitImage;
    private Image backgroundImage;
    private int panelWidth;
    private int panelHeight;
    private Board board;

    public GamePanel(Board board, int panelWidth, int panelHeight) {
        this.board = board;
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
        playerImage = new ImageIcon("assets/player.png").getImage();
        unitImage = new ImageIcon("assets/Unit.png").getImage();
        backgroundImage = new ImageIcon("assets/background.png").getImage();

        if (unitImage == null) {
            System.out.println("Nie można załadować assets/Unit.png!");
        }
        if (backgroundImage == null) {
            System.out.println("Nie można załadować assets/background.png!");
        }

        setPreferredSize(new Dimension(panelWidth, panelHeight));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        // Najpierw rysuj background.png na środku panelu
        int bgW = width / 2;
        int bgH = height / 2;
        int bgX = (width - bgW) / 2;
        int bgY = (height - bgH) / 2;
        g.drawImage(backgroundImage, bgX, bgY, bgW, bgH, this);

        // Następnie rysuj Unit.png na cały panel
        g.drawImage(unitImage, 0, 0, width, height, this);

        // Gracz (opcjonalnie)
        if (board != null && board.isGameStarted()) {
            int playerW = 40;
            int playerH = 40;
            int playerX = (width - playerW) / 2;
            int playerY = (height - playerH) / 2;
            g.drawImage(playerImage, playerX, playerY, playerW, playerH, this);
        }
    }
}