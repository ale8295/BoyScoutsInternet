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
import entidades.GrupoScout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
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
    private List<String> grupos = new ArrayList<String>();

    private List<String> nomgrupos;

    //Inicializar lista de eventos principal.
    private List<Eventos> list = new ArrayList<Eventos>();
    private final static String[] nombres;
    private final static String[] lugares;
    private final static Date[] fechas;
    private final static String[] informaciones;
    //Id para cada evento
    private int contid;
    private int cont = 1;
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
        fechas[1] = new Date("5/7/2018");
        fechas[2] = new Date("3/3/2018");

        informaciones[0] = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. ";
        informaciones[1] = "Hola hola xd";
        informaciones[2] = "Los buenos montes ae";

    }

    public List<Eventos> crearEventos() {

        for (int i = 0; i < 3; i++) {
            Eventos ev = new Eventos();
            ev.setId_evento((long) i);
            ev.setNombre(nombres[i]);
            ev.setFecha(fechas[i]);
            ev.setLugar(lugares[i]);
            ev.setDescripcion(informaciones[i]);
            List<GrupoScout> lista = new ArrayList<GrupoScout>();
            ev.setListaGrupoScout(lista);
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
        ev.setFecha(new SimpleDateFormat("dd-MM-yyyy").parse(fecha));
        ev.setLugar(lugar);
        ev.setId_evento((long) contid);
        ev.setRutaImagen("resources/images/perro.jpg");

        ev.setListaGrupoScout(participaGrupo());
        list.add(ev);
        contid++;

        return "ListaEventos.xhtml";
    }

    public List<GrupoScout> participaGrupo() {
        List<GrupoScout> list = new ArrayList<GrupoScout>();
        Iterator it = grupos.iterator();
        String aux;
        long id = 1;
        while (it.hasNext()) {
            GrupoScout gp = new GrupoScout();
            aux = it.next().toString();
            if (aux.equals("Castores")) {
                gp.setId_grupo(id);
                gp.setNombre_grupo(aux);
                list.add(gp);
            } else if (aux.equals("Lobatos")) {
                gp.setId_grupo(id);
                gp.setNombre_grupo(aux);
                list.add(gp);
            } else if (aux.equals("Scouts")) {
                gp.setId_grupo(id);
                gp.setNombre_grupo(aux);
                list.add(gp);
            } else if (aux.equals("Escultas")) {
                gp.setId_grupo(id);
                gp.setNombre_grupo(aux);
                list.add(gp);
            } else if (aux.equals("Rovers")) {
                gp.setId_grupo(id);
                gp.setNombre_grupo(aux);
                list.add(gp);
            } else if (aux.equals("Scouters de apoyo")) {
                gp.setId_grupo(id);
                gp.setNombre_grupo(aux);
                list.add(gp);
            }
            id++;
        }
        return list;
    }

    public void buscarEvento() throws ParseException {
        listSearch = new ArrayList<Eventos>();
        for (Eventos ev : list) {
            String lugar = ev.getLugar();
            String nombre = ev.getNombre();
            if (!palabraSearch.equals("") && (fechaSearch.equals(""))) {
                
                if (nombre.equalsIgnoreCase(palabraSearch)|| lugar.equalsIgnoreCase(palabraSearch)) {
                    listSearch.add(ev);
                }
                List<GrupoScout> listaBus = ev.getListaGrupoScout();
                if (listaBus.isEmpty() == false) {
                    for (GrupoScout gp : listaBus) {
                        if (gp.getNombre_grupo().equalsIgnoreCase(palabraSearch) && !gp.getNombre_grupo().equals("")) {
                            listSearch.add(ev);
                        }
                    }
                }
            }
            if (!fechaSearch.equals("") && (palabraSearch.equals(""))) {
                Date fechabus = new SimpleDateFormat("dd-MM-yyyy").parse(fechaSearch);
                if (ev.getFecha().toString().equals(fechabus.toString())) {
                    listSearch.add(ev);
                }
            }

            if (!fechaSearch.equals("") && !palabraSearch.equals("")) {
                if (nombre.equalsIgnoreCase(palabraSearch)|| lugar.equalsIgnoreCase(palabraSearch)) {
                    Date fechabus = new SimpleDateFormat("dd-MM-yyyy").parse(fechaSearch);
                    if (ev.getFecha().toString().equals(fechabus.toString())) {
                        listSearch.add(ev);
                    }
                }

                List<GrupoScout> listaBus = ev.getListaGrupoScout();
                if (listaBus.isEmpty() == false) {
                    for (GrupoScout gp : listaBus) {
                        if (gp.getNombre_grupo().equalsIgnoreCase(palabraSearch) && !gp.getNombre_grupo().equals("")) {
                            Date fechabus = new SimpleDateFormat("dd-MM-yyyy").parse(fechaSearch);
                            if (ev.getFecha().toString().equals(fechabus.toString())) {
                                listSearch.add(ev);
                            }
                        }
                    }
                }
            }
        }

        if (listSearch.isEmpty()) {
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
        if (cont == 1) {
            crearEventos();
            cont++;
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

    public List<String> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<String> grupos) {
        this.grupos = grupos;
    }
}
