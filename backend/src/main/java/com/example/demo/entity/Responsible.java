package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "Responsible")
public class Responsible {

    @Id
    @SequenceGenerator(name="responsible_seq",sequenceName="responsible_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="responsible_seq")
    @Column(name = "Responsible_Id")

    private @NonNull Long resID;
    private @NonNull String other;
    private @NonNull String nameS;



}

