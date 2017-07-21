package com.sistema_bancario.model.pojo;
// Generated 21/07/2017 14:57:07 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Servicio generated by hbm2java
 */
@Entity
@Table(name="servicio"
    ,catalog="bancodb"
)
public class Servicio  implements java.io.Serializable {


     private Integer idservicio;
     private Cuenta cuenta;
     private TipoServicio tipoServicio;
     private String detalle;
     private Set<Planilla> planillas = new HashSet<Planilla>(0);

    public Servicio() {
    }

	
    public Servicio(Cuenta cuenta, TipoServicio tipoServicio) {
        this.cuenta = cuenta;
        this.tipoServicio = tipoServicio;
    }
    public Servicio(Cuenta cuenta, TipoServicio tipoServicio, String detalle, Set<Planilla> planillas) {
       this.cuenta = cuenta;
       this.tipoServicio = tipoServicio;
       this.detalle = detalle;
       this.planillas = planillas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idservicio", unique=true, nullable=false)
    public Integer getIdservicio() {
        return this.idservicio;
    }
    
    public void setIdservicio(Integer idservicio) {
        this.idservicio = idservicio;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cuenta_idcuenta", nullable=false)
    public Cuenta getCuenta() {
        return this.cuenta;
    }
    
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tipo_servicio_idtipo_servicio", nullable=false)
    public TipoServicio getTipoServicio() {
        return this.tipoServicio;
    }
    
    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    
    @Column(name="detalle", length=45)
    public String getDetalle() {
        return this.detalle;
    }
    
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="servicio")
    public Set<Planilla> getPlanillas() {
        return this.planillas;
    }
    
    public void setPlanillas(Set<Planilla> planillas) {
        this.planillas = planillas;
    }




}


