/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema_bancario.controller.bean;

import com.sistema_bancario.dao.Tipo_ServicioDAO;
import com.sistema_bancario.model.pojo.TipoServicio;
<<<<<<< HEAD
import java.io.Serializable;
=======
import java.util.Iterator;
>>>>>>> 7aedc6a534da9e6829ae131e94947d53f1d860d1
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author EQUIPO
 */
@Named(value = "tipoServicioBean")
@ViewScoped
public class TipoServicioBean implements Serializable{

    private TipoServicio tipoServicio;
    private List<TipoServicio> tipoServicios;
    
    
    /**
     * Creates a new instance of TipoServicioBean
     */
    public TipoServicioBean() {
        tipoServicio=new TipoServicio();
    }

    /**
     * @return the tipoServicio
     */
    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    /**
     * @param tipoServicio the tipoServicio to set
     */
    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    /**
     * @return the tipoServicios
     */
    public List<TipoServicio> getTipoServicios() {
        return tipoServicios;
    }

    /**
     * @param tipoServicios the tipoServicios to set
     */
    public void setTipoServicios(List<TipoServicio> tipoServicios) {
        this.tipoServicios = tipoServicios;
    }
    
    public void agregarTipoServ(){
      try{
          Tipo_ServicioDAO tiposervDao = new Tipo_ServicioDAO();
          tiposervDao.agregarTipoServ(tipoServicio);
          tipoServicio=new TipoServicio();
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registro"));
      }catch(Exception e){
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Alerta", "Error"));
     
      }
       
    }
   
   public void actualizarTipoServ(){
        Tipo_ServicioDAO tiposervDao = new Tipo_ServicioDAO();
          tiposervDao.actualizarTipoServ(tipoServicio);
          tipoServicio=new TipoServicio();
   }
   
   public void eliminarTipoServ(){
       Tipo_ServicioDAO tiposervDao = new Tipo_ServicioDAO();
          tiposervDao.eliminarTipoServicio(tipoServicio);
          tipoServicio=new TipoServicio();
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
