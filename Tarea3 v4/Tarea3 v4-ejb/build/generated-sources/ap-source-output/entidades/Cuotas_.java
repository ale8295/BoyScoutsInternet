package entidades;

import entidades.CuotaId;
import entidades.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-03T23:19:51")
@StaticMetamodel(Cuotas.class)
public class Cuotas_ { 

    public static volatile SingularAttribute<Cuotas, String> descripcion;
    public static volatile SingularAttribute<Cuotas, Usuarios> usuario;
    public static volatile SingularAttribute<Cuotas, Float> cantidad;
    public static volatile SingularAttribute<Cuotas, CuotaId> id_codigo;
    public static volatile SingularAttribute<Cuotas, String> fecha_pago;

}