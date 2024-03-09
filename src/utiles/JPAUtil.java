package utiles;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


//clase activa permanentemente para trabajar con la base de datos
public class JPAUtil {

    private static final EntityManagerFactory emf;

    private static final String persistense_name = "reservas";

    static {
        emf = Persistence.createEntityManagerFactory(persistense_name);
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
