package com.insureflowx.claims.dto;

import com.insureflowx.claims.domain.ClaimStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ClaimDTO {

    public static class CreateRequest {
        private String policyNumber;
        private BigDecimal amount;
        private String description;

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
    }

    public static class Response {
        private UUID id;
        private String claimId;
        private String policyNumber;
        private BigDecimal amount;
        private String description;
        private ClaimStatus status;
        private LocalDateTime submittedAt;

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
    }
}
