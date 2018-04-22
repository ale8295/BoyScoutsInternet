/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea1;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


@Entity
public class Eventos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id_evento;
    
    @JoinColumn (nullable = false)
    @Temporal (TemporalType.DATE)
    private Date fecha;
    
    @JoinColumn (nullable = false)
    private int duracion;
    
    @JoinColumn (nullable = false)
    private String lugar;
    
    @JoinColumn (nullable = true)
    private String descripcion;
    
    @JoinColumn (nullable = true)
    private String rutaImagen;
    
    @JoinColumn (nullable = true)
    private String recomendaciones;
    
    @JoinColumn (nullable = true)
    private String inscripcion;
            
    @JoinColumn (nullable = true)
    private String asistencia;
    
    @Embedded 
    @JoinColumn (nullable = true)
    @OneToMany
    @ElementCollection
    private List<Comentarios> listaComentarios;
    
    @Embedded 
    @JoinColumn (nullable = true)
    @OneToMany
    @ElementCollection
    private List<HistorialEventos> listaHistorial;
    
    @ManyToOne
    private SeccionWeb seccionWeb;
    
    @ManyToMany
    private List<GrupoScout> listaGrupoScout;
    
    public Long getId_evento() {
        return id_evento;
    }

    public void setId_evento(Long id_evento) {
        this.id_evento = id_evento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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

    public SeccionWeb getSeccionWeb() {
        return seccionWeb;
    }

    public void setSeccionWeb(SeccionWeb seccionWeb) {
        this.seccionWeb = seccionWeb;
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
