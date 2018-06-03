package entidades;

import entidades.Comentarios;
import entidades.GrupoScout;
import entidades.HistorialEventos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-03T23:19:51")
@StaticMetamodel(Eventos.class)
public class Eventos_ { 

    public static volatile SingularAttribute<Eventos, String> descripcion;
    public static volatile SingularAttribute<Eventos, String> recomendaciones;
    public static volatile SingularAttribute<Eventos, Long> id_evento;
    public static volatile SingularAttribute<Eventos, String> lugar;
    public static volatile ListAttribute<Eventos, GrupoScout> listaGrupoScout;
    public static volatile SingularAttribute<Eventos, String> nombre;
    public static volatile SingularAttribute<Eventos, String> fecha;
    public static volatile SingularAttribute<Eventos, String> inscripcion;
    public static volatile SingularAttribute<Eventos, String> asistencia;
    public static volatile ListAttribute<Eventos, HistorialEventos> listaHistorial;
    public static volatile SingularAttribute<Eventos, Integer> duracion;
    public static volatile SingularAttribute<Eventos, String> rutaImagen;
    public static volatile ListAttribute<Eventos, Comentarios> listaComentarios;

}