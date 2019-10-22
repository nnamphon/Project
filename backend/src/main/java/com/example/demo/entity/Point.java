package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Point {
    @Id
    @SequenceGenerator(name = "point_seq", sequenceName = "point_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_seq")

    private @NonNull Long id;
    private String other;

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull Date fdate;

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull Date tdate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Addpoint addpoint;

    @ManyToOne(fetch = FetchType.EAGER)
    private Mold mold;

    @ManyToOne(fetch = FetchType.EAGER)
    private Responsible responsible;


    @JsonProperty("addpoint")
    private void Addpoint(Long id) {
        this.addpoint = new Addpoint();
        addpoint.setID(id);
    }
    
    @JsonProperty("mold")
    private void Mold(Long id) {
        this.mold = new Mold();
        mold.setMoldID(id);
    }
    
    @JsonProperty("responsible")
    private void Responsible(Long id) {
        this.responsible = new Responsible();
        responsible.setResID(id);
    }
}
