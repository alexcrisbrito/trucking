package mz.co.nextgenit.trucking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_client_id")
    private CompanyClient companyClient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_partner_id")
    private CompanyPartner companyPartner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private String reference;

    private String startingPoint;

    private String endingPoint;

    private long proposedPrice;

    private long actualPrice;

    private long weightKg;

    private String dimensions;

    private LocalDateTime startedAt;

    private LocalDateTime endedAt;

    private String status;
}