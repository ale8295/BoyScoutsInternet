package entidades;

import entidades.Comentarios;
import entidades.Cuotas;
import entidades.Documentacion;
import entidades.GrupoScout;
import entidades.HistorialEventos;
import entidades.Permisos;
import entidades.RespLegal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-03T23:19:51")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> apellidos;
    public static volatile ListAttribute<Usuarios, Permisos> listaPermisos;
    public static volatile SingularAttribute<Usuarios, GrupoScout> grupoScout;
    public static volatile SingularAttribute<Usuarios, String> fecha_nacimiento;
    public static volatile SingularAttribute<Usuarios, String> grupo;
    public static volatile SingularAttribute<Usuarios, String> nombre;
    public static volatile SingularAttribute<Usuarios, String> rol;
    public static volatile SingularAttribute<Usuarios, RespLegal> respLegal;
    public static volatile SingularAttribute<Usuarios, String> numContacto;
    public static volatile ListAttribute<Usuarios, HistorialEventos> historialEventos;
    public static volatile SingularAttribute<Usuarios, String> usuario;
    public static volatile SingularAttribute<Usuarios, String> contrasena;
    public static volatile ListAttribute<Usuarios, Cuotas> listaCuotas;
    public static volatile SingularAttribute<Usuarios, String> fecha_ingreso;
    public static volatile SingularAttribute<Usuarios, String> sexo;
    public static volatile SingularAttribute<Usuarios, String> rutaFoto;
    public static volatile SingularAttribute<Usuarios, Documentacion> documentacion;
    public static volatile SingularAttribute<Usuarios, String> dni;
    public static volatile ListAttribute<Usuarios, Comentarios> listaComentarios;
    public static volatile SingularAttribute<Usuarios, String> email;

}