package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "Model")
public class Model {

    @Id
    @SequenceGenerator(name="model_seq",sequenceName="model_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="model_seq")
    @Column(name = "Model_Id")
    private @NotNull Long modelID;
    private @NotNull String model;
}



