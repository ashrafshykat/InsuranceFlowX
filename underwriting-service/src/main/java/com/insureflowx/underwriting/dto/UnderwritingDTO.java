package com.insureflowx.underwriting.dto;

import java.math.BigDecimal;

public class UnderwritingDTO {

    public static class EvaluationRequest {
        private String policyNumber;
        private BigDecimal premium;
        private String holderName;

        public String getPolicyNumber() {
            return policyNumber;
        }

        public void setPolicyNumber(String policyNumber) {
            this.policyNumber = policyNumber;
        }

        public BigDecimal getPremium() {
            return premium;
        }

        public void setPremium(BigDecimal premium) {
            this.premium = premium;
        }

        public String getHolderName() {
            return holderName;
        }

        public void setHolderName(String holderName) {
            this.holderName = holderName;
        }
    }

    public static class EvaluationResponse {
        private String policyNumber;
        private UnderwritingDecision decision;
        private String reason;

        public String getPolicyNumber() {
            return policyNumber;
        }

        public void setPolicyNumber(String policyNumber) {
            this.policyNumber = policyNumber;
        }

        public UnderwritingDecision getDecision() {
            return decision;
        }

        public void setDecision(UnderwritingDecision decision) {
            this.decision = decision;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }

    public enum UnderwritingDecision {
        APPROVED,
        REJECTED,
        MANUAL_REVIEW
    }
}
