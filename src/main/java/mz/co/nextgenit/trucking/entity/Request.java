package mz.co.nextgenit.trucking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_partner_id")
    private CompanyPartner company_partner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_client_id")
    private CompanyClient company_client;

    private String starting_point;

    private String ending_point;

    private long proposed_price;

    private long actual_price;

    private long weight_kg;

    private long volume_m3;



}