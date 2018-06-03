/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import entidades.Usuarios;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import negocio.CuentaRepetidaException;
import negocio.LoginException;
import negocio.Negocio;

/**
 *
 * @author User
 */
@Named(value = "registro")
@RequestScoped
public class Registro {

    private String fnac;
    private Usuarios registrationUser;
    @EJB
    private Negocio negocio;
    private String passw2;

    public Registro() {
        registrationUser = new Usuarios();
        
    }

    public Usuarios getRegistrationUser() {
        return registrationUser;
    }

    public void setRegistrationUser(Usuarios registrationUser) {
        this.registrationUser = registrationUser;
    }

    public String getFnac() {
        return fnac;
    }

    public void setFnac(String fnac) {
        this.fnac = fnac;
    }

    public String registrarUsuario() throws ParseException {
        try {
            String err = "";
            String error = "";
            int cont = 0;

            if (registrationUser.getNombre().equals("")||registrationUser.getApellidos().equals("") || registrationUser.getContrasena().equals("") || passw2.equals("") || registrationUser.getUsuario().equals("") || registrationUser.getEmail().equals("") || fnac.equals("") || registrationUser.getDni().equals("") || registrationUser.getSexo().equals("") || registrationUser.getNumContacto().equals("")) {
                if (registrationUser.getNombre().equals("") || registrationUser.getApellidos().equals("")) {
                    err = " nombre";
                    cont++;
                }

                if (registrationUser.getContrasena().equals("") || passw2.equals("")) {
                    if (cont > 0) {
                        err = err + ", contraseña";
                    } else {
                        err = err + "contraseña";
                    }
                    cont++;
                }

                if (registrationUser.getUsuario().equals("")) {
                    if (cont > 0) {
                        err = err + ", usuario";
                    } else {
                        err = err + "usuario";
                    }
                    cont++;
                }

                if (registrationUser.getEmail().equals("")) {
                    if (cont > 0) {
                        err = err + ", email";
                    } else {
                        err = err + "email";
                    }
                    cont++;
                }

                if (fnac.equals("")) {
                    if (cont > 0) {
                        err = err + ", fecha de nacimiento";
                    } else {
                        err = err + "fecha de nacimiento";
                    }
                    cont++;
                }
                if (registrationUser.getDni().equals("")) {
                    if (cont > 0) {
                        err = err + ", dni";
                    } else {
                        err = err + "dni";
                    }
                    cont++;
                }

                if (registrationUser.getSexo().equals("")) {
                    if (cont > 0) {
                        err = err + ", sexo";
                    } else {
                        err = err + "sexo";
                    }
                    cont++;
                }

                if (registrationUser.getNumContacto().equals("")) {
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
                if (!registrationUser.getContrasena().equals(passw2)) {
                    FacesMessage fm = new FacesMessage("Las contraseñas deben coincidir");
                    FacesContext.getCurrentInstance().addMessage("registro:repass", fm);
                    return null;
                }
                
                registrationUser.setFecha_nacimiento(fnac);
                registrationUser.setGrupo(pertenece(registrationUser));
                negocio.registrarUsuario(registrationUser);                   
                return "signin.xhtml";
            }
        } catch (CuentaRepetidaException e) {
            FacesMessage fm = new FacesMessage("Existe un usuario con la misma cuenta");
            FacesContext.getCurrentInstance().addMessage("registro:user", fm);

        } catch (LoginException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getPassw2() {
        return passw2;
    }

    public void setPassw2(String passw2) {
        this.passw2 = passw2;
    }
    
    public String pertenece(Usuarios usu) throws ParseException {
        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha = LocalDate.parse(fnac, formatter);
        LocalDate fecha2 = LocalDate.parse(hoy.toString(),formatter);
        long edad = ChronoUnit.YEARS.between(fecha, fecha2); 
        if(edad<8 && edad>=6){
            return "Castores";
        }else if(edad>=8 && edad<11){
            return "Lobatos";
        }else if(edad>=11 && edad<14){
            return "Scouts";
        }else if(edad>=14 && edad<17){
            return "Escultas/Pioneros";
        }else if(edad>=17 && edad<21){
            return "Rovers/CompaÃ±eros";
        }else if(edad>=21){
            return "Scouters de apoyo";
        }else{
            return "No tiene edad suficiente para entrar a ningún grupo";
        }
    }
}
