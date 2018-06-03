/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@NamedQuery( name="lista.historialEventos", query="SELECT h FROM HistorialEventos h")
public class HistorialEventos implements Serializable {    
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private HistorialEventosId id_eventos;
    
    @Column (nullable = true)
    private String valoracion;
    
    @ManyToOne
    @MapsId("usuario")
    private Usuarios usuario;
    
    @ManyToOne
    @MapsId("id_evento")
    private Eventos evento;
        
    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public HistorialEventosId getId_eventos() {
        return id_eventos;
    }

    public void setId_eventos(HistorialEventosId id_eventos) {
        this.id_eventos = id_eventos;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Eventos getEvento() {
        return evento;
    }

    public void setEvento(Eventos evento) {
        this.evento = evento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id_eventos);
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
        final HistorialEventos other = (HistorialEventos) obj;
        if (!Objects.equals(this.id_eventos, other.id_eventos)) {
            return false;
        }
        return true;
    }
    
}
