package vistas;


import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicolas
 */
@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {

    private Usuario usuario;
    private String nombre;
    private String dir;
    private String email;
    private String tlf;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String home() {
        if(usuario == null){
            return "signin.xhtml";
        }else if (usuario.getRol() == Usuario.Rol.ADMINISTRADOR){
            return "Evento.xhtml";
        }else if (usuario.getRol() == Usuario.Rol.NORMAL){
            return "index.xhtml";
        }
        return null;
    }
    
    public String logout()
    {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "index.xhtml";
    }

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ControlAutorizacion() {
    }
    
    
    public String guardarperfil(){
        usuario.setNombre(nombre);
        usuario.setTlf(tlf);
        usuario.setEmail(email);
        usuario.setDireccion(dir);
        return "Perfil.xhtml";
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    
}
