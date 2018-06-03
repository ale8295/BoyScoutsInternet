/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@NamedQuery(name = "lista.eventos", query = "SELECT e FROM Eventos e")
public class Eventos implements Serializable {

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_evento;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String fecha;

    @Column(nullable = true)
    private int duracion;

    @Column(nullable = false)
    private String lugar;

    @Column(nullable = true)
    private String descripcion;

    @Column(nullable = true)
    private String rutaImagen;

    @Column(nullable = true)
    private String recomendaciones;

    @Column(nullable = true)
    private String inscripcion;

    @Column(nullable = true)
    private String asistencia;

    @JoinColumn(nullable = true)
    @OneToMany(mappedBy = "evento")
    private List<Comentarios> listaComentarios;

    @JoinColumn(nullable = true)
    @OneToMany(mappedBy = "evento")
    private List<HistorialEventos> listaHistorial;

    @ManyToMany
    @JoinTable(name="participan",joinColumns = @JoinColumn(name = "id_grupo"),
    inverseJoinColumns = @JoinColumn(name = "id_evento"))
    public List<GrupoScout> listaGrupoScout;

    public Long getId_evento() {
        return id_evento;
    }

    public void setId_evento(Long id_evento) {
        this.id_evento = id_evento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(String inscripcion) {
        this.inscripcion = inscripcion;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
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

    public List<Comentarios> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(List<Comentarios> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public List<HistorialEventos> getListaHistorial() {
        return listaHistorial;
    }

    public void setListaHistorial(List<HistorialEventos> listaHistorial) {
        this.listaHistorial = listaHistorial;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public List<GrupoScout> getListaGrupoScout() {
        return listaGrupoScout;
    }

    public void setListaGrupoScout(List<GrupoScout> listaGrupoScout) {
        this.listaGrupoScout = listaGrupoScout;
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
