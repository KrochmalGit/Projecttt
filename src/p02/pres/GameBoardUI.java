package p02.pres;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GameBoardUI extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private final int ROWS = 12;
    private final int COLUMNS = 5;

    public GameBoardUI() {
        setLayout(new BorderLayout());

        model = new DefaultTableModel(ROWS, COLUMNS);
        table = new JTable(model);
        table.setEnabled(false); // Prevent user interaction

        table.setRowHeight(40); // Adjust cell height
        table.setDefaultRenderer(Object.class, new BoardCellRenderer());

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void updateBoard(int[][] boardData) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                model.setValueAt(boardData[row][col], row, col);
            }
        }
    }
}
