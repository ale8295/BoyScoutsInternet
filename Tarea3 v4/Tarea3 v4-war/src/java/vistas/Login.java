/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import entidades.Usuarios;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import negocio.ContraseniaInvalidaException;
import negocio.CuentaInactivaException;
import negocio.CuentaInexistenteException;
import negocio.LoginException;
import negocio.Negocio;

/**
 *
 * @author User
 */
@Named(value = "login")
@RequestScoped
public class Login {

    private boolean logeado = false;
    FacesMessage msg = null;
    @Inject
    private ControlAutorizacion ctrl;
    
    private Usuarios usuario;

    /**
     * Creates a new instance of Login
     *
     * @return
     */
    
    public Login(){
        usuario = new Usuarios();
    }   

    public boolean isLogeado() {
        return logeado;
    }

    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public void logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        logeado = false;
    }

    public String autenticar() throws LoginException {
        // Implementar este método
       try{
           if(!usuario.getUsuario().equals("") && !usuario.getContrasena().equals("")){
           ctrl.conectar(usuario);
           return "index.xhtml";
           }else{
               if(usuario.getUsuario().equals("")){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El campo usuario es obligatorio", "El campo usuario es obligatorio"));
               }
               if(usuario.getContrasena().equals("")){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El campo contraseña es obligatorio", "El campo contraseña es obligatorio"));
               }
           }
       } catch (CuentaInexistenteException e) {
            FacesMessage fm = new FacesMessage("La cuenta no existe");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (ContraseniaInvalidaException e) {
            FacesMessage fm = new FacesMessage("La contraseña no es correcta");
            FacesContext.getCurrentInstance().addMessage("login:pass", fm);
        }
        return null;
    } 
    

}
