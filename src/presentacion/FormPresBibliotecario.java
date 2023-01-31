/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import datos.*;
import entidades.*;
import logica.*;
import javax.swing.*;

/**
 *
 * @author Salvattore
 */
public class FormPresBibliotecario extends javax.swing.JFrame {

    /**
     * Creates new form FormPresBibliotecario
     */
    public FormPresBibliotecario() {
        initComponents();
    }

    public FormPresBibliotecario(Biblioteca biblioteca, JFrame panel, int pos) {
        initComponents();
        this.biblioteca = biblioteca;
        this.pos = pos;
        setLocationRelativeTo(panel);
        llenarCampos(pos);
    }

    public void llenarCampos(int pos) {
        Bibliotecario bibliotecario = biblioteca.getListaBibliotecarios().getBibliotecario(pos);
        txtNombreB.setText(bibliotecario.getNombres());
        txtApellidoB.setText(bibliotecario.getApellidos());
        txtDniB.setText(bibliotecario.getDni());
        txtTelefonoB.setText(bibliotecario.getTelefono());
        txtCodigoB.setText(bibliotecario.getCodigo());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jplGerente2 = new javax.swing.JPanel();
        lblNombreG6 = new javax.swing.JLabel();
        txtNombreB = new javax.swing.JTextField();
        lblProfesion2 = new javax.swing.JLabel();
        txtCodigoB = new javax.swing.JTextField();
        lblNombreG7 = new javax.swing.JLabel();
        txtApellidoB = new javax.swing.JTextField();
        lblNombreG8 = new javax.swing.JLabel();
        txtDniB = new javax.swing.JTextField();
        txtTelefonoB = new javax.swing.JTextField();
        lblNombreG9 = new javax.swing.JLabel();
        btnRegistrarLibro = new javax.swing.JButton();
        btnRegistrarPrestatario = new javax.swing.JButton();
        btnMostrarLibros = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnPrestar = new javax.swing.JButton();
        btnMostrarPrestatarios = new javax.swing.JButton();
        btnMostrarBiblioteca = new javax.swing.JButton();
        btnMostrarLibrosPrestados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bibliotecario");

        jplGerente2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del bibliotecario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jplGerente2.setEnabled(false);

        lblNombreG6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblNombreG6.setText("Nombres:");

        txtNombreB.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNombreB.setEnabled(false);

        lblProfesion2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblProfesion2.setText("Código:");

        txtCodigoB.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtCodigoB.setEnabled(false);

        lblNombreG7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblNombreG7.setText("Apellidos:");

        txtApellidoB.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtApellidoB.setEnabled(false);
        txtApellidoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoBActionPerformed(evt);
            }
        });

        lblNombreG8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblNombreG8.setText("DNI:");

        txtDniB.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtDniB.setEnabled(false);

        txtTelefonoB.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtTelefonoB.setEnabled(false);

        lblNombreG9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblNombreG9.setText("Teléfono:");

        javax.swing.GroupLayout jplGerente2Layout = new javax.swing.GroupLayout(jplGerente2);
        jplGerente2.setLayout(jplGerente2Layout);
        jplGerente2Layout.setHorizontalGroup(
            jplGerente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplGerente2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jplGerente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplGerente2Layout.createSequentialGroup()
                        .addComponent(lblNombreG6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNombreB, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jplGerente2Layout.createSequentialGroup()
                        .addGroup(jplGerente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreG7)
                            .addComponent(lblNombreG8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jplGerente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jplGerente2Layout.createSequentialGroup()
                                .addComponent(txtDniB, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(lblNombreG9)
                                .addGap(24, 24, 24)
                                .addComponent(txtTelefonoB, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jplGerente2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtApellidoB, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jplGerente2Layout.createSequentialGroup()
                        .addComponent(lblProfesion2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoB, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)))
                .addContainerGap())
        );
        jplGerente2Layout.setVerticalGroup(
            jplGerente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplGerente2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jplGerente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreG6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jplGerente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreG7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jplGerente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreG8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreG9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDniB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jplGerente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProfesion2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnRegistrarLibro.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnRegistrarLibro.setText("Registrar libro");
        btnRegistrarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarLibroActionPerformed(evt);
            }
        });

        btnRegistrarPrestatario.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnRegistrarPrestatario.setText("Registrar prestatario");
        btnRegistrarPrestatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPrestatarioActionPerformed(evt);
            }
        });

        btnMostrarLibros.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnMostrarLibros.setText("Mostrar libros");
        btnMostrarLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarLibrosActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnVolver.setMnemonic('R');
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnPrestar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnPrestar.setText("Prestar/devolver un libro");
        btnPrestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestarActionPerformed(evt);
            }
        });

        btnMostrarPrestatarios.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnMostrarPrestatarios.setText("Mostrar prestatarios");
        btnMostrarPrestatarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarPrestatariosActionPerformed(evt);
            }
        });

        btnMostrarBiblioteca.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnMostrarBiblioteca.setText("Mostrar biblioteca");
        btnMostrarBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarBibliotecaActionPerformed(evt);
            }
        });

        btnMostrarLibrosPrestados.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnMostrarLibrosPrestados.setText("Mostrar libros prestados");
        btnMostrarLibrosPrestados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarLibrosPrestadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMostrarLibros)
                    .addComponent(btnRegistrarLibro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarPrestatario)
                    .addComponent(btnMostrarPrestatarios))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMostrarLibrosPrestados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrestar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(btnMostrarBiblioteca)
                        .addGap(97, 97, 97)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jplGerente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jplGerente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarPrestatario)
                    .addComponent(btnPrestar)
                    .addComponent(btnRegistrarLibro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrarLibros)
                    .addComponent(btnMostrarLibrosPrestados)
                    .addComponent(btnMostrarPrestatarios))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrarBiblioteca)
                    .addComponent(btnVolver))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoBActionPerformed

    private void btnRegistrarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarLibroActionPerformed
        new FormRegistrarLibro(biblioteca, this, pos).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarLibroActionPerformed

    private void btnRegistrarPrestatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPrestatarioActionPerformed
        new FormRegistrarPrestatario(biblioteca, this, pos).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarPrestatarioActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        new FormIngreso(biblioteca).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnPrestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestarActionPerformed
        new FormPrestarLibro(biblioteca, this, pos).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPrestarActionPerformed

    private void btnMostrarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarLibrosActionPerformed
        new FormMostrarLibros(biblioteca, this, pos).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMostrarLibrosActionPerformed

    private void btnMostrarPrestatariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarPrestatariosActionPerformed
        new FormMostrarPrestatarios(biblioteca, this, pos).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMostrarPrestatariosActionPerformed

    private void btnMostrarBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarBibliotecaActionPerformed
        new FormInfoBiblioteca(biblioteca, this, pos).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMostrarBibliotecaActionPerformed

    private void btnMostrarLibrosPrestadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarLibrosPrestadosActionPerformed
        new FormMostrarLibrosPrestados(biblioteca, this, pos).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMostrarLibrosPrestadosActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FormPresBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormPresBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormPresBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormPresBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormPresBibliotecario().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrarBiblioteca;
    private javax.swing.JButton btnMostrarLibros;
    private javax.swing.JButton btnMostrarLibrosPrestados;
    private javax.swing.JButton btnMostrarPrestatarios;
    private javax.swing.JButton btnPrestar;
    private javax.swing.JButton btnRegistrarLibro;
    private javax.swing.JButton btnRegistrarPrestatario;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jplGerente2;
    private javax.swing.JLabel lblNombreG6;
    private javax.swing.JLabel lblNombreG7;
    private javax.swing.JLabel lblNombreG8;
    private javax.swing.JLabel lblNombreG9;
    private javax.swing.JLabel lblProfesion2;
    private javax.swing.JTextField txtApellidoB;
    private javax.swing.JTextField txtCodigoB;
    private javax.swing.JTextField txtDniB;
    private javax.swing.JTextField txtNombreB;
    private javax.swing.JTextField txtTelefonoB;
    // End of variables declaration//GEN-END:variables
    private Biblioteca biblioteca;
    private int pos;
}
