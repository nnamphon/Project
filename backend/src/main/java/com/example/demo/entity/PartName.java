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
@Table(name = "PartName")
public class PartName {

    @Id
    @SequenceGenerator(name="partName_seq",sequenceName="partName_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="partName_seq")
    @Column(name = "PartName_ID")
    private @NonNull Long partNameID;
    private @NonNull String namePa;



}
