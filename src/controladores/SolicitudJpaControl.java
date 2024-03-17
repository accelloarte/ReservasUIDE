package controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import modelos.Evento;
import modelos.Lugar;
import modelos.SolicitudEvento;

/**
 *
 * @author domen
 */
public class SolicitudJpaControl implements Serializable {

    private EntityManagerFactory emf = null;

    public SolicitudJpaControl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void crear(SolicitudEvento solicitud) {
        EntityManager em = getEntityManager();
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(solicitud);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SolicitudEvento> consultarTodos() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM SolicitudEvento e");
            List<SolicitudEvento> solicitudes = query.getResultList();
            return solicitudes;
        } finally {
            em.close();
        }
    }

//    public boolean consultarDisponibilidadSala(Lugar lugar, Evento evento) {
//        EntityManager em = getEntityManager();
//        try {
//            Query query = em.createQuery("SELECT s FROM Lugar s WHERE s.lugar = :lugar AND s.evento = :evento AND s.disponibilidad = :disponible");
//            query.setParameter("lugar", lugar);
//            query.setParameter("evento", evento);
//            query.setParameter("disponible", "Disponible");
//            List<Lugar> salas = query.getResultList();
//            return !salas.isEmpty();
//        } finally {
//            em.close();
//        }
//    }
    public List<String> consultarFechasOcupadas() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM SolicitudEvento e JOIN FETCH e.evento WHERE e.estado = :estado");
            query.setParameter("estado", "Pendiente");
            List<SolicitudEvento> solicitudes = query.getResultList();
            List<String> fechas = new ArrayList<>();
            for (SolicitudEvento solicitud : solicitudes) {
                Evento evento = solicitud.getEvento();
                fechas.add(evento.getFecha());
                System.out.println(evento.getFecha() + " " + evento.getHora());
            }

            return fechas;
        } finally {
            em.close();
        }
    }

    public List<SolicitudEvento> consultarSolicitudesExistentes(String fecha) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM SolicitudEvento e WHERE e.fechaSolicitud = :fecha");
            query.setParameter("fecha", fecha);
            List<SolicitudEvento> solicitudes = query.getResultList();
            return solicitudes;
        } finally {
            em.close();
        }
    }

    public List<SolicitudEvento> validarRegistro() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM SolicitudEvento e JOIN FETCH e.evento JOIN FETCH e.evento.lugar WHERE e.estado = :estado");
            query.setParameter("estado", "Pendiente");
            List<SolicitudEvento> solicitudes = query.getResultList();
            for (SolicitudEvento solicitud : solicitudes) {
                Lugar lugar = solicitud.getEvento().getLugar();
//                boolean salaDisponible = consultarDisponibilidadSala(lugar, solicitud.getEvento().getFecha(), solicitud.getEvento().getHora());
//                List<SolicitudEvento> solicitudesExistentes = consultarSolicitudesExistentes(solicitud.getEvento().getFecha());
//                if (!salaDisponible || !solicitudesExistentes.isEmpty()) {
//                }
            }
            return solicitudes;
        } finally {
            em.close();
        }
    }

    public SolicitudEvento consultarPorId(int id) {
        EntityManager em = getEntityManager();
        try {
            SolicitudEvento entidad = em.find(SolicitudEvento.class, id);
            return entidad;
        } finally {
            em.close();
        }
    }

    public void actualizar(SolicitudEvento solicitud) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(solicitud);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminar(int id) {
        EntityManager em = getEntityManager();
        try {
            SolicitudEvento graduado = em.find(SolicitudEvento.class, id);
            em.getTransaction().begin();
            em.remove(graduado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SolicitudEvento> getSolicitudesEvento(Evento evento) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT s FROM SolicitudEvento s WHERE s.evento = :evento");
            query.setParameter("evento", evento);
            List<SolicitudEvento> solicitudes = query.getResultList();
            return solicitudes;
        } finally {
            em.close();
        }
    }

    public List<SolicitudEvento> actualizaEstado(int id, String estado) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("update SolicitudEvento set estado = :estado WHERE id = :id ");
            query.setParameter("estado", estado);
            query.setParameter("id", id);

            List<SolicitudEvento> solicitudes = query.getResultList();
            return solicitudes;
        } finally {
            em.close();
        }
    }

}
