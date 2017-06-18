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
@Table(name = "lista_donaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaDonaciones.findAll", query = "SELECT l FROM ListaDonaciones l")
    , @NamedQuery(name = "ListaDonaciones.findByIdlistaDonaciones", query = "SELECT l FROM ListaDonaciones l WHERE l.idlistaDonaciones = :idlistaDonaciones")
    , @NamedQuery(name = "ListaDonaciones.findByIdObjetos", query = "SELECT l FROM ListaDonaciones l WHERE l.idObjetos = :idObjetos")
    , @NamedQuery(name = "ListaDonaciones.findByDonadoPor", query = "SELECT l FROM ListaDonaciones l WHERE l.donadoPor = :donadoPor")
    , @NamedQuery(name = "ListaDonaciones.findByDonadoA", query = "SELECT l FROM ListaDonaciones l WHERE l.donadoA = :donadoA")})
public class ListaDonaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idlista_donaciones")
    private Integer idlistaDonaciones;
    @Column(name = "id_objetos")
    private Integer idObjetos;
    @Column(name = "donado_por")
    private Integer donadoPor;
    @Column(name = "donado_a")
    private Integer donadoA;

    public ListaDonaciones() {
    }

    public ListaDonaciones(Integer idlistaDonaciones) {
        this.idlistaDonaciones = idlistaDonaciones;
    }

    public Integer getIdlistaDonaciones() {
        return idlistaDonaciones;
    }

    public void setIdlistaDonaciones(Integer idlistaDonaciones) {
        this.idlistaDonaciones = idlistaDonaciones;
    }

    public Integer getIdObjetos() {
        return idObjetos;
    }

    public void setIdObjetos(Integer idObjetos) {
        this.idObjetos = idObjetos;
    }

    public Integer getDonadoPor() {
        return donadoPor;
    }

    public void setDonadoPor(Integer donadoPor) {
        this.donadoPor = donadoPor;
    }

    public Integer getDonadoA() {
        return donadoA;
    }

    public void setDonadoA(Integer donadoA) {
        this.donadoA = donadoA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlistaDonaciones != null ? idlistaDonaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaDonaciones)) {
            return false;
        }
        ListaDonaciones other = (ListaDonaciones) object;
        if ((this.idlistaDonaciones == null && other.idlistaDonaciones != null) || (this.idlistaDonaciones != null && !this.idlistaDonaciones.equals(other.idlistaDonaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.ListaDonaciones[ idlistaDonaciones=" + idlistaDonaciones + " ]";
    }
    
}
