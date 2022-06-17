package com.ecommerce.ecommerceapi.model.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Setter
@Getter
@Builder
@Entity(name = "cart")
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @CreationTimestamp
    private Date dateCreated;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    public Cart(User user, Product product, int quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }
}


