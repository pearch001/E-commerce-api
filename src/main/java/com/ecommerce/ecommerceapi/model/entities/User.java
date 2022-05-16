package com.ecommerce.ecommerceapi.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp= "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", message= "Kindly provide a valid email address")
    @Column(unique = true)
    private String email;
    private String username;
    private  String password;
<<<<<<< HEAD
<<<<<<< HEAD
    private String firstName;
    private String lastName;
    private String phone;
    private String gender;
    private String address;
=======
>>>>>>> 108aa4b8e0946b60fd1463fd85a720a7eecd7e46
=======
>>>>>>> 108aa4b8e0946b60fd1463fd85a720a7eecd7e46

    public User(Long id, String email, String username, String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    @CreationTimestamp
    private Date dateCreated;
    @UpdateTimestamp
    private Date dateModified;


}



