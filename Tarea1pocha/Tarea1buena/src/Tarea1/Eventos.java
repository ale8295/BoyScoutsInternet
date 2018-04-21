/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea1;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author pepe
 */
@Embeddable
public class Eventos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_evento;
    @Temporal (TemporalType.DATE)
    private Date dia;
    private int duracion;
    private String lugar;
    @OneToMany
    private List<Comentarios> listComents;
    @OneToOne
    private SeccionWeb seccionWeb;
    @ManyToMany
    private List<GrupoScout> grupoScout;
    @ManyToMany
    private List<Socios> listSocios;
    
    public Long getId_evento() {
        return id_evento;
    }

    public void setId_evento(Long id_evento) {
        this.id_evento = id_evento;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public List<Comentarios> getListComents() {
        return listComents;
    }

    public void setListComents(List<Comentarios> listComents) {
        this.listComents = listComents;
    }

    public SeccionWeb getSeccionWeb() {
        return seccionWeb;
    }

    public void setSeccionWeb(SeccionWeb seccionWeb) {
        this.seccionWeb = seccionWeb;
    }

    public List<GrupoScout> getGrupoScout() {
        return grupoScout;
    }

    public void setGrupoScout(List<GrupoScout> grupoScout) {
        this.grupoScout = grupoScout;
    }

    public List<Socios> getListSocios() {
        return listSocios;
    }

    public void setListSocios(List<Socios> listSocios) {
        this.listSocios = listSocios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_evento != null ? id_evento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_evento fields are not set
        if (!(object instanceof Eventos)) {
            return false;
        }
        Eventos other = (Eventos) object;
        if ((this.id_evento == null && other.id_evento != null) || (this.id_evento != null && !this.id_evento.equals(other.id_evento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarea1.Eventos[ id=" + id_evento + " ]";
    }
    
}
