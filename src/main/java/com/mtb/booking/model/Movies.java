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
import java.util.Locale;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author OLASUNKANMI
 */
@Entity
@Table(name = "movies")
@Data
@NamedQueries({
    @NamedQuery(name = "Movies.findAll", query = "SELECT m FROM Movies m")})
public class Movies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "movie_id")
    private Long movieId;
    @Column(name = "movie_name")
    private String movieName;
    @Column(name = "movie_date")
    private LocalDate movieDate;
    @Column(name = "movie_language")
    private String movieLanguage;
    @Column(name = "movie_hour")
    private String movieHour;
    @Column(name = "movie_type")
    private String movieType;
    @Column(name = "movie_status")
    private String movieStatus;
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @OneToMany(mappedBy = "tbookingMovie", cascade = CascadeType.ALL)
    private List<Tbooking> tbookingList;

    public Movies() {
    }

    public Movies(Long movieId) {
        this.movieId = movieId;
    }






}
