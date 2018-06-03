/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Comentarios;
import entidades.Eventos;
import entidades.HistorialEventos;
import entidades.Usuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author User
 */
@Local
public interface NegocioEventos {
    public void registrarEvento(Eventos ev,List<String> grupos) throws LoginException;
    public List<Eventos> listaEventos();
    public void modificarEvento(Eventos ev) throws LoginException;
    public Eventos mostrarEvento(Eventos ev) throws LoginException;
    public List<Eventos> busEventos(String busqueda, String busquedafecha);
    public void añadirComentario(Usuarios usu, Eventos ev,String evento) throws LoginException;
    public List<Comentarios> obtenerCometariosEv(Eventos ev) throws LoginException;
    public List<Comentarios> obtenerCometariosUsu(Usuarios usu) throws LoginException;
  
}