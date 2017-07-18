<<<<<<< HEAD:SistemaBancario/src/main/java/com/sistemabancario/model/pojo/Planilla.java
package com.sistemabancario.model.pojo;
// Generated 18/07/2017 16:11:11 by Hibernate Tools 4.3.1
=======
package Model;
// Generated 18/07/2017 15:29:45 by Hibernate Tools 4.3.1
>>>>>>> 218c09201e8e3c382f722ec23e62754416b08f1d:SistemaBancario/src/main/java/Model/Planilla.java


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Planilla generated by hbm2java
 */
@Entity
@Table(name="planilla"
    ,catalog="bancodb"
)
public class Planilla  implements java.io.Serializable {


     private String idplanilla;
     private Servicio servicio;
     private Transaccion transaccion;
     private Double valor;
     private String idContratoCliente;
     private Date fechaEmision;
     private Date fechaPago;
     private String estado;

    public Planilla() {
    }

	
    public Planilla(String idplanilla, Servicio servicio, Transaccion transaccion) {
        this.idplanilla = idplanilla;
        this.servicio = servicio;
        this.transaccion = transaccion;
    }
    public Planilla(String idplanilla, Servicio servicio, Transaccion transaccion, Double valor, String idContratoCliente, Date fechaEmision, Date fechaPago, String estado) {
       this.idplanilla = idplanilla;
       this.servicio = servicio;
       this.transaccion = transaccion;
       this.valor = valor;
       this.idContratoCliente = idContratoCliente;
       this.fechaEmision = fechaEmision;
       this.fechaPago = fechaPago;
       this.estado = estado;
    }
   
     @Id 

    
    @Column(name="idplanilla", unique=true, nullable=false, length=45)
    public String getIdplanilla() {
        return this.idplanilla;
    }
    
    public void setIdplanilla(String idplanilla) {
        this.idplanilla = idplanilla;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="servicio_idservicio", nullable=false)
    public Servicio getServicio() {
        return this.servicio;
    }
    
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="transaccion_idtransaccion", nullable=false)
    public Transaccion getTransaccion() {
        return this.transaccion;
    }
    
    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    
    @Column(name="valor", precision=22, scale=0)
    public Double getValor() {
        return this.valor;
    }
    
    public void setValor(Double valor) {
        this.valor = valor;
    }

    
    @Column(name="id_contrato_cliente", length=45)
    public String getIdContratoCliente() {
        return this.idContratoCliente;
    }
    
    public void setIdContratoCliente(String idContratoCliente) {
        this.idContratoCliente = idContratoCliente;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_emision", length=19)
    public Date getFechaEmision() {
        return this.fechaEmision;
    }
    
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_pago", length=19)
    public Date getFechaPago() {
        return this.fechaPago;
    }
    
    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    
    @Column(name="estado", length=45)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


