/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Tarea1 {

    public static void main(String[] string) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tarea1");
        EntityManager em = emf.createEntityManager();

        em.close();
        emf.close();

    }

}
