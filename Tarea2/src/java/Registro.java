/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "registro")
@RequestScoped
public class Registro implements Serializable {

    private Usuario registrationUser;

    public Registro() {
        if(registrationUser == null)
            registrationUser = new Usuario();
    }

    public Usuario getRegistrationUser() {
        return registrationUser;
    }

    public void setRegistrationUser(Usuario registrationUser) {
        this.registrationUser = registrationUser;
    }

    public String register() {
        String user = registrationUser.getUsuario();
        String passw = registrationUser.getContrasenia();
        String passw2 = registrationUser.getContrasenia2();
        String nom = registrationUser.getNombre();
        String email = registrationUser.getEmail();
        String dni = registrationUser.getDni();
        String fechaN = registrationUser.getfNac();
        String err = "";
        String error = "";
        int cont = 0;

        if (user.equals("") || passw.equals("") || passw2.equals("") || nom.equals("") || email.equals("") || fechaN.equals("") || dni.equals("")) {
            if (user.equals("")) {
                err = " usuario";
                cont++;
            }

            if (passw.equals("") || passw2.equals("")) {
                if (cont > 0) {
                    err = err + ", contraseña";
                } else {
                    err = err + "contraseña";
                }
                cont++;
            }

            if (nom.equals("")) {
                if (cont > 0) {
                    err = err + ", nombre";
                } else {
                    err = err + "nombre";
                }
                cont++;
            }

            if (email.equals("")) {
                if (cont > 0) {
                    err = err + ", email";
                } else {
                    err = err + "email";
                }
                cont++;
            }

            if (fechaN.equals("")) {
                if (cont > 0) {
                    err = err + ", fecha de nacimiento";
                } else {
                    err = err + "fecha de nacimiento";
                }
                cont++;
            }
            if (dni.equals("")) {
                if (cont > 0) {
                    err = err + ", dni";
                } else {
                    err = err + "dni";
                }
                cont++;
            }
            if (cont == 1) {
                error = "El campo " + err + " es obligatorio.";
            } else {
                error = "Los campos " + err + " son obligatorios.";
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, error, error));
            return "Registro.xhtml";
        } else {
            if (noCoinciden(passw, passw2)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Las contraseñas no coinciden", "Password error"));
                return "Registro.xhtml";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario registrado correctamente", "Registration Info"));
                registrationUser.setRol(Usuario.Rol.NORMAL);
                Login.meterUser(registrationUser);
                return "signin.xhtml";
            }
        }
    }

    public boolean noCoinciden(String passw, String passw2) {
        if (passw.equals(passw2)) {
            return false;
        } else {
            return true;
        }

    }

}
