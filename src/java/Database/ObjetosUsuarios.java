/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dan Aurelio
 */
@Entity
@Table(name = "objetos_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObjetosUsuarios.findAll", query = "SELECT o FROM ObjetosUsuarios o")
    , @NamedQuery(name = "ObjetosUsuarios.findByIdobjetosUsuarios", query = "SELECT o FROM ObjetosUsuarios o WHERE o.idobjetosUsuarios = :idobjetosUsuarios")
    , @NamedQuery(name = "ObjetosUsuarios.findByNombreObjeto", query = "SELECT o FROM ObjetosUsuarios o WHERE o.nombreObjeto = :nombreObjeto")
    , @NamedQuery(name = "ObjetosUsuarios.findByDescripcion", query = "SELECT o FROM ObjetosUsuarios o WHERE o.descripcion = :descripcion")})
public class ObjetosUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idobjetos_usuarios")
    private Integer idobjetosUsuarios;
    @Size(max = 45)
    @Column(name = "nombre_objeto")
    private String nombreObjeto;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;

    public ObjetosUsuarios() {
    }

    public ObjetosUsuarios(Integer idobjetosUsuarios) {
        this.idobjetosUsuarios = idobjetosUsuarios;
    }

    public Integer getIdobjetosUsuarios() {
        return idobjetosUsuarios;
    }

    public void setIdobjetosUsuarios(Integer idobjetosUsuarios) {
        this.idobjetosUsuarios = idobjetosUsuarios;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idobjetosUsuarios != null ? idobjetosUsuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObjetosUsuarios)) {
            return false;
        }
        ObjetosUsuarios other = (ObjetosUsuarios) object;
        if ((this.idobjetosUsuarios == null && other.idobjetosUsuarios != null) || (this.idobjetosUsuarios != null && !this.idobjetosUsuarios.equals(other.idobjetosUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.ObjetosUsuarios[ idobjetosUsuarios=" + idobjetosUsuarios + " ]";
    }
    
}
