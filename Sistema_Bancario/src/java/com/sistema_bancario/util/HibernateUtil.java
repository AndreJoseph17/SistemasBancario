/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema_bancario.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author andre
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {

        try {
            Configuration configuration = new Configuration();
            configuration.configure("/hibernate.cfg.xml");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
<<<<<<< HEAD
             System.out.println("El servicio de anotación de hibernate fue creado....o eso creo :v");
             sessionFactory = configuration.buildSessionFactory(serviceRegistry);
             return sessionFactory;
         
         }catch(Throwable ex){
             System.out.println("Falló la creación de sessionFactory....otra vez "+ ex);
             throw new ExceptionInInitializerError(ex);
         }
     } 
     
     public static SessionFactory getSessionFactory(){
         if(sessionFactory == null) 
             sessionFactory = buildSessionFactory();
         return sessionFactory;
     }
     
     public static void shutdown(){
         sessionFactory.close();
     }
=======
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;

        } catch (Throwable ex) {
            System.out.println("Falló la creación de sessionFactory" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void shutdown() {
        sessionFactory.close();
    }
>>>>>>> 816a5dd7fea42ab52d073fa88fbc249708d4e40d
}
