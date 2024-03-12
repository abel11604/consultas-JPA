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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author abelc
 */
@Entity
@Table(name = "problema")
public class Problemas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Calendar fechaInicio;

    private Calendar fechaFinal;
    
    private String descripcion;
    
    private String estado;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idCliente")
    private Cliente ClienteDelProblema;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (
    name="activistasdelproblema",
        joinColumns=@JoinColumn(name = "idProblema"),
        inverseJoinColumns = @JoinColumn(name = "idActivista")
    )
     private List<Activista> activistas = new ArrayList<>();

    public Problemas() {
    }

    public Problemas(Calendar fechaInicio, Calendar fechaFinal, Cliente ClienteDelProblema) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.ClienteDelProblema = ClienteDelProblema;
    }

    public Problemas(Calendar fechaInicio, Calendar fechaFinal, String descripcion, String estado, Cliente ClienteDelProblema) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.descripcion = descripcion;
        this.estado = estado;
        this.ClienteDelProblema = ClienteDelProblema;
    }

    public Problemas(Calendar fechaInicio, String descripcion, String estado, Cliente ClienteDelProblema) {
        this.fechaInicio = fechaInicio;
        this.descripcion = descripcion;
        this.estado = estado;
        this.ClienteDelProblema = ClienteDelProblema;
    }

    
    public Problemas(Calendar fechaInicio, String estado, Cliente ClienteDelProblema) {
        this.fechaInicio = fechaInicio;
        this.estado = estado;
        this.ClienteDelProblema = ClienteDelProblema;
    }

    public Problemas(Long id, Calendar fechaInicio, Calendar fechaFinal, String estado, Cliente ClienteDelProblema) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.estado = estado;
        this.ClienteDelProblema = ClienteDelProblema;
    }

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Calendar getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Calendar fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getClienteDelProblema() {
        return ClienteDelProblema;
    }

    public void setClienteDelProblema(Cliente ClienteDelProblema) {
        this.ClienteDelProblema = ClienteDelProblema;
    }

    public List<Activista> getActivistas() {
        return activistas;
    }

    public void setActivistas(List<Activista> activistas) {
        this.activistas = activistas;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   public void addActivista(Activista activista) {
        if (activistas == null) {
            activistas = new ArrayList<>();
        }
        activistas.add(activista);
        activista.getProblemas().add(this);
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
        if (!(object instanceof Problemas)) {
            return false;
        }
        Problemas other = (Problemas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Problemas{" + "id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", descripcion=" + descripcion + ", estado=" + estado + ", ClienteDelProblema=" + ClienteDelProblema + '}';
    }

  
   

}