package com.insureflowx.claims.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String claimId;

    @Column(nullable = false)
    private String policyNumber;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClaimStatus status;

    private LocalDateTime submittedAt;
    private LocalDateTime updatedAt;

    public Claim() {
    }

    public Claim(UUID id, String claimId, String policyNumber, BigDecimal amount, String description,
            ClaimStatus status, LocalDateTime submittedAt, LocalDateTime updatedAt) {
        this.id = id;
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.submittedAt = submittedAt;
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void onCreate() {
        submittedAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ClaimStatus getStatus() {
        return status;
    }

    public void setStatus(ClaimStatus status) {
        this.status = status;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static ClaimBuilder builder() {
        return new ClaimBuilder();
    }

    public static class ClaimBuilder {
        private UUID id;
        private String claimId;
        private String policyNumber;
        private BigDecimal amount;
        private String description;
        private ClaimStatus status;
        private LocalDateTime submittedAt;
        private LocalDateTime updatedAt;

        public ClaimBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public ClaimBuilder claimId(String claimId) {
            this.claimId = claimId;
            return this;
        }

        public ClaimBuilder policyNumber(String policyNumber) {
            this.policyNumber = policyNumber;
            return this;
        }

        public ClaimBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public ClaimBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ClaimBuilder status(ClaimStatus status) {
            this.status = status;
            return this;
        }

        public Claim build() {
            return new Claim(id, claimId, policyNumber, amount, description, status, submittedAt, updatedAt);
        }
    }
}
