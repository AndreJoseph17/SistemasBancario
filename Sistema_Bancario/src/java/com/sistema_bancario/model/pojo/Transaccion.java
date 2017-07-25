package com.sistema_bancario.model.pojo;
// Generated 23/07/2017 22:28:09 by Hibernate Tools 4.3.1


import com.sistema_bancario.util.HibernateUtil;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Transaccion generated by hbm2java
 */
@Entity
@Table(name="transaccion"
    ,catalog="bancodb"
)
/**
 * Mapeo de procedimiento almacenado - registrar_transacciones  
 */
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
        name = "generar_transferencia",
        procedureName = "generar_transferencia",
        parameters = {  @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "id_cuenta_principal"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "id_cuenta_2"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class, name = "valor_pagar"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Integer.class, name = "valor_retorno") } ),
        
    @NamedStoredProcedureQuery(
        name = "filtrar_transacciones_fecha",
        procedureName = "filtrar_transacciones_fecha",
        parameters = {  @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "idcuenta_principal"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "fecha_inicio"),
                        @StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class, name = "fecha_final"),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Integer.class, name = "valor_retorno")})
}    
)




public class Transaccion  implements java.io.Serializable {


     private Integer idtransaccion;
     private Cuenta cuentaByCuentaIdcuenta2;
     private Cuenta cuentaByCuentaIdcuentaPrincipal;
     private TipoTransaccion tipoTransaccion;
     private double cantidad;
     private Date fecha;
     private Double saldoAnterior;
     private Double saldoPosterior;
     private Set<Planilla> planillas = new HashSet<Planilla>(0);

     /**
      * EntityManager
      */
     private EntityManagerFactory emf;
     
    public Transaccion() {
    }

	
    public Transaccion(Cuenta cuentaByCuentaIdcuenta2, Cuenta cuentaByCuentaIdcuentaPrincipal, TipoTransaccion tipoTransaccion, double cantidad, Date fecha) {
        this.cuentaByCuentaIdcuenta2 = cuentaByCuentaIdcuenta2;
        this.cuentaByCuentaIdcuentaPrincipal = cuentaByCuentaIdcuentaPrincipal;
        this.tipoTransaccion = tipoTransaccion;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
    public Transaccion(Cuenta cuentaByCuentaIdcuenta2, Cuenta cuentaByCuentaIdcuentaPrincipal, TipoTransaccion tipoTransaccion, double cantidad, Date fecha, Double saldoAnterior, Double saldoPosterior, Set<Planilla> planillas) {
       this.cuentaByCuentaIdcuenta2 = cuentaByCuentaIdcuenta2;
       this.cuentaByCuentaIdcuentaPrincipal = cuentaByCuentaIdcuentaPrincipal;
       this.tipoTransaccion = tipoTransaccion;
       this.cantidad = cantidad;
       this.fecha = fecha;
       this.saldoAnterior = saldoAnterior;
       this.saldoPosterior = saldoPosterior;
       this.planillas = planillas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idtransaccion", unique=true, nullable=false)
    public Integer getIdtransaccion() {
        return this.idtransaccion;
    }
    
    public void setIdtransaccion(Integer idtransaccion) {
        this.idtransaccion = idtransaccion;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cuenta_idcuenta_2", nullable=false)
    public Cuenta getCuentaByCuentaIdcuenta2() {
        return this.cuentaByCuentaIdcuenta2;
    }
    
    public void setCuentaByCuentaIdcuenta2(Cuenta cuentaByCuentaIdcuenta2) {
        this.cuentaByCuentaIdcuenta2 = cuentaByCuentaIdcuenta2;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cuenta_idcuenta_principal", nullable=false)
    public Cuenta getCuentaByCuentaIdcuentaPrincipal() {
        return this.cuentaByCuentaIdcuentaPrincipal;
    }
    
    public void setCuentaByCuentaIdcuentaPrincipal(Cuenta cuentaByCuentaIdcuentaPrincipal) {
        this.cuentaByCuentaIdcuentaPrincipal = cuentaByCuentaIdcuentaPrincipal;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tipo_transaccion_idtipo_transaccion", nullable=false)
    public TipoTransaccion getTipoTransaccion() {
        return this.tipoTransaccion;
    }
    
    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    
    @Column(name="cantidad", nullable=false, precision=22, scale=0)
    public double getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha", nullable=false, length=19)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="saldo_Anterior", precision=22, scale=0)
    public Double getSaldoAnterior() {
        return this.saldoAnterior;
    }
    
    public void setSaldoAnterior(Double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    
    @Column(name="saldo_Posterior", precision=22, scale=0)
    public Double getSaldoPosterior() {
        return this.saldoPosterior;
    }
    
    public void setSaldoPosterior(Double saldoPosterior) {
        this.saldoPosterior = saldoPosterior;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="transaccion")
    public Set<Planilla> getPlanillas() {
        return this.planillas;
    }
    
    public void setPlanillas(Set<Planilla> planillas) {
        this.planillas = planillas;
    }
    
    /**
     * 
     * @param id_usuario
     * @return 
     */
    public List<Transaccion> cuentas_por_fecha(String id_usuario){

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Transaccion> cuentas = null;
        try{
        session.beginTransaction();
        Query query = session.createQuery("call revisar_cuentas_fecha('"+ id_usuario+"')");
        cuentas = (List<Transaccion>) query.list();
        session.flush();
        session.close();
        
        }catch(Exception e){
            System.out.println(e);
        }
        
        return cuentas;
    }
    
    /**
     * Método para llamar a procedimiento almacenado registrar_transaccion
     * @param id_cuenta_principal
     * @param id_cuenta_2
     * @param valor_pagar
     * @return 
     */


    public Integer registrar_transaccion(Integer id_cuenta_principal, Integer id_cuenta_2, 
                                        Double valor_pagar){
        
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction();
        
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("generar_transferencia");
        query.setParameter("id_cuenta_principal", id_cuenta_principal);
        query.setParameter("id_cuenta_2", id_cuenta_2);
        query.setParameter("valor_pagar", valor_pagar);
        query.execute();
        
        Integer valor_retorno = (Integer) query.getOutputParameterValue("valor_retorno");
        em.getTransaction().commit();
        em.close();
        
        return valor_retorno;
        
    }
    
    /**
     * Método para filtrar transacciones de cierta fecha a otra 
     * @param idcuenta_principal
     * @param fecha_inicio
     * @param fecha_final
     * @param valor_retorno
     * @return 
     */
    
   public List<Transaccion> filtrar_transacciones_fecha(Integer idcuenta_principal, Date fecha_inicio,
                                                        Date fecha_final ,Integer valor_retorno){
       EntityManager em = emf.createEntityManager();
       em.getTransaction();
       
       StoredProcedureQuery query = em.createNamedStoredProcedureQuery("filtrar_transacciones_fecha");
       query.setParameter("idcuenta_principal", idcuenta_principal);
       query.setParameter("fecha_inicio", fecha_inicio);
       query.setParameter("fecha_final", fecha_final);
       query.execute();
       
       List<Transaccion> filtro_transacciones =  query.getResultList();
       em.getTransaction().commit();
       em.close();
       
       return filtro_transacciones;
   }

}


