package com.insureflowx.policy.dto;

import com.insureflowx.policy.domain.PolicyStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class PolicyDTO {

    public static class CreateRequest {
        @NotBlank(message = "Holder name is required")
        private String holderName;

        @NotNull(message = "Premium is required")
        @Positive(message = "Premium must be positive")
        private BigDecimal premium;

        @NotNull(message = "Start date is required")
        private LocalDate startDate;

        @NotNull(message = "End date is required")
        @Future(message = "End date must be in the future")
        private LocalDate endDate;

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
    }

    public static class Response {
        private UUID id;
        private String policyNumber;
        private String holderName;
        private BigDecimal premium;
        private LocalDate startDate;
        private LocalDate endDate;
        private PolicyStatus status;

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
    }
}
