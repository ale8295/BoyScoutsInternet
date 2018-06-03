/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
public class Cuotas implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CuotaId id_codigo; 
    
    
    @Column (nullable = false)
    private float cantidad;
    
    @Column (nullable = false)
    private String fecha_pago;
    
    @Column (nullable = true)
    private String descripcion;
    
    @ManyToOne
    @MapsId("usuario")
    public Usuarios usuario;
    
    public CuotaId getId_codigo() {
        return id_codigo;
    }

    public void setId_codigo(CuotaId id_codigo) {
        this.id_codigo = id_codigo;
    }


    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
       

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_codigo != null ? id_codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuotas)) {
            return false;
        }
        Cuotas other = (Cuotas) object;
        if ((this.id_codigo == null && other.id_codigo != null) || (this.id_codigo != null && !this.id_codigo.equals(other.id_codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarea1.Cuotas[ id=" + id_codigo + " ]";
    }
}
