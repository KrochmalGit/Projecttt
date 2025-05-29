package p02.pres;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class BoardCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int col) {
        JLabel cell = new JLabel();
        cell.setOpaque(true);

        if (value instanceof Integer) {
            int intValue = (Integer) value;
            cell.setBackground(intValue == 0 ? Color.BLACK : Color.WHITE);
        }

        return cell;
    }
}
