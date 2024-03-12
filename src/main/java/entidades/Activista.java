/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author abelc
 */
@Entity
@Table(name = "activista")
public class Activista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombres")
    private String nombre;
    @Column(name = "ap_paterno")
    private String apPaterno;
    @Column(name = "ap_materno")
    private String apMaterno;
    @Column(name = "telefono", unique = true)
    private String telefono;
    @Column(name = "fechaInicioLabores")
    private Calendar fechaInicioLabor;
    @ManyToMany(mappedBy = "activistas",cascade = CascadeType.ALL)
    private List<Problemas> problemas = new ArrayList<>();

    public Activista(String nombre, String apPaterno, String apMaterno, String telefono, Calendar fechaInicioLabor) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.telefono = telefono;
        this.fechaInicioLabor = fechaInicioLabor;
    }

    public Activista() {
    }

    public Activista(Long id) {
        this.id = id;
    }

    public Activista(Long id, String nombre, String apPaterno, String apMaterno, String telefono, Calendar fechaInicioLabor) {
        this.id = id;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.telefono = telefono;
        this.fechaInicioLabor = fechaInicioLabor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Calendar getFechaInicioLabor() {
        return fechaInicioLabor;
    }

    public void setFechaInicioLabor(Calendar fechaInicioLabor) {
        this.fechaInicioLabor = fechaInicioLabor;
    }

    public List<Problemas> getProblemas() {
        return problemas;
    }

    public void setProblemas(List<Problemas> problemas) {
        this.problemas = problemas;
    }
public void addProblema(Problemas problema) {
        if (problemas == null) {
            problemas = new ArrayList<>();
        }
        problemas.add(problema);
        problema.getActivistas().add(this);
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activista)) {
            return false;
        }
        Activista other = (Activista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Activista{" + "id=" + id + ", nombre=" + nombre + ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno + ", telefono=" + telefono + ", fechaInicioLabor=" + fechaInicioLabor + '}';
    }

   

}
