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
public class GrupoScout implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id_grupo;
    
    @JoinColumn (nullable = false)
    private String nombre_grupo;
    
    @OneToOne
    @JoinColumn (nullable = false)
    private Scouter scouter;
    
    @ManyToMany
    @JoinColumn (nullable = true)
    private List<Eventos> listaEventos;
    
    @OneToOne
    @JoinColumn (nullable = true)
    private SeccionWeb seccionWeb;
    
    @Embedded 
    @JoinColumn (nullable = true)
    @OneToMany
    @ElementCollection
    private List<RegistroGrupo> listRegistros;
    
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

    public SeccionWeb getSeccionWeb() {
        return seccionWeb;
    }

    public void setSeccionWeb(SeccionWeb seccionWeb) {
        this.seccionWeb = seccionWeb;
    }

    public List<RegistroGrupo> getListRegistros() {
        return listRegistros;
    }

    public void setListRegistros(List<RegistroGrupo> listRegistros) {
        this.listRegistros = listRegistros;
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
