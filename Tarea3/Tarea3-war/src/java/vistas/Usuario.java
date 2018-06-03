package vistas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicolas
 */

import entidades.Eventos;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author francis
 */
@Entity
public class Usuario implements Serializable {
    
    public enum Rol {
      ADMINISTRADOR,
      NORMAL
    };
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String dni;
    private String fNac;
    private String fIng;
    private String sexo;
    private String direccion;
    private String tlf;
    private String grupo;
    private String img;
    private String email;
    private String usuario;
    private String contrasenia;
    private String contrasenia2;
    private List<Eventos> historialEv;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    
    
    public Usuario()
    {
        
    }
    
    public Usuario (String email, String contrasenia, Rol rol)
    {
        setUsuario(email);
        setContrasenia(contrasenia);
        setRol(rol);
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getfNac() {
        return fNac;
    }

    public void setfNac(String fNac) {
        this.fNac = fNac;
        perteneceGrupo();
    }
    
         public void perteneceGrupo(){
        
        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha = LocalDate.parse(fNac, formatter);
        LocalDate fecha2 = LocalDate.parse(hoy.toString(),formatter);
        long edad = ChronoUnit.YEARS.between(fecha, fecha2); 
        if(edad<8 && edad>=6){
            setGrupo("Castores");
        }else if(edad>=8 && edad<11){
            setGrupo("Lobatos");
        }else if(edad>=11 && edad<14){
            setGrupo("Scouts");
        }else if(edad>=14 && edad<17){
            setGrupo("Escultas/Pioneros");
        }else if(edad>=17 && edad<21){
            setGrupo("Rovers/CompaÃ±eros");
        }else if(edad>=21){
            setGrupo("Scouters de apoyo");
        }else{
            setGrupo("No tiene edad suficiente para entrar a ningún grupo");
        }
    }

    public String getfIng() {
        return fIng;
    }

    public void setfIng(String fIng) {
        this.fIng = fIng;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getContrasenia2() {
        return contrasenia2;
    }

    public void setContrasenia2(String contrasenia2) {
        this.contrasenia2 = contrasenia2;
    }

 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Eventos> getHistorialEv() {
        return historialEv;
    }

    public void setHistorialEv(List<Eventos> historialEv) {
        this.historialEv = historialEv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}