package entidades;

import entidades.ComentariosId;
import entidades.Eventos;
import entidades.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-03T23:19:51")
@StaticMetamodel(Comentarios.class)
public class Comentarios_ { 

    public static volatile SingularAttribute<Comentarios, String> descripcion;
    public static volatile SingularAttribute<Comentarios, String> fecha;
    public static volatile SingularAttribute<Comentarios, Eventos> evento;
    public static volatile SingularAttribute<Comentarios, Usuarios> usuario;
    public static volatile SingularAttribute<Comentarios, ComentariosId> id_comentario;

}