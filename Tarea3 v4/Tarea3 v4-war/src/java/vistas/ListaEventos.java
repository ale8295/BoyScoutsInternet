/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import entidades.Eventos;
import entidades.GrupoScout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import negocio.LoginException;
import negocio.NegocioEventos;

/**
 *
 * @author User
 */
@Named(value = "listaEvento")
@RequestScoped
public class ListaEventos implements Serializable {

    @EJB
    private NegocioEventos negocioe;

    private List<Eventos> eventos;
    private String busqueda;
    private String busquedafecha;
    private List<Eventos> listSearch;
    private Evento eventovista;
    private Eventos evento;
    private Eventos eventoMostrar;
    
    public ListaEventos(){
        eventovista = new Evento();
    }
    
    public List<Eventos> conseguirEventos() {
        eventos = negocioe.listaEventos();
        return eventos;
    }

    public String mostrarEventovista(Eventos ev) throws LoginException {
        eventovista.setEvento(ev);
        return "Evento.xhtml";
    }
    
    public String buscar() {
        if (!busqueda.equalsIgnoreCase("") || !busquedafecha.equalsIgnoreCase("")) {
            listSearch = negocioe.busEventos(busqueda, busquedafecha);
        } else {
            listSearch = null;
        }
        return "ListaEventos.xhtml";
    }
    
    public List<String> participan(){
        List<String> grupos = new ArrayList<String>();
        for(Eventos ev : eventos){
           List<GrupoScout> aux = ev.getListaGrupoScout();
           for(GrupoScout gp : aux){
              String aux2 = gp.getNombre_grupo();
              if(!grupos.contains(aux2)){
                  grupos.add(aux2);
              }
           }
        }
        
        return grupos;
    }
    
    public List<Eventos> getEventos() {
        return eventos;
    }

    public void setEventos(List<Eventos> eventos) {
        this.eventos = eventos;
    }

    
    
    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public List<Eventos> getListSearch() {
        return listSearch;
    }

    public void setListSearch(List<Eventos> listSearch) {
        this.listSearch = listSearch;
    }

    public Evento getEventovista() {
        return eventovista;
    }

    public void setEventovista(Evento eventovista) {
        this.eventovista = eventovista;
    }

    public Eventos getEvento() {
        return evento;
    }

    public void setEvento(Eventos evento) {
        this.evento = evento;
    }

    public Eventos getEventoMostrar() {
        return eventoMostrar;
    }

    public void setEventoMostrar(Eventos eventoMostrar) {
        this.eventoMostrar = eventoMostrar;
    }  

    public NegocioEventos getNegocioe() {
        return negocioe;
    }

    public void setNegocioe(NegocioEventos negocioe) {
        this.negocioe = negocioe;
    }

    public String getBusquedafecha() {
        return busquedafecha;
    }

    public void setBusquedafecha(String busquedafecha) {
        this.busquedafecha = busquedafecha;
    }
    
}
