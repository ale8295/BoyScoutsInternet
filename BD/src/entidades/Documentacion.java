/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.File;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
public class Documentacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cod_documento;
    
    @Column (nullable = true)
    private String estado;
    
    @Column (nullable = true)
    private String url;
    
    @Column (nullable = true)
    private String comentario;
    
    @Column (nullable = false)
    private File documento;
    
    @OneToOne
    @JoinColumn (nullable = true)
    private Usuarios usuario;
    
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

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    

    

    public File getDocumento() {
        return documento;
    }

    public void setDocumento(File documento) {
        this.documento = documento;
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
