package com.raven.swing;

import com.raven.model.StatusType;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Table1 extends JTable{
    
    public Table1() {
        //setShowHorizontalLines(false);
        //setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                
                header.setForeground(Color.WHITE);
                header.setBackground(new Color(69,76,82));
                header.setHorizontalAlignment(JLabel.CENTER);
                //header.setBorder(noFocusBorder);
                //header.setH
                
                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
                
                    Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
                    com.setBackground(new Color(56,63,69));
                    setBorder(noFocusBorder);
                    setHorizontalTextPosition(CENTER);
                    //setV
                    if (selected) {
                        com.setForeground(Color.YELLOW);
                    } else {
                        com.setForeground(Color.WHITE);
                    }
                    return com;
                
            }
        });
    }
    /*
    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }
    */
}
