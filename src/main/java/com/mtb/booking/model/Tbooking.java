/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtb.booking.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "tbooking")
@Data

@NamedQueries({
    @NamedQuery(name = "Tbooking.findAll", query = "SELECT t FROM Tbooking t")})
public class Tbooking implements Serializable {

    @Column(name = "tbooking_booked_date")
    private LocalDate tbookingBookedDate;
    @Column(name = "tbooking_movie_timing")
    private LocalDate tbookingMovieTiming;
    @OneToMany(mappedBy = "ticket")
    private List<Payment> paymentList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tbooking_id")
    private Long tbookingId;
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @Column(name = "ticket_code")
    private String ticketCode;
    @JoinColumn(name = "tbooking_movie", referencedColumnName = "movie_id")
    @ManyToOne
    private Movies tbookingMovie;
    @JoinColumn(name = "tbooking_user", referencedColumnName = "users_id")
    @ManyToOne
    private Users tbookingUser;


    public Tbooking() {
    }

    public Tbooking(Long tbookingId) {
        this.tbookingId = tbookingId;
    }


}
