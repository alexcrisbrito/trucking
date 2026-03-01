package mz.co.nextgenit.trucking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String first_name;

    private String last_name;

    private String phone;

    private String picture;

    private String status;

    public enum DriverStatus {
        ACTIVE, INACTIVE, SUSPENDED
    }
}