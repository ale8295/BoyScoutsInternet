/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author User
 */
@Embeddable
public class HistorialEventosId implements Serializable{
    private static final long serialVersionUID = 1L;
    private String usuario;
    private long id_evento;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public long getId_evento() {
        return id_evento;
    }

    public void setId_evento(long id_evento) {
        this.id_evento = id_evento;
    }

    

    public long getId_eventos() {
        return id_evento;
    }

    public void setId_eventos(long id_eventos) {
        this.id_evento = id_eventos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.usuario);
        hash = 53 * hash + (int) (this.id_evento ^ (this.id_evento >>> 32));
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
        final HistorialEventosId other = (HistorialEventosId) obj;
        if (this.id_evento != other.id_evento) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    
    
    
}
