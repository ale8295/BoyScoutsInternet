package entidades;

import entidades.PermisosId;
import entidades.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-03T23:19:50")
@StaticMetamodel(Permisos.class)
public class Permisos_ { 

    public static volatile SingularAttribute<Permisos, Boolean> leer;
    public static volatile SingularAttribute<Permisos, Boolean> escribir;
    public static volatile SingularAttribute<Permisos, PermisosId> id_permiso;
    public static volatile SingularAttribute<Permisos, Boolean> subirDoc;
    public static volatile SingularAttribute<Permisos, Boolean> adminTienda;
    public static volatile SingularAttribute<Permisos, Usuarios> usuario;
    public static volatile SingularAttribute<Permisos, Boolean> gestion;

}