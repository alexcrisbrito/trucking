package mz.co.nextgenit.trucking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_client_id")
    private CompanyClient company_client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_partner_id")
    private CompanyPartner company_partner;

    private String first_name;

    private String last_name;

    private String username;

    private String email;

    private String password;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    private LocalDateTime last_active_at;

    private boolean is_online;

    private UserStatus status;

    private Set<String> roles;

    public enum UserStatus {
        ACTIVE, INACTIVE
    }

}