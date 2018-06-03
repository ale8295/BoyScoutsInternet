/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Eventos;
import entidades.GrupoScout;
import entidades.HistorialEventos;
import entidades.Usuarios;
import java.text.ParseException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author User
 */
@Local
public interface Negocio {
    public void registrarUsuario(Usuarios user)throws LoginException;   
    public void compruebaLogin(Usuarios user) throws LoginException;
    public Usuarios refrescarUsuario(Usuarios user) throws LoginException;
    public void modificar(Usuarios user) throws LoginException;
    public void insertar(Usuarios user)throws LoginException;
    public List<HistorialEventos> obtenerHistorialEventosUsu (Usuarios usu) throws LoginException;
    public void inscribirseEvento(Usuarios usu, Eventos ev) throws LoginException;
}
