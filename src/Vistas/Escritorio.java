/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import controladores.EventoJpaControl;
import java.awt.BorderLayout;
import java.awt.Image;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelos.Evento;
import modelos.Usuario;
import utiles.JPAUtil;
import utiles.ModeloGenericoTabla;

/**
 *
 * @author domen
 */
public class Escritorio extends javax.swing.JFrame {

    int xMouse, yMouse;
    EventoJpaControl controlEvento = new EventoJpaControl(JPAUtil.getEntityManagerFactory());
    Evento evento;
    Usuario usuario;
    List<Evento> eventos = null;

    ModeloGenericoTabla ModeloTabla;

    public Escritorio(Usuario usuario) {
        initComponents();
        this.setLocationRelativeTo(this);
        this.usuario = usuario;
        SetTamanoImagen(lbLogo, "src/imagenes/logo.png");
        SetTamanoImagen(lbIcon, "src/imagenes/uide.png");
        cargarDatosTabla();

        PaginaEventos p1 = new PaginaEventos(usuario);
        p1.setSize(990, 595);
        p1.setLocation(5, 5);

        PanelEscritorio.removeAll();
        PanelEscritorio.add(p1, BorderLayout.CENTER);
        PanelEscritorio.revalidate();
        PanelEscritorio.repaint();

    }

    private void cargarDatosTabla() {

        eventos = controlEvento.consultarTodos();

        try {
            String[] Columnas = new String[]{"Nombre", "Tipo", "Fecha", "Hora", "Lugar", "Cupos", "Descripción"};
            String[] filas = new String[]{"nombre", "tipoEvento", "fecha", "hora", "ubicacion", "numeroAsistentes", "descripcion"};
            this.ModeloTabla = new ModeloGenericoTabla(Columnas, filas, eventos);
            //this.tablaEventos.setModel(ModeloTabla);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarVista(JPanel pagina) {

        pagina.removeAll();
        pagina.add(pagina);
        pagina.revalidate();
        pagina.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel3 = new javax.swing.JPanel();
        PanelMenu = new javax.swing.JPanel();
        lbLogo = new javax.swing.JLabel();
        btEventos1 = new javax.swing.JButton();
        btEventos2 = new javax.swing.JButton();
        PanelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();
        PanelEscritorio = new javax.swing.JPanel();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelMenu.setBackground(new java.awt.Color(145, 0, 72));

        lbLogo.setText(" ");

        btEventos1.setBackground(new java.awt.Color(252, 185, 0));
        btEventos1.setFont(new java.awt.Font("Jaini Purva", 0, 14)); // NOI18N
        btEventos1.setText("Gestión de eventos");
        btEventos1.setBorder(null);
        btEventos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEventos1ActionPerformed(evt);
            }
        });

        btEventos2.setBackground(new java.awt.Color(252, 185, 0));
        btEventos2.setFont(new java.awt.Font("Jaini Purva", 0, 14)); // NOI18N
        btEventos2.setText("Gestión de solicitudes");
        btEventos2.setBorder(null);
        btEventos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEventos2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelMenuLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btEventos2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(btEventos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(btEventos1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btEventos2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(343, Short.MAX_VALUE))
        );

        jPanel3.add(PanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 660));

        PanelTitulo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Gurmukhi Sangam MN", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("SISTEMA DE RESERVAS Y SOLICITUDES DE EVENTOS");

        javax.swing.GroupLayout PanelTituloLayout = new javax.swing.GroupLayout(PanelTitulo);
        PanelTitulo.setLayout(PanelTituloLayout);
        PanelTituloLayout.setHorizontalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE))
        );
        PanelTituloLayout.setVerticalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.add(PanelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1000, 60));

        PanelEscritorio.setBackground(new java.awt.Color(234, 234, 234));

        javax.swing.GroupLayout PanelEscritorioLayout = new javax.swing.GroupLayout(PanelEscritorio);
        PanelEscritorio.setLayout(PanelEscritorioLayout);
        PanelEscritorioLayout.setHorizontalGroup(
            PanelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        PanelEscritorioLayout.setVerticalGroup(
            PanelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jPanel3.add(PanelEscritorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 1000, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEventos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEventos1ActionPerformed

        PaginaEventos p1 = new PaginaEventos(usuario);
        p1.setSize(990, 595);
        p1.setLocation(5, 5);

        PanelEscritorio.removeAll();
        PanelEscritorio.add(p1, BorderLayout.CENTER);
        PanelEscritorio.revalidate();
        PanelEscritorio.repaint();

    }//GEN-LAST:event_btEventos1ActionPerformed

    private void btEventos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEventos2ActionPerformed
        PaginaSolicitudes p2 = new PaginaSolicitudes(usuario);
        p2.setSize(990, 595);
        p2.setLocation(5, 5);

        PanelEscritorio.removeAll();
        PanelEscritorio.add(p2, BorderLayout.CENTER);
        PanelEscritorio.revalidate();
        PanelEscritorio.repaint();
    }//GEN-LAST:event_btEventos2ActionPerformed

    private void SetTamanoImagen(JLabel labelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        this.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelEscritorio;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JButton btEventos1;
    private javax.swing.JButton btEventos2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbLogo;
    // End of variables declaration//GEN-END:variables
}
