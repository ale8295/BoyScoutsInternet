/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea1;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author pepe
 */
@Entity
public class Scouter extends Socios implements Serializable  {
    private String cargo;
    @OneToOne
    private GrupoScout grupoScout;
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public GrupoScout getGrupoScout() {
        return grupoScout;
    }

    public void setGrupoScout(GrupoScout grupoScout) {
        this.grupoScout = grupoScout;
    }
    
    
}
