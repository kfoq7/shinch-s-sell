package views;

import controllers.InventarioConrtoller;
import controllers.ProductController;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import models.Inventory;
import models.Product;

public class InventoryPanel extends javax.swing.JPanel {

    DefaultTableModel tableModel;

    ArrayList<Product> products;

    String[] header = {"id", "nombre", "stock", "proveedor"};

//    InventarioConrtoller controller;
    ProductController controller;

    public InventoryPanel() throws Exception {
        initComponents();

        controller = new ProductController();

        products = controller.getProducts();

        tableModel = new DefaultTableModel(header, 0);
        tableInventory.setModel(tableModel);
        updateTable();

        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filter();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableInventory = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        LabelOutput = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(950, 590));

        jPanel1.setPreferredSize(new java.awt.Dimension(950, 590));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableInventory);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 930, 420));

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 48)); // NOI18N
        jLabel1.setText("INVENTARIO");
        jLabel1.setPreferredSize(new java.awt.Dimension(550, 86));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 370, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/consultar.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, -1, -1));

        txtSearch.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 240, 50));

        LabelOutput.setText("jLabel3");
        jPanel1.add(LabelOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelOutput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableInventory;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void updateTable() {
        for (Product product : products) {
            Object[] row = {product.getId(), product.getName(), product.getStock(), product.getSupplierId()};
//            tableModel.addRow(row);
        }
    }

    private void updateTable(ArrayList<Product> productList) {
        for (Product product : productList) {
            Object[] row = {product.getId(), product.getName(), product.getStock(), product.getSupplierId()};
            tableModel.addRow(row);
        }
    }

    private void filter() {
        String text = txtSearch.getText();
        ArrayList<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredProducts.add(product);
            }
        }

        tableModel.setRowCount(0);
        updateTable(filteredProducts);
    }

}
