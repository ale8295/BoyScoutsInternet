/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pepe
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import Tarea1.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
 
@ManagedBean(name = "eventoService")
@SessionScoped
public class EventoService {
    //Parametros para crear evento
    private String nombre;
    private String lugar;
    private String fecha;
    private String info;
    //Inicializar lista de eventos principal.
    private List<Eventos> list = new ArrayList<Eventos>();
    private final static String[] nombres;
    private final static String[] lugares;
    private final static Date[] fechas;
    private final static String[] informaciones;
    //Id para cada evento
    private int contid;
    private int cont=1;
    //Parametros para hacer las busquedas
    private String fechaSearch;
    private String palabraSearch;
    private List<Eventos> listSearch;
    
    
    static {
        nombres = new String[3];
        lugares = new String[3];
        fechas = new Date[3];
        informaciones = new String[3];
        
        nombres[0] = "Excursión";
        nombres[1] = "Acampada";
        nombres[2] = "Senderismo";
        
        lugares[0] = "Sierra Bermeja";
        lugares[1] = "A las cuevas";
        lugares[2] = "Montes de málaga";
        
        
        fechas[0] = new Date("3/9/2018");
        fechas[1]= new Date("5/7/2018");
        fechas[2]= new Date("3/3/2018");
        
        informaciones[0] = "Se visitarán las bonitas montañas socio";
        informaciones[1] = "Hola hola xd";
        informaciones[2] = "Los buenos montes ae";
        
    }
     
    public List<Eventos> crearEventos() {
        
        for(int i = 0 ; i < 3 ; i++) {
            Eventos ev = new Eventos();
            ev.setId_evento((long)i);
            ev.setNombre(nombres[i]);
            ev.setFecha(fechas[i]);
            ev.setLugar(lugares[i]);
            ev.setDescripcion(informaciones[i]);
            ev.setRutaImagen("resources/images/perro.jpg");
            list.add(ev);  
        }
        contid = 3;
        return list;
    }
    
    public String actEventos() throws ParseException {
        Eventos ev = new Eventos();
        ev.setNombre(nombre);
        ev.setDescripcion(info);
        //Fecha con formato dd/mm/yyyy
        ev.setFecha(new SimpleDateFormat("yyyy-mm-dd").parse(fecha));
        ev.setLugar(lugar);
        ev.setId_evento((long)contid);
        ev.setRutaImagen("resources/images/perro.jpg");
        list.add(ev);
        contid++;

        return "ListaEventos.xhtml";
    }
    public void buscarEvento() throws ParseException{
        listSearch = new ArrayList<Eventos>();
        for (Eventos ev : list){
            if(ev.getNombre().contains((CharSequence)palabraSearch) || ev.getLugar().contains((CharSequence)palabraSearch)){
                listSearch.add(ev);
            }
        }
        if(listSearch.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "No se han encontrado coincidencias.", "Error de búsqueda"));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Eventos> getList() {
        return list;
    }

    public void setList(List<Eventos> list) {
        this.list = list;
    }

    public int getContid() {
        return contid;
    }

    public void setContid(int contid) {
        this.contid = contid;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public String getFechaSearch() {
        return fechaSearch;
    }

    public void setFechaSearch(String fechaSearch) {
        this.fechaSearch = fechaSearch;
    }

    

    public String getPalabraSearch() {
        return palabraSearch;
    }

    public void setPalabraSearch(String palabraSearch) {
        this.palabraSearch = palabraSearch;
    }

    public List<Eventos> getListSearch() {
        return listSearch;
    }

    public void setListSearch(List<Eventos> listSearch) {
        this.listSearch = listSearch;
    }
    
    public List<Eventos> getEventos() {
        if(cont==1){
        crearEventos();
        cont++;
        }
        return list;
    }
   
}

