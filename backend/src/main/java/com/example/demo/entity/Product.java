package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "Product")
public class Product {
    @Id
    @SequenceGenerator(name="product_seq",sequenceName="product_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_seq")
    @Column(name = "Product_Id")

    private @NonNull Long productID;
    private @NonNull String proName;

}

