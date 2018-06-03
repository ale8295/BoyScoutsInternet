package entidades;

import entidades.Usuarios;
import java.io.File;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-03T23:19:51")
@StaticMetamodel(Documentacion.class)
public class Documentacion_ { 

    public static volatile SingularAttribute<Documentacion, String> estado;
    public static volatile SingularAttribute<Documentacion, File> documento;
    public static volatile SingularAttribute<Documentacion, Usuarios> usuario;
    public static volatile SingularAttribute<Documentacion, Long> cod_documento;
    public static volatile SingularAttribute<Documentacion, String> comentario;
    public static volatile SingularAttribute<Documentacion, String> url;

}