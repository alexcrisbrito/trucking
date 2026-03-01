package mz.co.nextgenit.trucking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "company_partner")
public class CompanyPartner {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String title;

    private String email;

    private String nuit;

    private String phone_contact;

    private String phone_emergency;

    private String address;

    private String website;

    private String status;

    public enum CompanyPartnerStatus {
        ACTIVE, INACTIVE
    }

}