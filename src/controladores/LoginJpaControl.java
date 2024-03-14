package controladores;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import modelos.Usuario;

/**
 *
 * @author accel
 */

public class LoginJpaControl implements Serializable {

    private EntityManagerFactory emf = null;

    public LoginJpaControl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    
    public boolean login(String usuario, String contrasena) {
        EntityManager em = getEntityManager();

        try {
            Usuario usuarioEncontrado = em.createQuery("SELECT u FROM Usuario u WHERE u.usuario = :username", Usuario.class)
                    .setParameter("username", usuario)
                    .getSingleResult();

               return usuarioEncontrado != null && usuarioEncontrado.getContrasena().equals(contrasena);

        } catch (NoResultException e) {
            return false;
        } catch (Exception e) {
            throw new RuntimeException("Error al realizar el login", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
