/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
public class GrupoScout implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_grupo;
    
    @Column (nullable = false)
    private String nombre_grupo;
    
    @OneToOne
    @JoinColumn (nullable = false)
    private Scouter scouter;
    
    @JoinColumn (nullable = true)
    public List<Eventos> listaEventos;    
    
    @JoinColumn (nullable = true)
    @OneToOne
    private Usuarios usuario;
    
    public Long getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(Long id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getNombre_grupo() {
        return nombre_grupo;
    }

    public void setNombre_grupo(String nombre_grupo) {
        this.nombre_grupo = nombre_grupo;
    }

    public Scouter getScouter() {
        return scouter;
    }

    public void setScouter(Scouter scouter) {
        this.scouter = scouter;
    }

    public List<Eventos> getListaEventos() {
        return listaEventos;
    }

    public void setListaEventos(List<Eventos> listaEventos) {
        this.listaEventos = listaEventos;
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
        hash += (id_grupo != null ? id_grupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_grupo fields are not set
        if (!(object instanceof GrupoScout)) {
            return false;
        }
        GrupoScout other = (GrupoScout) object;
        if ((this.id_grupo == null && other.id_grupo != null) || (this.id_grupo != null && !this.id_grupo.equals(other.id_grupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarea1.GrupoScout[ id=" + id_grupo + " ]";
    }
    
}
