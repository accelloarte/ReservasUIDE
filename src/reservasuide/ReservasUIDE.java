/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reservasuide;

import controler.UserJpaControl;
import model.User;
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
        UserJpaControl userControl = new UserJpaControl(JPAUtil.getEntityManagerFactory());

        User user = new User();
        user.setUsername("Camila");
        user.setPassword("password");
        userControl.crear(user);
    }

}
