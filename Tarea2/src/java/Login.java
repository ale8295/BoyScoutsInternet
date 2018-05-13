
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;
import javax.servlet.http.HttpSession;

@Named(value = "login")
@RequestScoped
public class Login {

    private boolean logeado = false;
    private String usuario;
    private String contrasenia;
    private static List<Usuario> usuarios;
    FacesMessage msg = null;
    private boolean esta = false;

    @Inject
    private ControlAutorizacion ctrl;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        if (usuarios == null) {
            usuarios = new ArrayList<Usuario>();
            usuarios.add(new Usuario("pepe@hotmail.com", "1234", Usuario.Rol.NORMAL));
            usuarios.add(new Usuario("nico@hotmail.com", "1234", Usuario.Rol.ADMINISTRADOR));
            usuarios.add(new Usuario("hola", "123", Usuario.Rol.ADMINISTRADOR));

            // USUARIO PEPE
            usuarios.get(0).setNombre("Pepe");
            usuarios.get(0).setDni("55555555A");
            usuarios.get(0).setfNac("15/12/1967");
            usuarios.get(0).setfIng("05/04/2008");
            usuarios.get(0).setSexo("Hombre");
            usuarios.get(0).setDireccion("Malaga, España");
            usuarios.get(0).setTlf("555 222 999");
            usuarios.get(0).setGrupo("Ardillas");
            usuarios.get(0).setImg("resources/images/imagen2.jpg");
            //---------------------------------------------

            // USUARIO NICO
            usuarios.get(1).setNombre("Nico");
            usuarios.get(1).setDni("66666666B");
            usuarios.get(1).setfNac("31/01/1995");
            usuarios.get(1).setfIng("09/10/2010");
            usuarios.get(1).setSexo("Hombre");
            usuarios.get(1).setDireccion("Malaga, España");
            usuarios.get(1).setTlf("666 888 444");
            usuarios.get(1).setGrupo("Castores");
            usuarios.get(1).setImg("resources/images/perro.jpg");
            //---------------------------------------------
        }
    }

    public static void meterUser(Usuario usu) {
        usuarios.add(usu);
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public boolean estaLogeado() {
        return logeado;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }



    public String autenticar() {
        // Implementar este método
        if(ctrl.getUsuario() != null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ya hay un usuario conectado.", "Loging info"));
            return "signin.xhtml";
        }
        String errorr = "";
        String inf = "";
        Iterator<Usuario> it = usuarios.iterator();

        while (it.hasNext() && !esta) {
            Usuario usu = it.next();
            if (usu.getUsuario().equals(usuario) && usu.getContrasenia().equals(contrasenia)) {
                ctrl.setUsuario(usu);
                logeado = true;
                errorr = "Bienvenid@";
                inf = usu.getUsuario();
                esta = true;
            }
        }
        if (!esta) {
            logeado = false;
            errorr = "EMAIL O CONTRASEÑA INCORRECTAS";
            inf = "Credenciales no válidas";
        }

        if (logeado == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, errorr, inf));

            return "index.xhtml";

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, errorr, inf));
            return "signin.xhtml";
        }
    }

    public String comprobarCampos() {
        String user = getUsuario();
        String passw = getContrasenia();
        String err = "";
        String error = "";
        int cont = 0;

        if (user.equals("") || passw.equals("")) {
            if (user.equals("")) {
                err = " usuario";
                cont++;
            }

            if (passw.equals("")) {
                if (cont > 0) {
                    err = err + ", contraseña";
                } else {
                    err = err + "contraseña";
                }
                cont++;
            }

            if (cont == 1) {
                error = "El campo " + err + " es obligatorio.";
            } else {
                error = "Los campos " + err + " son obligatorios.";
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, error, error));
            return "signin.xhtml";
        } else {
            return autenticar();
        }
    }
}
