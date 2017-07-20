/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

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
     private static SessionFactory buildSessionFactory(){
         
         try{
            Configuration configuration = new Configuration();
            configuration.configure("/../resources/hibernate.cfg.xml");
            System.out.println("Se cargó esa verga de hibernate.cfg");
            
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
             System.out.println("El servicio de anotación de hibernate fue creado....o eso creo :v");
             sessionFactory = configuration.buildSessionFactory(serviceRegistry);
             return sessionFactory;
         
         }catch(Throwable ex){
             System.out.println("Falló la creación de esa webada de sessionFactory....otra vez "+ ex);
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
}
