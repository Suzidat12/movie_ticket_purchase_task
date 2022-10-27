/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtb.booking.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author OLASUNKANMI
 */
@Entity
@Table(name = "users")
@Data
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")})
public class Users implements Serializable {

    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "users_id")
    private Long usersId;
    @Column(name = "users_name")
    private String usersName;
    @Column(name = "users_mobile_no")
    private String usersMobileNo;
    @Column(name = "users_email")
    private String usersEmail;
    @Lob
    @Column(name = "users_address")
    private String usersAddress;
    @Column(name = "password")
    private String password;
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;

    @OneToMany(mappedBy = "tbookingUser", cascade = CascadeType.ALL)
    private List<Tbooking> tbookingList;
    
    @OneToMany(mappedBy = "userid", cascade = CascadeType.ALL)
    private List<Roleuser> roleuserList;

    @OneToMany(mappedBy = "customer")
    private List<Payment> paymentList;

    public Users() {
    }

    public Users(Long usersId) {
        this.usersId = usersId;
    }

    @XmlTransient
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<Roleuser> getRoleuserList() {
        return roleuserList;
    }

    public void setRoleuserList(List<Roleuser> roleuserList) {
        this.roleuserList = roleuserList;
    }


}
