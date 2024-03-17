/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reservasuide;

import controladores.EventoJpaControl;
import controladores.SolicitudJpaControl;
import controladores.UsuarioJpaControl;
import java.util.List;
import modelos.Evento;
import modelos.Lugar;
import modelos.SolicitudEvento;
import modelos.Usuario;
import utiles.JPAUtil;

/**
 *
 * @author accel
 */
public class ReservasUIDE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        UsuarioJpaControl userControl = new UsuarioJpaControl(JPAUtil.getEntityManagerFactory());
        Usuario usuario = new Usuario();

        usuario.setNombre("Ana Gómez");
        usuario.setTipoUsuario("Estudiante");
        usuario.setCorreo("ana@email.com");
        usuario.setUsuario("agomez");
        usuario.setContrasena("admin");
        
        userControl.crear(usuario);

        usuario.setNombre("Camila Loarte");
        usuario.setTipoUsuario("Estudiante");
        usuario.setCorreo("caloarte@email.com");
        usuario.setUsuario("caloarte");
        usuario.setContrasena("123");

        userControl.crear(usuario);

        EventoJpaControl eventoControl = new EventoJpaControl(JPAUtil.getEntityManagerFactory());
        
        Lugar ubicacion = new Lugar();
        ubicacion.setNombre("AULA MAGNA");
        ubicacion.setTipoLugar("AUDITORIO");
        ubicacion.setCapacidad(20);
        ubicacion.setDisponibilidad("LIBRE");
        
        Evento evento = new Evento();
        evento.setNombre("Conferencia de Software Libre");
        evento.setTipoEvento("Conferencia");
        evento.setFecha("2024-03-20");
        evento.setHora("10:00");
        evento.setLugar(ubicacion);
        evento.setNumeroAsistentes(100);
        evento.setDescripcion("Conferencia sobre las últimas tendencias en software libre.");
        eventoControl.crear(evento);

        SolicitudJpaControl solicitudControl = new SolicitudJpaControl(JPAUtil.getEntityManagerFactory());

        SolicitudEvento solicitudEvento = new SolicitudEvento();
        solicitudEvento.setEvento(evento);
        solicitudEvento.setUsuario(usuario);
        solicitudEvento.setFechaSolicitud("2024-03-15");
        solicitudEvento.setEstado("PENDIENTE");
        solicitudControl.crear(solicitudEvento);
        
        List<Evento> lstEventos = eventoControl.consultarTodos();

        for (Evento events : lstEventos) {
            System.out.println("Evento: " + events.getNombre());
            System.out.println("Fecha: " + events.getFecha());

            List<SolicitudEvento> solicitudes = solicitudControl.getSolicitudesEvento(events);

            if (!solicitudes.isEmpty()) {
                System.out.println("Solicitudes:");
                for (SolicitudEvento solicitud : solicitudes) {
                    System.out.println(" - " + solicitud.getUsuario().getNombre());
                    System.out.println("    Fecha solicitud: " + solicitud.getFechaSolicitud());
                    System.out.println("    Estado: " + solicitud.getEstado());
                }
            } else {
                System.out.println("No hay solicitudes para este evento.");
            }

            System.out.println();
        }

    }

}
