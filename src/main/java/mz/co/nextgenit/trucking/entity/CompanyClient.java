package mz.co.nextgenit.trucking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "company_client")
public class CompanyClient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String title;

    private String email;

    private String nuit;

    private String phone;

    private String status;

    public enum CompanyClientStatus {
        ACTIVE, INACTIVE
    }
}