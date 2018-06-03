/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

/**
 *
 * @author User
 */
@Embeddable
public class PermisosId implements Serializable{
    private static final long serialVersionUID = 1L;
    private long id_permiso;
    private String usuario;

    public long getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(long id_permiso) {
        this.id_permiso = id_permiso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.id_permiso ^ (this.id_permiso >>> 32));
        hash = 53 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PermisosId other = (PermisosId) obj;
        if (this.id_permiso != other.id_permiso) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }


 


    
}