/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
public class Permisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private PermisosId id_permiso;

    @Column (nullable = false)
    private boolean escribir;
    
    @Column (nullable = false)
    private boolean leer;
    
    @Column (nullable = false)
    private boolean subirDoc;
    
    @Column (nullable = false)
    private boolean adminTienda;
    
    @Column (nullable = false)
    private boolean gestion;

    @ManyToOne   
    @MapsId("usuario")
    private Usuarios usuario;
    
    public PermisosId getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(PermisosId id_permiso) {
        this.id_permiso = id_permiso;
    }
    

    public boolean isEscribir() {
        return escribir;
    }

    public void setEscribir(boolean escribir) {
        this.escribir = escribir;
    }

    public boolean isLeer() {
        return leer;
    }

    public void setLeer(boolean leer) {
        this.leer = leer;
    }

    public boolean isSubirDoc() {
        return subirDoc;
    }

    public void setSubirDoc(boolean subirDoc) {
        this.subirDoc = subirDoc;
    }

    public boolean isAdminTienda() {
        return adminTienda;
    }

    public void setAdminTienda(boolean adminTienda) {
        this.adminTienda = adminTienda;
    }

    public boolean isGestion() {
        return gestion;
    }

    public void setGestion(boolean gestion) {
        this.gestion = gestion;
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
        hash += (id_permiso != null ? id_permiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permisos)) {
            return false;
        }
        Permisos other = (Permisos) object;
        if ((this.id_permiso == null && other.id_permiso != null) || (this.id_permiso != null && !this.id_permiso.equals(other.id_permiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarea1.Permisos[ id=" + id_permiso + " ]";
    }
    
}
