/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Eventos;
import entidades.GrupoScout;
import entidades.HistorialEventos;
import entidades.HistorialEventosId;
import entidades.Usuarios;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class NegocioImpl implements Negocio {

    @PersistenceContext(unitName = "Tarea3PU")
    private EntityManager em;

    @Override
    public void registrarUsuario(Usuarios usu) throws LoginException {

        Usuarios user = em.find(Usuarios.class, usu.getUsuario());
        Query q = em.createQuery("SELECT count(c) FROM Usuarios c");
        Number result = (Number) q.getSingleResult();
        if(result.intValue() == 0){
            usu.setRol("ADMINISTRADOR");
        }else{
            usu.setRol("EDUCANDO");
        }
        usu.setRutaFoto("resources/images/3.jpg");
        if (user != null) {
            throw new CuentaRepetidaException();
        }
        LocalDate hoy = LocalDate.now();
        usu.setFecha_ingreso(hoy.toString());
        em.persist(usu);
    }

    @Override
    public void compruebaLogin(Usuarios usu) throws LoginException {
        Usuarios user = em.find(usu.getClass(), usu.getUsuario());
        if (user != null) {
            if (!user.getContrasena().equals(usu.getContrasena()) || !user.getUsuario().equalsIgnoreCase(usu.getUsuario())) {
                throw new ContraseniaInvalidaException();
            }
        } else {
            throw new CuentaInexistenteException();
        }
    }

    @Override
    public Usuarios refrescarUsuario(Usuarios usu) throws LoginException {
        compruebaLogin(usu);
        Usuarios user = em.find(usu.getClass(), usu.getUsuario());
        em.refresh(user);
        return user;
    }

    @Override
    public void modificar(Usuarios usu) throws LoginException {
        
        em.merge(usu);

    }

    @Override
    public void insertar(Usuarios usu) throws LoginException {
        compruebaLogin(usu);
        em.persist(usu);
    }

    @Override
    public List<HistorialEventos> obtenerHistorialEventosUsu(Usuarios usu) throws LoginException {
        Usuarios usuario = em.find(usu.getClass(), usu.getUsuario());
        if (usuario != null) {

            Query q = em.createQuery("SELECT e FROM HistorialEventos e WHERE e.usuario=?1");
            q.setParameter(1, usu);
            return q.getResultList();
        }

        return null;
    }

    @Override
    public void inscribirseEvento(Usuarios usu, Eventos ev) throws LoginException {
        List<HistorialEventos> aux = obtenerHistorialEventosUsu(usu);
        if (aux == null) {
            aux = new ArrayList<HistorialEventos>();
        }
        HistorialEventos aux3 = new HistorialEventos();
        HistorialEventosId aux4 = new HistorialEventosId();
        aux3.setUsuario(usu);
        aux3.setEvento(ev);
        aux4.setId_evento(ev.getId_evento());
        aux4.setUsuario(usu.getUsuario());
        aux3.setId_eventos(aux4);
        aux.add(aux3);
        usu.setHistorialEventos(aux);
        ev.setAsistencia(ev.getAsistencia() + " " + usu.getNombre() + " " + usu.getApellidos() + ",");
        em.merge(ev);
        em.merge(usu);
    }

}
