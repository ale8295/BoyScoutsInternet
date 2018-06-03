/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import entidades.Eventos;
import entidades.GrupoScout;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import negocio.LoginException;
import negocio.NegocioEventos;
import negocio.NegocioEventosImpl;

/**
 *
 * @author User
 */
@Named(value = "eventoService")
@RequestScoped
public class EventoService {   
    
    @EJB
    private NegocioEventos negocioe;
    
    private Eventos evento;
    private List<String> grupos = new ArrayList<String>();
    private List<String> nomgrupos = new ArrayList<String>();
    
    public EventoService(){
        evento = new Eventos();
    }

    
    public String actEventos() throws ParseException, LoginException {
        if(!evento.getNombre().equals("") && !evento.getLugar().equals("") && !evento.getFecha().equals("") && grupos !=null && !evento.getDescripcion().equals("")){      
        negocioe.registrarEvento(evento, grupos);
        return "ListaEventos.xhtml";
        }else{
            if(evento.getNombre().equals("")){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El campo nombre es obligatorio", "El campo nombre es obligatorio"));
            }
            
            if(evento.getDescripcion().equals("")){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El campo descripcion es obligatorio", "El campo descripcion es obligatorio"));
            }
            
            if(evento.getLugar().equals("")){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El campo lubar es obligatorio", "El campo lugar es obligatorio"));
            }
            
            if(grupos == null){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El campo grupos es obligatorio", "El campo grupos es obligatorio"));
            }
            
            if(evento.getFecha().equals("")){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El campo fecha es obligatorio", "El campo fecha es obligatorio"));
            }
        }
        return null;
    }

    public List<String> participaGrupo() {
        List<String> list = new ArrayList<String>();
        Iterator it = grupos.iterator();
        String aux;
        long id = 1;
        while (it.hasNext()) {
            String gp="";
            aux = it.next().toString();
            if (aux.equals("Castores")) {
                list.add(gp);
            } else if (aux.equals("Lobatos")) {
                list.add(gp);
            } else if (aux.equals("Scouts")) {
                list.add(gp);
            } else if (aux.equals("Escultas")) {
                list.add(gp);
            } else if (aux.equals("Rovers")) {
                list.add(gp);
            } else if (aux.equals("Scouters de apoyo")) {
                list.add(gp);
            }
            id++;
        }
        return list;
    }



    public List<String> getNomgrupos() {
        nomgrupos = new ArrayList<String>();
        nomgrupos.add("Castores");
        nomgrupos.add("Lobatos");
        nomgrupos.add("Scouts");
        nomgrupos.add("Escultas");
        nomgrupos.add("Rovers");
        nomgrupos.add("Scouters de apoyo");
        return nomgrupos;
    }

    public void setNomgrupos(List<String> nomgrupos) {
        nomgrupos = new ArrayList<String>();
        nomgrupos.add("Castores");
        nomgrupos.add("Lobatos");
        nomgrupos.add("Scouts");
        nomgrupos.add("Escultas");
        nomgrupos.add("Rovers");
        nomgrupos.add("Scouters de apoyo");
        this.nomgrupos = nomgrupos;
    }
    
    
    public Eventos getEvento() {
        return evento;
    }

    public void setEvento(Eventos evento) {
        this.evento = evento;
    }

    public List<String> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<String> grupos) {
        this.grupos = grupos;
    }



}
