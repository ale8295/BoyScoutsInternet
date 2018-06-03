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


/**
 *
 * @author User
 */
@Entity
public class Comentarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private ComentariosId id_comentario;

    @Column(nullable = true)
    private String descripcion;

    @Column(nullable = true)
    private String fecha;
    
    @ManyToOne
    @MapsId("usuario")
    private Usuarios usuario;

    @ManyToOne
    @MapsId("id_evento")
    private Eventos evento;    
    
    public ComentariosId getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(ComentariosId id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
        int hash = 0;
        hash += (id_comentario != null ? id_comentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentarios)) {
            return false;
        }
        Comentarios other = (Comentarios) object;
        if ((this.id_comentario == null && other.id_comentario != null) || (this.id_comentario != null && !this.id_comentario.equals(other.id_comentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarea1.Comentarios[ id=" + id_comentario + " ]";
    }

}
