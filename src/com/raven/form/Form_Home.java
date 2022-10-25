package com.raven.form;

import com.raven.model.Model_Card;
import com.raven.model.StatusType;
import com.raven.swing.ScrollBar;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Form_Home extends javax.swing.JPanel {

    public Form_Home() {
        initComponents();
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "No. of Books", "10", ""));
            // (new Model_Card(Icon, Title, Values,Description)
            // (new Model_Card(Icon, Title, SQL Total,Description)
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/8.png")), "No. of Students", "5", "Student members"));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/flag.png")), "Issued Books", "27", "Borrowed books"));
        card4.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/flag.png")), "Defaulters", "5", "Still not returning books"));
        
        //  add row table
        setBookDetailsToTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new com.raven.component.Card();
        card2 = new com.raven.component.Card();
        card3 = new com.raven.component.Card();
        card4 = new com.raven.component.Card();
        spTable = new javax.swing.JScrollPane();
        table = new com.raven.swing.Table1();

        setBackground(new java.awt.Color(69, 76, 82));

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(56, 63, 69));
        card1.setColor2(new java.awt.Color(36, 41, 46));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(56, 63, 69));
        card2.setColor2(new java.awt.Color(36, 41, 46));
        panel.add(card2);

        card3.setColor1(new java.awt.Color(56, 63, 69));
        card3.setColor2(new java.awt.Color(36, 41, 46));
        panel.add(card3);

        card4.setColor1(new java.awt.Color(56, 63, 69));
        card4.setColor2(new java.awt.Color(36, 41, 46));
        panel.add(card4);

        spTable.setBorder(null);

        table.setBackground(new java.awt.Color(56, 63, 69));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Title", "Author", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        spTable.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spTable)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    String bookName, author;
    int bookId, quantity, price;
    DefaultTableModel model;
    
    public void setBookDetailsToTable() {
        
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_library_system", "root", "@Lacorte2001");
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM book_details");
         
           while(rs.next()) {
               String bookId = rs.getString("book_id");
               String bookName = rs.getString("book_name");
               String author = rs.getString("author");
               String quantity = rs.getString("quantity");
               String price = rs.getString("price");
               
               Object[] obj = {bookId, bookName, author, quantity, price};
               model = (DefaultTableModel) table.getModel();
               model.addRow(obj);
           }
         
         } catch (Exception e) {
             e.printStackTrace();    
         }
    }
    
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int rowNo = table.getSelectedRow();
        TableModel model = table.getModel();

//        jTextField1.setText(model.getValueAt(rowNo, 0).toString());
//        jTextField2.setText(model.getValueAt(rowNo, 1).toString());
//        jTextField3.setText(model.getValueAt(rowNo, 2).toString());
//        jTextField4.setText(model.getValueAt(rowNo, 3).toString());
//        jTextField5.setText(model.getValueAt(rowNo, 4).toString());
    }//GEN-LAST:event_tableMouseClicked

    /*
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //GradientPaint g = new GradientPaint(0, 0, Color.decode("#24292e"), 0, getHeight(), Color.decode("#24292e"));
        //g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        //g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs); 
    }
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Card card1;
    private com.raven.component.Card card2;
    private com.raven.component.Card card3;
    private com.raven.component.Card card4;
    private javax.swing.JLayeredPane panel;
    private javax.swing.JScrollPane spTable;
    private com.raven.swing.Table1 table;
    // End of variables declaration//GEN-END:variables
}
