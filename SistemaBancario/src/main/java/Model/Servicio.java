package Model;
// Generated 18/07/2017 15:29:45 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Servicio generated by hbm2java
 */
public class Servicio  implements java.io.Serializable {


     private String idservicio;
     private Cuenta cuenta;
     private TipoServicio tipoServicio;
     private String detalle;
     private Set<Planilla> planillas = new HashSet<Planilla>(0);

    public Servicio() {
    }

	
    public Servicio(String idservicio, Cuenta cuenta, TipoServicio tipoServicio) {
        this.idservicio = idservicio;
        this.cuenta = cuenta;
        this.tipoServicio = tipoServicio;
    }
    public Servicio(String idservicio, Cuenta cuenta, TipoServicio tipoServicio, String detalle, Set<Planilla> planillas) {
       this.idservicio = idservicio;
       this.cuenta = cuenta;
       this.tipoServicio = tipoServicio;
       this.detalle = detalle;
       this.planillas = planillas;
    }
   
    public String getIdservicio() {
        return this.idservicio;
    }
    
    public void setIdservicio(String idservicio) {
        this.idservicio = idservicio;
    }
    public Cuenta getCuenta() {
        return this.cuenta;
    }
    
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    public TipoServicio getTipoServicio() {
        return this.tipoServicio;
    }
    
    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
    public String getDetalle() {
        return this.detalle;
    }
    
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    public Set<Planilla> getPlanillas() {
        return this.planillas;
    }
    
    public void setPlanillas(Set<Planilla> planillas) {
        this.planillas = planillas;
    }




}

