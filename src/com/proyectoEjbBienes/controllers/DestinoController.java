package com.proyectoEjbBienes.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.Query;

import com.proyectoEjbBienes.ejb.services.DestinoServices;
import com.proyectoEjbBienes.ejb.services.impl.DestinoServiceImpl;

import proyectoEjbBienes.Catdestino;;
 
@ManagedBean
public class DestinoController {
	
	private Catdestino destino = new Catdestino();
	
	private List <Catdestino> destinos;
	 
    private DestinoServiceImpl destinoService = new DestinoServiceImpl ();
 
	public Catdestino getDestino() {
		return destino;
	}
 
	public void setDestino(Catdestino destino) {
		this.destino = destino;
	}
 
	public void saveDestino(Catdestino destino) {
		System.out.println("Nombre DestinoController" + destino.getNombre());
		destinoService.addDestino(destino);
	}

	
	public List <Catdestino> getDestinos(){
		return destinoService.getAllDestino();
	}
}
