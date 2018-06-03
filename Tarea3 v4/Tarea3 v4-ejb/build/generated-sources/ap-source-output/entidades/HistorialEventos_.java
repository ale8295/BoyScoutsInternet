package entidades;

import entidades.Eventos;
import entidades.HistorialEventosId;
import entidades.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-03T23:19:51")
@StaticMetamodel(HistorialEventos.class)
public class HistorialEventos_ { 

    public static volatile SingularAttribute<HistorialEventos, Eventos> evento;
    public static volatile SingularAttribute<HistorialEventos, HistorialEventosId> id_eventos;
    public static volatile SingularAttribute<HistorialEventos, String> valoracion;
    public static volatile SingularAttribute<HistorialEventos, Usuarios> usuario;

}