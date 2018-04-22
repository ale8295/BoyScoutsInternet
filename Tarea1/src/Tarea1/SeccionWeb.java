/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea1;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


@Entity
public class SeccionWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long url;
    
    @JoinColumn (nullable = false)
    private String nombre_seleccion;
    
    @JoinColumn (nullable = true)
    @OneToMany
    private List<Eventos> listaEventos;
    
    @JoinColumn (nullable = true)
    @OneToOne
    private GrupoScout grupoScout;
    
    
    public Long getUrl() {
        return url;
    }

    public void setUrl(Long url) {
        this.url = url;
    }

    public String getNombre_seleccion() {
        return nombre_seleccion;
    }

    public void setNombre_seleccion(String nombre_seleccion) {
        this.nombre_seleccion = nombre_seleccion;
    }

    public List<Eventos> getListaEventos() {
        return listaEventos;
    }

    public void setListaEventos(List<Eventos> listaEventos) {
        this.listaEventos = listaEventos;
    }

    

    public GrupoScout getGrupoScout() {
        return grupoScout;
    }

    public void setGrupoScout(GrupoScout grupoScout) {
        this.grupoScout = grupoScout;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (url != null ? url.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the url fields are not set
        if (!(object instanceof SeccionWeb)) {
            return false;
        }
        SeccionWeb other = (SeccionWeb) object;
        if ((this.url == null && other.url != null) || (this.url != null && !this.url.equals(other.url))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarea1.SeccionWeb[ id=" + url + " ]";
    }
    
}
