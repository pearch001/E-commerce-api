package com.ecommerce.ecommerceapi.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="seller_profile")
public class SellerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Pattern(regexp= "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", message= "Kindly provide a valid email address")
    @Column(unique = true)
    private String email;
    private String phone;
    private String addressOne;
    private String addressTwo;
    @Column(unique = true)
    private String sellerId;
    @CreationTimestamp
    private Date dateCreated;
    @UpdateTimestamp
    private Date dateModified;
    @Column(unique = true)
    private String shopName;
    private String bankAccountNo;
    private String bankAccountName;
    @Column(unique = true)
    private String registeredShopName;
    private String shopAddressOne;
    private String shopAddressTwo;
    private String shopPostalCode;
    private String legalEntityCountry;
    private String shopLegalRepresentativeFirstName;
    private String shopLegalRepresentativeLastName;
    private String shopLegalRepresentativeMiddleName;
    private Date shopLegalRepresentativeDOB;
    private String shopLegalRepresentativeIDType;
    private String cacCertificateImage;
    private String shopLegalRepresentativeIDTypeImage;
    private String tinCertificateImage;
    private Long shopNumberOfEmployees;
    private String cacNumber;
    private String vatStatus;
    private String country;
    private String taxIdentificationNumber;
}
