package entidades;

import entidades.Eventos;
import entidades.Scouter;
import entidades.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-03T23:19:51")
@StaticMetamodel(GrupoScout.class)
public class GrupoScout_ { 

    public static volatile SingularAttribute<GrupoScout, Long> id_grupo;
    public static volatile SingularAttribute<GrupoScout, Scouter> scouter;
    public static volatile ListAttribute<GrupoScout, Eventos> listaEventos;
    public static volatile SingularAttribute<GrupoScout, Usuarios> usuario;
    public static volatile SingularAttribute<GrupoScout, String> nombre_grupo;

}