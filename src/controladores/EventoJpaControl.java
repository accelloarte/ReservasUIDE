package controladores;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import modelos.Evento;

/**
 *
 * @author domen
 */
public class EventoJpaControl implements Serializable {

    private EntityManagerFactory emf = null;

    public EventoJpaControl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void crear(Evento evento) {
        EntityManager em = getEntityManager();
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(evento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Evento> consultarTodos() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM Evento e");
            List<Evento> eventos = query.getResultList();
            return eventos;
        } finally {
            em.close();
        }
    }

    public Evento consultarPorId(int id) {
        EntityManager em = getEntityManager();
        try {
            Evento entidad = em.find(Evento.class, id);
            return entidad;
        } finally {
            em.close();
        }
    }

    public void actualizar(Evento evento) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(evento);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminar(int id) {
        EntityManager em = getEntityManager();
        try {
            Evento graduado = em.find(Evento.class, id);
            em.getTransaction().begin();
            em.remove(graduado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
