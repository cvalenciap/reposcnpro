/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author despracenp1
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdPersonas", query = "SELECT p FROM Persona p WHERE p.idPersonas = :idPersonas"),
    @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Persona.findByApellido", query = "SELECT p FROM Persona p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Persona.findByEdad", query = "SELECT p FROM Persona p WHERE p.edad = :edad")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPersonas")
    private Integer idPersonas;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "Edad")
    private int edad;

    public Persona() {
    }

    public Persona(Integer idPersonas) {
        this.idPersonas = idPersonas;
    }

    public Persona(Integer idPersonas, String nombre, String apellido, int edad) {
        this.idPersonas = idPersonas;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Integer getIdPersonas() {
        return idPersonas;
    }

    public void setIdPersonas(Integer idPersonas) {
        this.idPersonas = idPersonas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonas != null ? idPersonas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersonas == null && other.idPersonas != null) || (this.idPersonas != null && !this.idPersonas.equals(other.idPersonas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Persona[ idPersonas=" + idPersonas + " ]";
    }
    
}
