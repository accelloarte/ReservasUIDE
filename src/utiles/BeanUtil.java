/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utiles;

import java.lang.reflect.Method;

/**
 *
 * @author domen
 */
public class BeanUtil {
    public static void invokesetter(Object obj, String field, Object param, 
            Class paramClass) throws Exception{
        String prefix = "set";
        if (field.length() > 0 ){
            String setterMethod = prefix + field.substring(0,1).toUpperCase()+
                    field.substring(1, field.length());
            Method m = obj.getClass().getMethod(setterMethod, paramClass);
            m.invoke(obj, param);
        }
        
    }
    public static Object invokeGetter(Object obj, String field) throws  Exception{
        String prefix = "get";
        Object objReturn = null;
        try{
            if (obj.getClass().getDeclaredField(field).getType()== Boolean.class){
                prefix = "is";
            }    
        }catch (Exception e){
                System.out.println("Error en los parametros get y set");                                
        }
        if (field.length() > 0){
            String getterMethod = prefix + field.substring(0,1).toUpperCase()+
                    field.substring(1, field.length());
            Method m = obj.getClass().getMethod(getterMethod, new Class[0]);
            objReturn = m.invoke(obj, new Object[0]);
        }
        return objReturn;
        }
    }

