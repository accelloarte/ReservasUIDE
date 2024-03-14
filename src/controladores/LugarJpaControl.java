package controladores;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import modelos.Lugar;

/**
 *
 * @author domen
 */
public class LugarJpaControl implements Serializable {

    private EntityManagerFactory emf = null;

    public LugarJpaControl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void crear(Lugar lugar) {
        EntityManager em = getEntityManager();
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(lugar);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Lugar> consultarTodos() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM Lugar e");
            List<Lugar> lugares = query.getResultList();
            return lugares;
        } finally {
            em.close();
        }
    }

    public void actualizar(Lugar lugar) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(lugar);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
