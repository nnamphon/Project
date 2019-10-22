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
@Table(name = "Mold")
public class Mold {

    @Id
    @SequenceGenerator(name="mold_seq",sequenceName="mold_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mold_seq")
    @Column(name = "Mold_Id")

    private @NonNull Long moldID;
    private @NonNull String partNo;
    private @NonNull String nameM;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Model.class)
    @JoinColumn(name = "Model_ID",insertable = true)
    private Model Model;

    @OneToOne (fetch = FetchType.EAGER, targetEntity = Product.class)
    @JoinColumn(name = "Product_ID",insertable = true)
    private Product proName;

    @OneToOne (fetch = FetchType.EAGER, targetEntity = PartName.class)
    @JoinColumn(name = "PartName_ID",insertable = true)
    private PartName partName;


}

