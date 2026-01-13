package com.insureflowx.claims.service;

import com.insureflowx.claims.domain.Claim;
import com.insureflowx.claims.domain.ClaimStatus;
import com.insureflowx.claims.dto.ClaimDTO;
import com.insureflowx.claims.repository.ClaimRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClaimService {

    private final ClaimRepository claimRepository;

    public ClaimService(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    public ClaimDTO.Response submitClaim(ClaimDTO.CreateRequest request) {
        String claimId = "CLM-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        Claim claim = Claim.builder()
                .claimId(claimId)
                .policyNumber(request.getPolicyNumber())
                .amount(request.getAmount())
                .description(request.getDescription())
                .status(ClaimStatus.SUBMITTED)
                .build();

        Claim saved = claimRepository.save(claim);
        return mapToResponse(saved);
    }

    public List<ClaimDTO.Response> getAllClaims() {
        return claimRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private ClaimDTO.Response mapToResponse(Claim claim) {
        ClaimDTO.Response response = new ClaimDTO.Response();
        response.setId(claim.getId());
        response.setClaimId(claim.getClaimId());
        response.setPolicyNumber(claim.getPolicyNumber());
        response.setAmount(claim.getAmount());
        response.setDescription(claim.getDescription());
        response.setStatus(claim.getStatus());
        response.setSubmittedAt(claim.getSubmittedAt());
        return response;
    }
}
