package controladores;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import modelos.Usuario;

/**
 *
 * @author domen
 */

public class LoginJpaControl implements Serializable {

    private EntityManagerFactory emf = null;

    public LoginJpaControl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    
    public Usuario login(String usuario, String contrasena) {
        EntityManager em = getEntityManager();

        try {
            Usuario usuarioEncontrado = em.createQuery("SELECT u FROM Usuario u WHERE u.usuario = :username", Usuario.class)
                    .setParameter("username", usuario)
                    .getSingleResult();

            if (usuarioEncontrado != null && usuarioEncontrado.getContrasena().equals(contrasena)) {
                return usuarioEncontrado;
            } else {
                return null; 
            }

        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Error al realizar el login", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
