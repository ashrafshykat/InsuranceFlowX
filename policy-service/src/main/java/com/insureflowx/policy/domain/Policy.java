package com.insureflowx.policy.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "policies")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String policyNumber;

    @Column(nullable = false)
    private String holderName;

    @Column(nullable = false)
    private BigDecimal premium;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PolicyStatus status;

    public Policy() {
    }

    public Policy(UUID id, String policyNumber, String holderName, BigDecimal premium, LocalDate startDate,
            LocalDate endDate, PolicyStatus status) {
        this.id = id;
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premium = premium;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public PolicyStatus getStatus() {
        return status;
    }

    public void setStatus(PolicyStatus status) {
        this.status = status;
    }

    // Manual Builder
    public static PolicyBuilder builder() {
        return new PolicyBuilder();
    }

    public static class PolicyBuilder {
        private UUID id;
        private String policyNumber;
        private String holderName;
        private BigDecimal premium;
        private LocalDate startDate;
        private LocalDate endDate;
        private PolicyStatus status;

        public PolicyBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public PolicyBuilder policyNumber(String policyNumber) {
            this.policyNumber = policyNumber;
            return this;
        }

        public PolicyBuilder holderName(String holderName) {
            this.holderName = holderName;
            return this;
        }

        public PolicyBuilder premium(BigDecimal premium) {
            this.premium = premium;
            return this;
        }

        public PolicyBuilder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public PolicyBuilder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public PolicyBuilder status(PolicyStatus status) {
            this.status = status;
            return this;
        }

        public Policy build() {
            return new Policy(id, policyNumber, holderName, premium, startDate, endDate, status);
        }
    }
}
