package mz.co.nextgenit.trucking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_partner_id")
    private CompanyPartner company_partner;

    private String plate_number;

    private String colour;

    private long max_weight;

    private long max_area_m2;

    private VehicleTypes type;

    private VehicleStatus status;

    public enum VehicleTypes {
        LIGHT, MEDIUM, HEAVY, EXTRA_LARGE
    }

    public enum VehicleStatus {
        ACTIVE, INACTIVE
    }
}