package vistas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "registro")
@RequestScoped
public class Registro implements Serializable {

    private Usuario registrationUser;
    private String nom;
    private String user;
    private String passw;
    private String passw2;
    private String emailreg;
    private String fechaN;
    private String dnireg;
    private String fechaI;
    private String sexo;
    private String tlf;

    public Registro() {
        if (registrationUser == null) {
            registrationUser = new Usuario();
        }
    }

    public Usuario getRegistrationUser() {
        return registrationUser;
    }

    public void setRegistrationUser(Usuario registrationUser) {
        this.registrationUser = registrationUser;
    }

    public String register() {
        String err = "";
        String error = "";
        int cont = 0;

        if (user.equals("") || passw.equals("") || passw2.equals("") || nom.equals("") || emailreg.equals("") || fechaN.equals("") || dnireg.equals("") || sexo.equals("") || tlf.equals("")) {
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

            if (emailreg.equals("")) {
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
            if (dnireg.equals("")) {
                if (cont > 0) {
                    err = err + ", dni";
                } else {
                    err = err + "dni";
                }
                cont++;
            }
            
            if (sexo.equals("")) {
                if (cont > 0) {
                    err = err + ", sexo";
                } else {
                    err = err + "sexo";
                }
                cont++;
            }
            
            if (tlf.equals("")) {
                if (cont > 0) {
                    err = err + ", número de contacto";
                } else {
                    err = err + "número de contacto";
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
                registrationUser.setDni(dnireg);
                registrationUser.setContrasenia(passw);
                registrationUser.setContrasenia2(passw2);
                registrationUser.setEmail(emailreg);
                registrationUser.setNombre(nom);
                registrationUser.setUsuario(user);
                registrationUser.setSexo(sexo);
                registrationUser.setfNac(fechaN);
                registrationUser.setTlf(tlf);
                LocalDate hoy = LocalDate.now();
                fechaI = hoy.toString();
                registrationUser.setfIng(hoy.toString());
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getPassw2() {
        return passw2;
    }

    public void setPassw2(String passw2) {
        this.passw2 = passw2;
    }

    public String getEmailreg() {
        return emailreg;
    }

    public void setEmailreg(String emailreg) {
        this.emailreg = emailreg;
    }

    public String getFechaN() {
        return fechaN;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    public String getDnireg() {
        return dnireg;
    }

    public void setDnireg(String dnireg) {
        this.dnireg = dnireg;
    }

    public String getFechaI() {
        return fechaI;
    }

    public void setFechaI(String fechaI) {
        this.fechaI = fechaI;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }


}
