/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.util.*;
import javax.swing.*;
import entidades.*;
import datos.*;
import javax.swing.table.*;
import logica.*;

/**
 *
 * @author Salvattore
 */
public class FormMostrarLibros extends javax.swing.JFrame {

    /**
     * Creates new form FormMostrarLibros
     */
    public FormMostrarLibros() {
        initComponents();
    }

    public FormMostrarLibros(Biblioteca biblioteca, JFrame panel) {
        initComponents();
        this.biblioteca = biblioteca;
        setLocationRelativeTo(panel);
    }

    public FormMostrarLibros(Biblioteca biblioteca, JFrame panel, int pos) {
        initComponents();
        this.biblioteca = biblioteca;
        setLocationRelativeTo(panel);
        this.pos = pos;
    }

    public void llenarTabla(List<LibroBiblioteca> lista) {
        modelo = new DefaultTableModel();
        LibroBiblioteca libro;
        String tipo;

        if (rbTodo.isSelected()) {
            String columnas[] = {"Tipo", "Codigo", "Título", "Autor", "Año de publicación", "Cantidad", "Género", "Editorial", "Universidad"};
            Object fila[] = new Object[columnas.length];
            modelo.setColumnIdentifiers(columnas);
            Iterator<LibroBiblioteca> iterador = lista.iterator();
            while (iterador.hasNext()) {
                libro = iterador.next();
                tipo = libro.getDocumento().getTipo();
                fila[0] = tipo;
                fila[1] = libro.getCodigo();
                fila[2] = libro.getDocumento().getTitulo();
                fila[3] = libro.getDocumento().getAutor();
                fila[4] = libro.getDocumento().getAño();
                fila[5] = libro.getCantidad();
                if (tipo.equals("Libro")) {
                    fila[6] = ((Libro) (libro.getDocumento())).getGenero();
                } else if (tipo.equals("Académico")) {
                    fila[6] = ((Academico) (libro.getDocumento())).getGenero();
                } else {
                    fila[6] = "";
                }
                if (tipo.equals("Libro")) {
                    fila[7] = ((Libro) (libro.getDocumento())).getEditorial();
                } else if (tipo.equals("Revista")) {
                    fila[7] = ((Revista) (libro.getDocumento())).getEditorial();
                } else {
                    fila[7] = "";
                }
                if (tipo.equals("Académico")) {
                    fila[8] = ((Academico) (libro.getDocumento())).getUniversidad();
                } else {
                    fila[8] = "";
                }
                modelo.addRow(fila);
            }
        }

        if (rbLibro.isSelected()) {
            String columnas[] = {"Tipo", "Codigo", "Título", "Autor", "Año de publicación", "Cantidad", "Género", "Editorial"};
            Object fila[] = new Object[columnas.length];
            modelo.setColumnIdentifiers(columnas);
            Iterator<LibroBiblioteca> iterador = lista.iterator();
            while (iterador.hasNext()) {
                libro = iterador.next();
                tipo = libro.getDocumento().getTipo();
                if (tipo.equals("Libro")) {
                    fila[0] = tipo;
                    fila[1] = libro.getCodigo();
                    fila[2] = libro.getDocumento().getTitulo();
                    fila[3] = libro.getDocumento().getAutor();
                    fila[4] = libro.getDocumento().getAño();
                    fila[5] = libro.getCantidad();
                    fila[6] = ((Libro) (libro.getDocumento())).getGenero();
                    fila[7] = ((Libro) (libro.getDocumento())).getEditorial();
                    modelo.addRow(fila);
                }
            }
        }

        if (rbRevista.isSelected()) {
            String columnas[] = {"Tipo", "Codigo", "Título", "Autor", "Año de publicación", "Cantidad", "Editorial"};
            Object fila[] = new Object[columnas.length];
            modelo.setColumnIdentifiers(columnas);
            Iterator<LibroBiblioteca> iterador = lista.iterator();
            while (iterador.hasNext()) {
                libro = iterador.next();
                tipo = libro.getDocumento().getTipo();
                if (tipo.equals("Revista")) {
                    fila[0] = tipo;
                    fila[1] = libro.getCodigo();
                    fila[2] = libro.getDocumento().getTitulo();
                    fila[3] = libro.getDocumento().getAutor();
                    fila[4] = libro.getDocumento().getAño();
                    fila[5] = libro.getCantidad();
                    fila[6] = ((Revista) (libro.getDocumento())).getEditorial();
                    modelo.addRow(fila);
                }
            }
        }

        if (rbAcademico.isSelected()) {
            String columnas[] = {"Tipo", "Codigo", "Título", "Autor", "Año de publicación", "Cantidad", "Género", "Universidad"};
            Object fila[] = new Object[columnas.length];
            modelo.setColumnIdentifiers(columnas);
            Iterator<LibroBiblioteca> iterador = lista.iterator();
            while (iterador.hasNext()) {
                libro = iterador.next();
                tipo = libro.getDocumento().getTipo();
                if (tipo.equals("Académico")) {
                    fila[0] = tipo;
                    fila[1] = libro.getCodigo();
                    fila[2] = libro.getDocumento().getTitulo();
                    fila[3] = libro.getDocumento().getAutor();
                    fila[4] = libro.getDocumento().getAño();
                    fila[5] = libro.getCantidad();
                    fila[6] = ((Academico) (libro.getDocumento())).getGenero();
                    fila[7] = ((Academico) (libro.getDocumento())).getUniversidad();
                    modelo.addRow(fila);
                }
            }
        }

        tblLibros.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        scrLibros = new javax.swing.JScrollPane();
        tblLibros = new javax.swing.JTable();
        btnMostrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rbTodo = new javax.swing.JRadioButton();
        rbAcademico = new javax.swing.JRadioButton();
        rbLibro = new javax.swing.JRadioButton();
        rbRevista = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        rbAutor = new javax.swing.JRadioButton();
        rbAño = new javax.swing.JRadioButton();
        rbTitulo = new javax.swing.JRadioButton();
        rbCodigo = new javax.swing.JRadioButton();
        rbCantidad = new javax.swing.JRadioButton();
        rbTipo = new javax.swing.JRadioButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mostrar libros");

        scrLibros.setEnabled(false);

        tblLibros.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        tblLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tipo", "Código", "Título", "Autor", "Año de publicación", "Cantidad", "Género", "Editorial", "Universidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLibros.setEnabled(false);
        scrLibros.setViewportView(tblLibros);

        btnMostrar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Mostrar"));

        buttonGroup1.add(rbTodo);
        rbTodo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rbTodo.setSelected(true);
        rbTodo.setText("Todo");

        buttonGroup1.add(rbAcademico);
        rbAcademico.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rbAcademico.setText("Academico");

        buttonGroup1.add(rbLibro);
        rbLibro.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rbLibro.setText("Libros");

        buttonGroup1.add(rbRevista);
        rbRevista.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rbRevista.setText("Revistas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbTodo)
                    .addComponent(rbLibro))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbRevista)
                    .addComponent(rbAcademico))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTodo)
                    .addComponent(rbAcademico))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbLibro)
                    .addComponent(rbRevista))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenar por"));

        buttonGroup2.add(rbAutor);
        rbAutor.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rbAutor.setText("Autor");

        buttonGroup2.add(rbAño);
        rbAño.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rbAño.setText("Año");

        buttonGroup2.add(rbTitulo);
        rbTitulo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rbTitulo.setText("Título");

        buttonGroup2.add(rbCodigo);
        rbCodigo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rbCodigo.setSelected(true);
        rbCodigo.setText("Código");

        buttonGroup2.add(rbCantidad);
        rbCantidad.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rbCantidad.setText("Cantidad");

        buttonGroup2.add(rbTipo);
        rbTipo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rbTipo.setText("Tipo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbCodigo)
                    .addComponent(rbAño))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbTitulo)
                    .addComponent(rbAutor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbCantidad)
                    .addComponent(rbTipo))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbTitulo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbCodigo)
                        .addComponent(rbCantidad)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAño)
                    .addComponent(rbAutor)
                    .addComponent(rbTipo))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnVolver.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(scrLibros)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnMostrar)
                .addGap(37, 37, 37)
                .addComponent(btnVolver)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnMostrar)
                                    .addComponent(btnVolver))
                                .addGap(36, 36, 36)))
                        .addComponent(scrLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        lista = biblioteca.getLibrosBiblioteca().getLista();

        if (rbCodigo.isSelected()) {
            Collections.sort(lista);
        } else if (rbTitulo.isSelected()) {
            Collections.sort(lista, new CompararLibroPorTitulo());
        } else if (rbAutor.isSelected()) {
            Collections.sort(lista, new CompararLibroPorAutor());
        } else if (rbAño.isSelected()) {
            Collections.sort(lista, new CompararLibroPorAño());
        } else if (rbTipo.isSelected()) {
            Collections.sort(lista, new CompararLibroPorTipo());
        } else if (rbCantidad.isSelected()) {
            Collections.sort(lista, new CompararLibroPorCantidad());
        }

        llenarTabla(lista);

    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        if (pos == -1) {
            new FormPresDirector(biblioteca, this).setVisible(true);
        } else {
            new FormPresBibliotecario(biblioteca, this, pos).setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    public void wasd() {
        modelo = new DefaultTableModel();
        String columnas[] = {"wasd", "wasd", "wasd"};
        modelo.setColumnIdentifiers(columnas);
        tblLibros.setModel(modelo);
    }

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
//            java.util.logging.Logger.getLogger(FormMostrarLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormMostrarLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormMostrarLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormMostrarLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormMostrarLibros().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton rbAcademico;
    private javax.swing.JRadioButton rbAutor;
    private javax.swing.JRadioButton rbAño;
    private javax.swing.JRadioButton rbCantidad;
    private javax.swing.JRadioButton rbCodigo;
    private javax.swing.JRadioButton rbLibro;
    private javax.swing.JRadioButton rbRevista;
    private javax.swing.JRadioButton rbTipo;
    private javax.swing.JRadioButton rbTitulo;
    private javax.swing.JRadioButton rbTodo;
    private javax.swing.JScrollPane scrLibros;
    private javax.swing.JTable tblLibros;
    // End of variables declaration//GEN-END:variables
    private Biblioteca biblioteca;
    private List<LibroBiblioteca> lista;
    private DefaultTableModel modelo;
    private int pos = -1;
}
