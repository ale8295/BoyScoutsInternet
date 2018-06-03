/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import entidades.GrupoScout;
import entidades.Scouter;
import entidades.Usuarios;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import negocio.LoginException;
import negocio.Negocio;

/**
 *
 * @author User
 */
@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {

    @EJB
    private Negocio negocio;

    private Usuarios usuario;

    private GrupoScout grupo;
    private String tipo;

    private String contrasenia;
    private String contrasenia2;
    private String ncon;
    private String email;

    public ControlAutorizacion() {
        ncon = new String();
        contrasenia = new String();
        contrasenia2 = new String();
        email = new String();
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String home() {
        if (usuario == null) {
            return "signin.xhtml";
        } else if (usuario.getRol().equals("ADMINISTRADOR")) {
            return "Evento.xhtml";
        } else if (usuario.getRol().equals("VOLUNTARIO") || usuario.getRol().equals("EDUCANDO")) {
            return "index.xhtml";
        }
        return null;
    }

    public void conectar(Usuarios usu) throws LoginException {
        usuario = negocio.refrescarUsuario(usu);
    }

    public String logout() {
        if (usuario != null) {
            usuario = null;
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.getExternalContext().invalidateSession();
        }

        return "index.xhtml";
    }

    public GrupoScout getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoScout grupo) {
        this.grupo = grupo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public String modificarPerfil() throws LoginException {

        if (!ncon.equals("") && contrasenia == null) {
            usuario.setNumContacto(ncon);
        }
        if (!email.equals("") && contrasenia == null) {
            usuario.setEmail(email);
        }
        if (contrasenia.equals(contrasenia2) && !contrasenia.equals("")) {
            usuario.setContrasena(contrasenia);
            if (ncon != null) {
                usuario.setNumContacto(ncon);
            }
            if (email != null) {
                usuario.setEmail(email);
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El campo contraseña debe ser igual", "El campo contraseña debe ser igual"));
        }
        negocio.modificar(usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El perfil ha sido modificado", "El perfil ha sido modificado"));
        return "Perfil.xhtml";
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getContrasenia2() {
        return contrasenia2;
    }

    public void setContrasenia2(String contrasenia2) {
        this.contrasenia2 = contrasenia2;
    }

    public String getNcon() {
        return ncon;
    }

    public void setNcon(String ncon) {
        this.ncon = ncon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
