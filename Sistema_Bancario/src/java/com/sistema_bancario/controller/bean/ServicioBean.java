/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema_bancario.controller.bean;

import com.sistema_bancario.model.pojo.Servicio;
import java.util.List;
import javax.faces.bean.ManagedBean;
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
        return servicios;
    }

    /**
     * @param servicios the servicios to set
     */
    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
    
}
