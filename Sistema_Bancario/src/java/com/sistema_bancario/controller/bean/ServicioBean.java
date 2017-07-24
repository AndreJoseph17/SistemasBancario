/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema_bancario.controller.bean;

import com.sistema_bancario.dao.ServicioDAO;
import com.sistema_bancario.model.pojo.Servicio;
import com.sistema_bancario.model.pojo.TipoServicio;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author EQUIPO
 */
@ManagedBean(name = "servicioBean")
@ViewScoped
public class ServicioBean {
    
    
    private Servicio servicio;
    private List<Servicio> servicios;
    /**
     * Creates a new instance of ServicioBean
     */
    public ServicioBean() {
        servicio=new Servicio();
    }

    /**
     * @return the servicio
     */
    public Servicio getServicio() {
        return servicio;
    }

    /**
     * @param servicio the servicio to set
     */
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    /**
     * @return the servicios
     */
    public List<Servicio> getServicios() {
        ServicioDAO servicioDao=new ServicioDAO();
        servicios=servicioDao.AllServicios();
        return servicios;
    }

       /**
     * @param servicios the servicios to set
     */
    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
    
    
     public void agregarServicio(){
      try{
          ServicioDAO servicioDao = new ServicioDAO();
          servicioDao.agregarServicio(servicio);
          servicio=new Servicio();
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registro el servicio"));
      }catch(Exception e){
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Alerta", "Error"));
     
      }
       
    }
   
   public void actualizarServicio(){
       ServicioDAO servicioDao = new ServicioDAO();
       servicioDao.actualizarServicio(servicio);
       servicio=new Servicio();
   }
   
   public void eliminarPropietario(){
       ServicioDAO servicioDao = new ServicioDAO();
       servicioDao.eliminarServicio(servicio);
       servicio=new Servicio();
   }
   
   public String listarItems(Set<TipoServicio> items){
       String cadena="";
       for (Iterator<TipoServicio> iterator = items.iterator(); iterator.hasNext();) {
            TipoServicio next = iterator.next();
            cadena=next.getNombre()+cadena;
        }
        return cadena;
   }
}
