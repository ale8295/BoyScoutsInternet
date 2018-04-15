/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea1;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author pepe
 */
@Entity
public class Documentacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cod_documento;
    private String estado;
    private String url;
    private String comentario;
    @OneToOne
    private Socios socio;
    
    public Long getCod_documento() {
        return cod_documento;
    }

    public void setCod_documento(Long cod_documento) {
        this.cod_documento = cod_documento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Socios getSocio() {
        return socio;
    }

    public void setSocio(Socios socio) {
        this.socio = socio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cod_documento != null ? cod_documento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the cod_documento fields are not set
        if (!(object instanceof Documentacion)) {
            return false;
        }
        Documentacion other = (Documentacion) object;
        if ((this.cod_documento == null && other.cod_documento != null) || (this.cod_documento != null && !this.cod_documento.equals(other.cod_documento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarea1.Documentacion[ id=" + cod_documento + " ]";
    }
    
}
