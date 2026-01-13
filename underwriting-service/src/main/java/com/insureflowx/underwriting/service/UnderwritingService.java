package com.insureflowx.underwriting.service;

import com.insureflowx.underwriting.dto.UnderwritingDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UnderwritingService {

    public UnderwritingDTO.EvaluationResponse evaluateRisk(UnderwritingDTO.EvaluationRequest request) {
        UnderwritingDTO.EvaluationResponse response = new UnderwritingDTO.EvaluationResponse();
        response.setPolicyNumber(request.getPolicyNumber());

        BigDecimal premium = request.getPremium();

        if (premium.compareTo(new BigDecimal("10000")) > 0) {
            response.setDecision(UnderwritingDTO.UnderwritingDecision.MANUAL_REVIEW);
            response.setReason("High premium amount requires manual underwriting.");
        } else if (premium.compareTo(new BigDecimal("9000")) > 0) {
            // Arbitrary rule for rejection simulation
            response.setDecision(UnderwritingDTO.UnderwritingDecision.REJECTED);
            response.setReason("Policy premium falls into restricted range.");
        } else {
            response.setDecision(UnderwritingDTO.UnderwritingDecision.APPROVED);
            response.setReason("Risk within acceptable limits.");
        }

        return response;
    }
}
