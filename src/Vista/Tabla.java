/*
*@autor edyson
*/
package Vista;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

public class Tabla extends javax.swing.JFrame {

    public Tabla() {
        initComponents();
        mostrar();
        setSize(700, 350);
    }

    FormVista vista = new FormVista();
    private HashMap<String, String> listaLugares = new HashMap();

    public void setObj(FormVista obj) {
        this.vista = obj;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        panelBotones = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        panelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBusquedad = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblTitulo, java.awt.BorderLayout.PAGE_START);

        panelBotones.setLayout(new java.awt.GridLayout(1, 2));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        panelBotones.add(btnVolver);

        getContentPane().add(panelBotones, java.awt.BorderLayout.PAGE_END);

        panelTabla.setLayout(new java.awt.GridLayout(1, 1));

        tablaBusquedad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Direccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaBusquedad);

        panelTabla.add(jScrollPane1);

        getContentPane().add(panelTabla, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        vista.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    public void mostrar() {
        lblTitulo.setText("Busquedas de " + vista.titulo());
        DefaultTableModel modelo = (DefaultTableModel) tablaBusquedad.getModel();
        Object[] fila = new Object[modelo.getColumnCount()];
        listaLugares = vista.lista();
        Iterator it = listaLugares.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            fila[0] = e.getKey();
            fila[1] = e.getValue();
            modelo.addRow(fila);
        }
    }

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
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTable tablaBusquedad;
    // End of variables declaration//GEN-END:variables
}
