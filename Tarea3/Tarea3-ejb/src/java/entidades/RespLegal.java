/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


@Entity
public class RespLegal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String dni;
    
    @JoinColumn (nullable = false)
    private String nombre;
    
    @JoinColumn (nullable = false)
    private String apellidos;
    
    @JoinColumn (nullable = false)
    private String email;
    
    
    @OneToMany
    @JoinColumn (nullable = false)
    private List<Socios> listSocios;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Socios> getListSocios() {
        return listSocios;
    }

    public void setListSocios(List<Socios> listSocios) {
        this.listSocios = listSocios;
    }

   
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RespLegal)) {
            return false;
        }
        RespLegal other = (RespLegal) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarea1.RespLegal[ id=" + dni + " ]";
    }
    
}
