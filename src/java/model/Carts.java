/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
 * @author 9lord
 */
@Entity
@Table(name = "CARTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carts.findAll", query = "SELECT c FROM Carts c"),
    @NamedQuery(name = "Carts.findByName", query = "SELECT c FROM Carts c WHERE c.name = :name"),
    @NamedQuery(name = "Carts.findByRate", query = "SELECT c FROM Carts c WHERE c.rate = :rate"),
    @NamedQuery(name = "Carts.findByYears", query = "SELECT c FROM Carts c WHERE c.years = :years"),
    @NamedQuery(name = "Carts.findByPrice", query = "SELECT c FROM Carts c WHERE c.price = :price"),
    @NamedQuery(name = "Carts.findByQty", query = "SELECT c FROM Carts c WHERE c.qty = :qty"),
    @NamedQuery(name = "Carts.findById", query = "SELECT c FROM Carts c WHERE c.id = :id")})
public class Carts {

//    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Size(max = 15)
    @Column(name = "RATE")
    private String rate;
    @Column(name = "YEARS")
    private Integer years;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "QTY")
    private Integer qty;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;

    public Carts() {
    }

    public Carts(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Carts)) {
            return false;
        }
        Carts other = (Carts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Carts[ id=" + id + " ]";
    }
    
}
