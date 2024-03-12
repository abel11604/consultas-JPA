/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author abelc
 */
@Entity
@Table(name = "direccion")
public class Direcciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private String colonia;
    @Column(name = "codigoPostal")
    private String cp;
    private String numeroExterior;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente direccion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public Direcciones() {
    }

    public Direcciones(Long id) {
        this.id = id;
    }

    public Direcciones(String calle, String colonia, String cp, String numeroExterior, Cliente direccion) {
        this.calle = calle;
        this.colonia = colonia;
        this.cp = cp;
        this.numeroExterior = numeroExterior;
        this.direccion = direccion;
    }

    public Direcciones(Long id, String calle, String colonia, String cp, String numeroExterior, Cliente direccion) {
        this.id = id;
        this.calle = calle;
        this.colonia = colonia;
        this.cp = cp;
        this.numeroExterior = numeroExterior;
        this.direccion = direccion;
    }

    public Direcciones(String calle, String colonia, String cp, String numeroExterior) {
        this.calle = calle;
        this.colonia = colonia;
        this.cp = cp;
        this.numeroExterior = numeroExterior;
    }

    public Direcciones(Long id, String calle, String colonia, String cp, String numeroExterior) {
        this.id = id;
        this.calle = calle;
        this.colonia = colonia;
        this.cp = cp;
        this.numeroExterior = numeroExterior;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direcciones)) {
            return false;
        }
        Direcciones other = (Direcciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Direcciones{" + "id=" + id + ", calle=" + calle + ", colonia=" + colonia + ", cp=" + cp + ", numeroExterior=" + numeroExterior + '}';
    }

}