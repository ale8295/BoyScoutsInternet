/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Entity
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(nullable = false)
    private String usuario; //Nombre de acceso del usuario

    @Column(nullable = false)
    private String contrasena; //Contraseña del usuario

    @Column(nullable = false)
    private String fecha_nacimiento;

    @Column(nullable = true)
    private String rol;

    @Column(nullable = false)
    private String dni;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = true)
    private String grupo;

    @Column(nullable = true)
    private String fecha_ingreso;

    @Column(nullable = true)
    private String rutaFoto; //Imagen de usuario

    
    

    @ManyToOne
    @JoinColumn(nullable = true)
    private RespLegal respLegal;

    @OneToMany(mappedBy = "usuario")
    private List<Cuotas> listaCuotas;

    @OneToMany(mappedBy = "usuario")
    @JoinColumn(nullable = true)
    private List<Permisos> listaPermisos;

    @OneToMany(mappedBy = "usuario")
    @JoinColumn(nullable = true)
    private List<Comentarios> listaComentarios;

    @OneToMany(mappedBy = "usuario")
    @JoinColumn(nullable = true)
    private List<HistorialEventos> historialEventos; //metodo para meter en historial eventos y para mostrar eventos

    @OneToOne
    @JoinColumn(nullable = true)
    private Documentacion documentacion;

    @OneToOne
    @JoinColumn(nullable = true)
    private GrupoScout grupoScout;

    @Column(nullable = false)
    private String numContacto;

    @Column(nullable = false)
    private String sexo;

    @Column(nullable = false)
    private String email;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
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

    public GrupoScout getGrupoScout() {
        return grupoScout;
    }

    public void setGrupoScout(GrupoScout grupoScout) {
        this.grupoScout = grupoScout;
    }

    public String getNumContacto() {
        return numContacto;
    }

    public void setNumContacto(String numContacto) {
        this.numContacto = numContacto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.dni);
        hash = 97 * hash + Objects.hashCode(this.usuario);
        hash = 97 * hash + Objects.hashCode(this.contrasena);
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
        final Usuarios other = (Usuarios) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.contrasena, other.contrasena)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }

}
