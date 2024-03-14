package controladores;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import modelos.Evento;
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

}
