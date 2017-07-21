package com.sistema_bancario.model.pojo;
// Generated 21/07/2017 17:45:32 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TipoServicio generated by hbm2java
 */
@Entity
@Table(name="tipo_servicio"
    ,catalog="bancodb"
)
public class TipoServicio  implements java.io.Serializable {


     private Integer idtipoServicio;
     private String nombre;
     private Set<Servicio> servicios = new HashSet<Servicio>(0);

    public TipoServicio() {
    }

    public TipoServicio(String nombre, Set<Servicio> servicios) {
       this.nombre = nombre;
       this.servicios = servicios;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idtipo_servicio", unique=true, nullable=false)
    public Integer getIdtipoServicio() {
        return this.idtipoServicio;
    }
    
    public void setIdtipoServicio(Integer idtipoServicio) {
        this.idtipoServicio = idtipoServicio;
    }

    
    @Column(name="nombre", length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tipoServicio")
    public Set<Servicio> getServicios() {
        return this.servicios;
    }
    
    public void setServicios(Set<Servicio> servicios) {
        this.servicios = servicios;
    }




}


