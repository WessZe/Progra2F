package com.mycompany.examenfinal;

import javax.swing.table.DefaultTableModel;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class maquinaria extends javax.swing.JFrame {

    MongoCollection<Document> Maquinaria;
    DefaultTableModel modelMaquinaria;

    /**
     * Creates new form maquinaria
     */
    public maquinaria() {
        initComponents();
        this.Maquinaria = main.connMongo.getDB().getCollection("maquinaria");

        this.modelMaquinaria = new DefaultTableModel();
        this.modelMaquinaria.addColumn("Id");
        this.modelMaquinaria.addColumn("Marca");
        this.modelMaquinaria.addColumn("Modelo");
        this.modelMaquinaria.addColumn("Vida Util");

        this.llenarTabla();

        this.tblMaquinaria.getColumnModel().getColumn(0).setMinWidth(0);
        this.tblMaquinaria.getColumnModel().getColumn(0).setMaxWidth(0);

    }

    private void llenarTabla() {
        this.tblMaquinaria.setModel(this.modelMaquinaria);

        MongoCursor<Document> cursor = main.connMongo.getDocuments(this.Maquinaria).iterator();
        while (cursor.hasNext()) {
            Document documento = cursor.next();
            System.out.println(documento);
            this.agregarRegistrosTabla(documento);
        }
    }

    private void agregarRegistrosTabla(Document fila) {
        String id = fila.get("_id").toString();
        String marca = fila.get("marca").toString();
        String modelo = fila.get("modelo").toString();
        String vidaUtil = fila.get("vidaUtil").toString();
        this.modelMaquinaria.addRow(new Object[]{id, marca, modelo, vidaUtil});
    }

    public void insertarDatos() {
        Document datosObj = new Document("_id", new ObjectId())
                .append("marca", txtMarca.getText())
                .append("modelo", txtModelo.getText())
                .append("vidaUtil", Integer.parseInt(txtVidaU.getText()));

        if (main.connMongo.insertDocument(this.Maquinaria, datosObj)) {
            this.limpiarForm();
            this.agregarRegistrosTabla(datosObj);
        }
    }

    public void limpiarForm() {
        txtMarca.setText("");
        txtModelo.setText("");
        txtVidaU.setText("");
        txtMarca.requestFocus();
    }

    public boolean deleteTableMaquinas() {
        int posicion = this.tblMaquinaria.getSelectedRow();
        if (posicion >= 0) {
            String id = this.modelMaquinaria.getValueAt(posicion, 0).toString();
            this.modelMaquinaria.removeRow(posicion);
            main.connMongo.deleteDocuments(this.Maquinaria, id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtVidaU = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMaquinaria = new javax.swing.JTable();
        btnInsertar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Examen Final Progra2");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 375, -1));

        jLabel2.setText("Marca:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 61, -1, -1));

        jLabel3.setText("Modelo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 102, -1, -1));

        jLabel4.setText("VidaUtil:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 143, -1, -1));
        getContentPane().add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 58, 123, -1));
        getContentPane().add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 99, 123, -1));
        getContentPane().add(txtVidaU, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 140, 122, -1));

        tblMaquinaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblMaquinaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMaquinariaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMaquinaria);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 169, 375, 202));

        btnInsertar.setText("Insertar");
        btnInsertar.setActionCommand("");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 57, 100, -1));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 98, 100, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 139, 100, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("A??os");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 144, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        // TODO add your handling code here:
        this.insertarDatos();

    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showOptionDialog(new JFrame(), "Esta seguro que desea actualizar el registro seleccionado?",
                "Confirmacion de actualizacion",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"Si", "No"}, JOptionPane.YES_OPTION);

        int posicion = this.tblMaquinaria.getSelectedRow();
        if (posicion >= 0 && res == JOptionPane.YES_OPTION) {
            int nCol = this.modelMaquinaria.getColumnCount();
            String[] dataTabla = new String[nCol];
            for (int i = 0; i < nCol; i++) {
                dataTabla[i] = this.modelMaquinaria.getValueAt(posicion, i).toString();
            }

            Document datosObj = new Document("marca", this.txtMarca.getText())
                    .append("modelo", this.txtModelo.getText())
                    .append("vidaUtil", Integer.parseInt(this.txtVidaU.getText()));

            JOptionPane.showMessageDialog(null, main.connMongo.actualizarDocuments(this.Maquinaria, datosObj, dataTabla[0]) ? "Registro Actualizado con exito" : "Registro no pudo ser actualizado");

            this.modelMaquinaria.setValueAt(this.txtMarca.getText(), posicion, 1);
            this.modelMaquinaria.setValueAt(this.txtModelo.getText(), posicion, 2);
            this.modelMaquinaria.setValueAt(this.txtVidaU.getText(), posicion, 3);
            this.limpiarForm();
            this.tblMaquinaria.clearSelection();

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        }


    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showOptionDialog(new JFrame(), "Esta seguro que desea eliminar el registro seleccionado?",
                "Confirmacion de eliminacion",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"Si", "No"}, JOptionPane.YES_OPTION);

        JOptionPane.showMessageDialog(null, (res == JOptionPane.YES_OPTION && this.deleteTableMaquinas()) ? "Registro eliminado con exito!" : "Registro no pudo ser eliminado!");


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblMaquinariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMaquinariaMouseClicked
        // TODO add your handling code here:
        int posicion = this.tblMaquinaria.getSelectedRow();
        if (posicion >= 0) {
            int nCol = this.modelMaquinaria.getColumnCount();
            String[] dataTabla = new String[nCol];
            for (int i = 0; i < nCol; i++) {
                dataTabla[i] = this.modelMaquinaria.getValueAt(posicion, i).toString();
            }

            this.txtMarca.setText(dataTabla[1]);
            this.txtModelo.setText(dataTabla[2]);
            this.txtVidaU.setText(dataTabla[3]);

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione otro registro de la tabla");
        }


    }//GEN-LAST:event_tblMaquinariaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(maquinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(maquinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(maquinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(maquinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new maquinaria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMaquinaria;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtVidaU;
    // End of variables declaration//GEN-END:variables

   
}
