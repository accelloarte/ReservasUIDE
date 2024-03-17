/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import controladores.EventoJpaControl;
import controladores.LugarJpaControl;
import controladores.SolicitudJpaControl;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Evento;
import modelos.Lugar;
import modelos.SolicitudEvento;
import modelos.Usuario;

import utiles.JPAUtil;
import utiles.ModeloGenericoTabla;

/**
 *
 * @author domen
 */
public class PaginaEventos extends javax.swing.JPanel {

    EventoJpaControl controlEvento = new EventoJpaControl(JPAUtil.getEntityManagerFactory());
    SolicitudJpaControl solicitudControl = new SolicitudJpaControl(JPAUtil.getEntityManagerFactory());
    Evento evento;
    Usuario usuario;
    Lugar lugar;
    int vista = 0;
    List<String> listaFechas;
    List<Evento> eventos = null;
    List<Lugar> lugares = null;
    String formattedDate = null;

    ModeloGenericoTabla ModeloTabla;

    public PaginaEventos(Usuario user) {
        initComponents();
        usuario = user;
        cargarDatosTabla();
        listaLugares();

        cbmUbicacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lugar = (Lugar) cbmUbicacion.getSelectedItem();
            }
        });

        listaFechas = solicitudControl.consultarFechasOcupadas();

        jDateChooser1.getDateEditor().addPropertyChangeListener(e -> {
            if ("date".equals(e.getPropertyName())) {
                Date selectedDate = jDateChooser1.getDate();

                SimpleDateFormat customFormat = new SimpleDateFormat("dd/MM/yyyy");
                formattedDate = customFormat.format(selectedDate);

                if (selectedDate != null) {

                    System.out.println("Fecha seleccionada: " + selectedDate);

                    if (listaFechas.contains(formattedDate)) {
                        JOptionPane.showMessageDialog(this, "La fecha seleccionada está disponible.");
                        System.out.println("La fecha seleccionada está disponible.");

                    } else {
                        JOptionPane.showMessageDialog(this, "La fecha seleccionada no está disponible.");
                        System.out.println("La fecha seleccionada no está disponible.");
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Por favor, selecciona una fecha.");
                    System.out.println("Por favor, selecciona una fecha.");
                }
            }
        });
        

    }

    private void cargarDatosTabla() {

        eventos = controlEvento.consultarTodos();

        try {
            String[] Columnas = new String[]{"Nombre", "Tipo", "Fecha", "Hora", "Cupos", "Descripción"};
            String[] filas = new String[]{"nombre", "tipoEvento", "fecha", "hora", "numeroAsistentes", "descripcion"};

            this.ModeloTabla = new ModeloGenericoTabla(Columnas, filas, eventos);
            this.tablaEventos.setModel(ModeloTabla);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void listaLugares() {
        LugarJpaControl lugarControl = new LugarJpaControl(JPAUtil.getEntityManagerFactory());
        lugares = lugarControl.consultarTodos();
        cbmUbicacion.removeAllItems();
        for (Lugar lg : lugares) {
            cbmUbicacion.addItem(lg);
        }
    }

    private void deshabilitaFormulario() {

        txtNombre.setEnabled(false);
        cbmTipo.setEnabled(false);
        //txtFecha.setEnabled(false);
        txtHora.setEnabled(false);
        txtAsistentes.setEnabled(false);
        txtDescripcion.setEnabled(false);
        cbmUbicacion.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEventos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btCrearEvento = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        cbmTipo = new javax.swing.JComboBox<>();
        cbmUbicacion = new javax.swing.JComboBox<>();
        txtAsistentes = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtHora = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(234, 234, 234));
        setPreferredSize(new java.awt.Dimension(990, 608));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbTitulo.setFont(new java.awt.Font("Gurmukhi MT", 0, 14)); // NOI18N
        lbTitulo.setText("Eventos:");

        tablaEventos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaEventosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEventos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Nombre:");

        jLabel4.setText("Tipo:");

        jLabel5.setText("Ubicación");

        jLabel6.setText("Cupos:");

        jLabel9.setText("Fecha:");

        jLabel10.setText("Hora:");

        jLabel7.setText("Descripción:");

        jLabel2.setFont(new java.awt.Font("Gurmukhi MT", 0, 14)); // NOI18N
        jLabel2.setText("Solicitar evento");

        btCrearEvento.setBackground(new java.awt.Color(252, 185, 0));
        btCrearEvento.setFont(new java.awt.Font("Jaini Purva", 0, 14)); // NOI18N
        btCrearEvento.setText("Solicitar");
        btCrearEvento.setBorder(null);
        btCrearEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCrearEventoActionPerformed(evt);
            }
        });

        cbmTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "CONFERENCIA", "SEMINARIO", "CHARLA", "GRADO", "FESTIVAL", " " }));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jDateChooser1.setDateFormatString("dd/MM/yyyy HH:mm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbmTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombre)
                                .addComponent(cbmUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtAsistentes)
                                .addComponent(txtHora)))))
                .addGap(14, 14, 14))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btCrearEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbmTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbmUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAsistentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btCrearEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void tablaEventosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEventosMousePressed
        int filaSeleccionada = this.tablaEventos.getSelectedRow();

        if (filaSeleccionada >= 0) {
            evento = this.eventos.get(filaSeleccionada);
            deshabilitaFormulario();
            txtNombre.setText(evento.getNombre());

            //txtFecha.setText(evento.getFecha());
            txtHora.setText(evento.getHora());

            cbmTipo.setSelectedItem(evento.getTipoEvento());
            txtAsistentes.setValue(evento.getNumeroAsistentes());
            txtDescripcion.setText(evento.getDescripcion());
            cbmUbicacion.setSelectedItem(evento.getLugar().getNombre());

            if (vista == 0) {
                deshabilitaFormulario();
            }

        } else {
            System.out.println("Ningún evento seleccionado.");
        }
    }//GEN-LAST:event_tablaEventosMousePressed

    private void btCrearEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCrearEventoActionPerformed

        try {
            evento = new Evento();
            evento.setNombre(txtNombre.getText());
            evento.setTipoEvento(cbmTipo.getSelectedItem().toString());
            evento.setFecha(formattedDate);
            evento.setHora(txtHora.getText());
            evento.setNumeroAsistentes(Integer.parseInt(txtAsistentes.getName()));
            evento.setDescripcion(txtDescripcion.getText());
            evento.setUsuario(this.usuario);
            evento.setLugar(lugar);

            SolicitudEvento solicitudEvento = new SolicitudEvento();
            solicitudEvento.setEvento(evento);
            solicitudEvento.setUsuario(usuario);
            System.out.println(usuario.getNombre());
            solicitudEvento.setFechaSolicitud(LocalDate.now().toString());
            solicitudEvento.setEstado("PENDIENTE");
            solicitudEvento.setComentario("");
            solicitudControl.crear(solicitudEvento);
            JOptionPane.showMessageDialog(this, "Evento creado correctamente");
            
        } catch (HeadlessException | NumberFormatException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Evento no creado correctamente");
        }

    }//GEN-LAST:event_btCrearEventoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCrearEvento;
    private javax.swing.JComboBox<String> cbmTipo;
    private javax.swing.JComboBox<Lugar> cbmUbicacion;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTable tablaEventos;
    private javax.swing.JSpinner txtAsistentes;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
