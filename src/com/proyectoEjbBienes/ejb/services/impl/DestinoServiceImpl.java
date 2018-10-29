package com.proyectoEjbBienes.ejb.services.impl;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.proyectoEjbBienes.ejb.services.DestinoServices;
import proyectoEjbBienes.Catdestino;


public class DestinoServiceImpl implements DestinoServices {
	
	
	
	private static final String PERSISTENCE_UNIT_NAME ="DestinoApp";
	public  EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	public  EntityManager  em = emf.createEntityManager();
 
	@Override
	public void addDestino(Catdestino destino) {
	try {
		
		em.getTransaction().begin();
		em.merge(destino);
		em.getTransaction().commit();
	}catch(Exception e) {
	    e.printStackTrace();	
	}	
		
	}
	@Override
	public  List getAllDestino(){
		Query queryObj = em.createQuery("SELECT destino FROM Catdestino destino");
        List listaDestino = queryObj.getResultList();
        System.out.println(" lista destino "+ listaDestino.size() );
        if (listaDestino != null && listaDestino.size() > 0) {           
            return listaDestino;
        } else {
            return null;
        }
	}
	

	
	
}
