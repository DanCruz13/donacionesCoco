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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dan Aurelio
 */
@Entity
@Table(name = "usuario_donaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioDonaciones.findAll", query = "SELECT u FROM UsuarioDonaciones u")
    , @NamedQuery(name = "UsuarioDonaciones.findByIdusuarioDonaciones", query = "SELECT u FROM UsuarioDonaciones u WHERE u.idusuarioDonaciones = :idusuarioDonaciones")
    , @NamedQuery(name = "UsuarioDonaciones.findByIdUsuario", query = "SELECT u FROM UsuarioDonaciones u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "UsuarioDonaciones.findByIdObjetosUsuario", query = "SELECT u FROM UsuarioDonaciones u WHERE u.idObjetosUsuario = :idObjetosUsuario")})
public class UsuarioDonaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuario_donaciones")
    private Integer idusuarioDonaciones;
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "id_objetos_usuario")
    private Integer idObjetosUsuario;

    public UsuarioDonaciones() {
    }

    public UsuarioDonaciones(Integer idusuarioDonaciones) {
        this.idusuarioDonaciones = idusuarioDonaciones;
    }

    public Integer getIdusuarioDonaciones() {
        return idusuarioDonaciones;
    }

    public void setIdusuarioDonaciones(Integer idusuarioDonaciones) {
        this.idusuarioDonaciones = idusuarioDonaciones;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdObjetosUsuario() {
        return idObjetosUsuario;
    }

    public void setIdObjetosUsuario(Integer idObjetosUsuario) {
        this.idObjetosUsuario = idObjetosUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuarioDonaciones != null ? idusuarioDonaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioDonaciones)) {
            return false;
        }
        UsuarioDonaciones other = (UsuarioDonaciones) object;
        if ((this.idusuarioDonaciones == null && other.idusuarioDonaciones != null) || (this.idusuarioDonaciones != null && !this.idusuarioDonaciones.equals(other.idusuarioDonaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.UsuarioDonaciones[ idusuarioDonaciones=" + idusuarioDonaciones + " ]";
    }
    
}
