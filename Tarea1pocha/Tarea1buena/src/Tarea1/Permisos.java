/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea1;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Embedded;

/**
 *
 * @author pepe
 */
@Entity
public class Permisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_permiso;
    private boolean escribir;
    private boolean leer;
    private boolean subirDoc;
    private boolean adminTienda;
    private boolean gestion;
    @ManyToOne
    private Socios socio;
    @Embedded
    private Socios socios;

    public Long getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(Long id_permiso) {
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

    public Socios getSocio() {
        return socio;
    }

    public void setSocio(Socios socio) {
        this.socio = socio;
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
