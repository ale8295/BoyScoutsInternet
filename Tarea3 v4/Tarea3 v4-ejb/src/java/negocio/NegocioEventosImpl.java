/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Comentarios;
import entidades.ComentariosId;
import entidades.Eventos;
import entidades.GrupoScout;
import entidades.HistorialEventos;
import entidades.Usuarios;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author User
 */
@Stateless
public class NegocioEventosImpl implements NegocioEventos {

    @PersistenceContext(unitName = "Tarea3PU")
    private EntityManager em;

    @Override
    public void registrarEvento(Eventos ev, List<String> grupos) throws LoginException {
        Query q = em.createQuery("SELECT count(e) FROM Eventos e");
        Number result = (Number) q.getSingleResult();
        Long clave = result.longValue() + (new Long(1));
        ev.setId_evento(clave);
        Eventos evento = em.find(Eventos.class, ev.getId_evento());
        if (evento != null) {
            throw new EventoExistenteException();
        }
        //ev.setListaGrupoScout(participan(grupos));
        ev.setRutaImagen("resources/images/"+clave.intValue()%7+".jpg");
        em.persist(ev);
    }

    public List<GrupoScout> participan(List<String> grupos) {
        Iterator it = grupos.iterator();
        List<List<GrupoScout>> aux2 = new ArrayList<List<GrupoScout>>();
        List<GrupoScout> list = new ArrayList<GrupoScout>();
        while (it.hasNext()) {
            String aux = it.next().toString();
            Query q = em.createQuery("SELECT g FROM GrupoScout g WHERE g.nombre_grupo=?1");
            q.setParameter(1, aux);
            aux2.add(q.getResultList());

        }
        for (List<GrupoScout> aux3 : aux2) {
            for (GrupoScout aux4 : aux3) {
                list.add(aux4);
            }
        }
        return list;
    }

    @Override
    public List<Eventos> listaEventos() {
        TypedQuery<Eventos> query;
        query = em.createNamedQuery("lista.eventos", Eventos.class);
        return query.getResultList();
    }

    @Override
    public void modificarEvento(Eventos ev) throws LoginException {
        Eventos evento = em.find(Eventos.class, ev.getId_evento());
        if (evento != null) {
            em.merge(ev);
        }
    }

    @Override
    public Eventos mostrarEvento(Eventos ev) throws LoginException {
        Eventos evento = em.find(ev.getClass(), ev.getId_evento());
        em.refresh(evento);
        return evento;
    }

    @Override
    public List<Eventos> busEventos(String busqueda, String busquedafecha) {
        List<Eventos> eventos = new ArrayList<Eventos>();
        if (!busqueda.equalsIgnoreCase("") && busquedafecha.equalsIgnoreCase("")) {
            Query q = em.createQuery("SELECT e FROM Eventos e WHERE e.nombre=?1");
            q.setParameter(1, busqueda);
            eventos = q.getResultList();
        } else if (busqueda.equalsIgnoreCase("") && !busquedafecha.equalsIgnoreCase("")) {
            Query q = em.createQuery("SELECT e FROM Eventos e WHERE e.fecha=?1");
            q.setParameter(1, busquedafecha);
            eventos = q.getResultList();
        } else {
            //(!busqueda.equalsIgnoreCase("") && !busquedafecha.equalsIgnoreCase("")) 
            Query q = em.createQuery("SELECT e FROM Eventos e WHERE e.nombre=?1 AND e.fecha=?2");
            q.setParameter(1, busqueda);
            q.setParameter(2, busquedafecha);
            eventos = q.getResultList();

        }

        return eventos;
    }

    @Override
    public List<Comentarios> obtenerCometariosEv(Eventos ev) throws LoginException {
        Eventos evento = em.find(ev.getClass(), ev.getId_evento());
        if (evento != null) {

            Query query;
            query = em.createQuery("SELECT c FROM Comentarios c WHERE c.evento=?1");
            query.setParameter(1, ev);
            return query.getResultList();
        }

        return null;
    }

    @Override
    public List<Comentarios> obtenerCometariosUsu(Usuarios usu) throws LoginException {
        Usuarios user = em.find(usu.getClass(), usu.getUsuario());
        if (user != null) {

            Query query;
            query = em.createQuery("SELECT c FROM Comentarios c WHERE c.usuario=?1");
            query.setParameter(1, usu);
            return query.getResultList();
        }

        return null;
    }

     @Override
    public void añadirComentario(Usuarios usu, Eventos ev, String comentario) throws LoginException {
        List<Comentarios> aux = obtenerCometariosEv(ev);
        List<Comentarios> aux2 = obtenerCometariosUsu(usu);
        if(aux == null){
            aux = new ArrayList<Comentarios>();
        }
        if(aux2 == null){
            aux2 = new ArrayList<Comentarios>();
        }
        Comentarios aux3 = new Comentarios();
        ComentariosId aux4 = new ComentariosId();
        aux4.setUsuario(usu.getUsuario());
        aux4.setId_evento(ev.getId_evento());
        Query q = em.createQuery("SELECT count(e) FROM Comentarios e");
        Number result = (Number) q.getSingleResult();
        Long clave = result.longValue() + (new Long(1));
        aux4.setId_comentario(clave);
        aux3.setId_comentario(aux4);
        aux3.setUsuario(usu);
        aux3.setEvento(ev);
        aux3.setFecha(LocalDate.now().toString());
        aux3.setDescripcion(comentario);
        aux.add(aux3);
        aux2.add(aux3);
        ev.setListaComentarios(aux);
        usu.setListaComentarios(aux2);
        em.merge(ev);
        em.merge(usu);
        em.merge(aux3);
    }

}
