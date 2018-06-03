package vistas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pepe
 */
import entidades.Eventos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.text.ParseException;

@ManagedBean(name = "BasicView")
@ViewScoped
public class BasicView implements Serializable {

    private List<Eventos> eventos;
    private List<Eventos> listSearch;
    @ManagedProperty("#{eventoService}")
    private EventoService service;
    private Eventos evento;

    public void buscar() throws ParseException {
        service.buscarEvento();
        setListSearch(service.getListSearch());
    }

    @PostConstruct
    public void init() {
        eventos = service.getEventos();
    }


    public List<Eventos> getEventos() {
        return eventos;
    }

    public void setEventos(List<Eventos> eventos) {
        this.eventos = eventos;
    }

    public List<Eventos> getListSearch() {
        return listSearch;
    }

    public void setListSearch(List<Eventos> listSearch) {
        this.listSearch = listSearch;
    }

    public EventoService getService() {
        return service;
    }

    public void setService(EventoService service) {
        this.service = service;
    }

    public Eventos getEvento() {
        return evento;
    }

    public void setEvento(Eventos evento) {
        this.evento = evento;
    }

}
