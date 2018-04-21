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
import javax.persistence.Embeddable;

/**
 *
 * @author pepe
 */

@Embeddable
public class Socios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_socio;
    private String dni;
    private String grupo;
    @Temporal (TemporalType.DATE)
    private Date fecha_nacimiento;
    @Temporal (TemporalType.DATE)
    private Date fecha_ingreso;
    @Temporal (TemporalType.DATE)
    private Date fecha_baja;
    @ManyToMany
    private List<RespLegal> listRL;
    @OneToMany
    private List<Cuotas> listCuotas;
    @OneToMany
    private List<Permisos> listPermisos;
    @OneToMany
    private List<Comentarios> listComentarios;
    @ManyToMany
    private List<Eventos> listEventos;
    @OneToOne (fetch = FetchType.LAZY)
    private Documentacion documento;
    @ManyToOne
    private GrupoScout grupoScout;
    
    public Long getId() {
        return id_socio;
    }

    public void setId(Long id) {
        this.id_socio = id;
    }

    public Long getId_socio() {
        return id_socio;
    }

    public void setId_socio(Long id_socio) {
        this.id_socio = id_socio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public List<RespLegal> getListRL() {
        return listRL;
    }

    public void setListRL(List<RespLegal> listRL) {
        this.listRL = listRL;
    }

    public List<Cuotas> getListCuotas() {
        return listCuotas;
    }

    public void setListCuotas(List<Cuotas> listCuotas) {
        this.listCuotas = listCuotas;
    }

    public List<Permisos> getListPermisos() {
        return listPermisos;
    }

    public void setListPermisos(List<Permisos> listPermisos) {
        this.listPermisos = listPermisos;
    }

    public List<Comentarios> getListComentarios() {
        return listComentarios;
    }

    public void setListComentarios(List<Comentarios> listComentarios) {
        this.listComentarios = listComentarios;
    }

    public List<Eventos> getListEventos() {
        return listEventos;
    }

    public void setListEventos(List<Eventos> listEventos) {
        this.listEventos = listEventos;
    }

    public Documentacion getDocumento() {
        return documento;
    }

    public void setDocumento(Documentacion documento) {
        this.documento = documento;
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
        hash += (id_socio != null ? id_socio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socios)) {
            return false;
        }
        Socios other = (Socios) object;
        if ((this.id_socio == null && other.id_socio != null) || (this.id_socio != null && !this.id_socio.equals(other.id_socio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarea1.Socios[ id=" + id_socio+ " ]";
    }
    
}
