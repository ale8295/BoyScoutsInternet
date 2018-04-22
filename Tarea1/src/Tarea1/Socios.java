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
public class Socios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id_socio;
    
    @Column (nullable = false)
    @Temporal (TemporalType.DATE)
    private Date fecha_nacimiento;
    
    @Column (nullable = false)
    private String dni;
    
    @Column (nullable = true)
    private String grupo;
    
    @Column (nullable = false)
    @Temporal (TemporalType.DATE)
    private Date fecha_ingreso;
    
    @Column (nullable = true)
    @Temporal (TemporalType.DATE)
    private Date fecha_baja;
    
    @Column (nullable = true)
    private String rutaFoto; //Imagen de socio
    
    @Column (nullable = false)
    private String usuario; //Nombre de acceso del usuario
    
    @Column (nullable = false)
    private String contrasena; //Contraseña del usuario
    
    @Column (nullable = true)
    @ManyToOne
    private RespLegal respLegal;
    
    @Embedded
    @Column (nullable = false)
    @OneToMany
    @ElementCollection
    private List<Cuotas> listaCuotas;
    
    @Embedded
    @Column (nullable = false)
    @OneToMany
    @ElementCollection
    private List<Permisos> listaPermisos;
    
    @Embedded 
    @Column (nullable = true)
    @OneToMany
    @ElementCollection
    private List<Comentarios> listaComentarios;
    
    @Embedded 
    @Column (nullable = true)
    @OneToMany
    @ElementCollection
    private List<HistorialEventos> historialEventos;
      
    @OneToOne
    @Column (nullable = true)
    private Documentacion documentacion;
    
    @Embedded 
    @Column (nullable = true)
    @OneToMany
    @ElementCollection
    private List<RegistroGrupo> listaRegistros;
         
    
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

    public RespLegal getRespLegal() {
        return respLegal;
    }

    public void setRespLegal(RespLegal respLegal) {
        this.respLegal = respLegal;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Cuotas> getListaCuotas() {
        return listaCuotas;
    }

    public void setListaCuotas(List<Cuotas> listaCuotas) {
        this.listaCuotas = listaCuotas;
    }

    public List<Permisos> getListaPermisos() {
        return listaPermisos;
    }

    public void setListaPermisos(List<Permisos> listaPermisos) {
        this.listaPermisos = listaPermisos;
    }

    public List<Comentarios> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(List<Comentarios> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public List<HistorialEventos> getHistorialEventos() {
        return historialEventos;
    }

    public void setHistorialEventos(List<HistorialEventos> historialEventos) {
        this.historialEventos = historialEventos;
    }

    public Documentacion getDocumentacion() {
        return documentacion;
    }

    public void setDocumentacion(Documentacion documentacion) {
        this.documentacion = documentacion;
    }

    public List<RegistroGrupo> getListaRegistros() {
        return listaRegistros;
    }

    public void setListaRegistros(List<RegistroGrupo> listaRegistros) {
        this.listaRegistros = listaRegistros;
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
