/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import entidades.Comentarios;
import entidades.Eventos;
import entidades.GrupoScout;
import entidades.Usuarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import negocio.LoginException;
import negocio.Negocio;
import negocio.NegocioEventos;

/**
 *
 * @author User
 */
@Named(value = "vistaEvento")
@SessionScoped
public class Evento implements Serializable{

    @EJB
    private NegocioEventos negocioe;

    @EJB
    private Negocio negocio;

    private Eventos evento;

    @Inject
    private ControlAutorizacion ctrl;

    private List<Comentarios> comentarios;
    private String comentarionuevo;
    
    public Evento(){
        
    }
    public Eventos mostrarEvento(Eventos evento) throws LoginException {
        this.evento = negocioe.mostrarEvento(evento);
        return this.evento;
    }

    public List<String> participan() {
        List<String> grupos = new ArrayList<String>();
        List<GrupoScout> aux = evento.getListaGrupoScout();
        for (GrupoScout gp : aux) {
            String aux2 = gp.getNombre_grupo();
            if (!grupos.contains(aux2)) {
                grupos.add(aux2);
            }
        }

        return grupos;
    }

    public Eventos getEvento() {
        return evento;
    }

    public String setEvento(Eventos evento) throws LoginException {
        this.evento = negocioe.mostrarEvento(evento);
        return "Evento.xhtml";
    }

    public List<Comentarios> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentarios> comentarios) {
        this.comentarios = comentarios;
    }

    public void asistir() throws LoginException {
        negocio.inscribirseEvento(ctrl.getUsuario(), evento);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Asistencia confirmada", "Asistencia confirmada"));
    }

    public String getComentarionuevo() {
        return comentarionuevo;
    }

    public void setComentarionuevo(String comentarionuevo) {
        this.comentarionuevo = comentarionuevo;
    }

    public String añadirComentario() throws LoginException {
        negocioe.añadirComentario(ctrl.getUsuario(), evento, comentarionuevo);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Comentario realizado", "Comentario realizado"));
        return null;
    }

    public List<Comentarios> obtenerComentarios() throws LoginException {
        comentarios = negocioe.obtenerCometariosEv(evento);
        return comentarios;
    }

    public NegocioEventos getNegocioe() {
        return negocioe;
    }

    public void setNegocioe(NegocioEventos negocioe) {
        this.negocioe = negocioe;
    }

    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }

}
