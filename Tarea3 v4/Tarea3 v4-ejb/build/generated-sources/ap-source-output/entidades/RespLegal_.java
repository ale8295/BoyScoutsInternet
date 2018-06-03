package entidades;

import entidades.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-03T23:19:51")
@StaticMetamodel(RespLegal.class)
public class RespLegal_ { 

    public static volatile SingularAttribute<RespLegal, String> apellidos;
    public static volatile ListAttribute<RespLegal, Usuarios> listUsuarios;
    public static volatile SingularAttribute<RespLegal, String> nombre;
    public static volatile SingularAttribute<RespLegal, String> dni;
    public static volatile SingularAttribute<RespLegal, String> email;

}