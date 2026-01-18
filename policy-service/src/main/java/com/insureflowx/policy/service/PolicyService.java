package com.insureflowx.policy.service;

import com.insureflowx.policy.domain.Policy;
import com.insureflowx.policy.domain.PolicyStatus;
import com.insureflowx.policy.dto.PolicyDTO;
import com.insureflowx.policy.repository.PolicyRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PolicyService {

    private final PolicyRepository policyRepository;

    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public PolicyDTO.Response createPolicy(PolicyDTO.CreateRequest request) {
        String policyNumber = "POL-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        Policy policy = Policy.builder()
                .policyNumber(policyNumber)
                .holderName(request.getHolderName())
                .premium(request.getPremium())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .status(PolicyStatus.PENDING_APPROVAL)
                .build();

        Policy saved = policyRepository.save(policy);
        return mapToResponse(saved);
    }

    public PolicyDTO.Response getPolicy(UUID id) {
        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found"));
        return mapToResponse(policy);
    }

    public List<PolicyDTO.Response> getAllPolicies() {
        return policyRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public PolicyDTO.Response updateStatus(UUID id, PolicyStatus status) {
        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found"));
        policy.setStatus(status);
        Policy saved = policyRepository.save(policy);
        return mapToResponse(saved);
    }

    private PolicyDTO.Response mapToResponse(Policy policy) {
        PolicyDTO.Response response = new PolicyDTO.Response();
        response.setId(policy.getId());
        response.setPolicyNumber(policy.getPolicyNumber());
        response.setHolderName(policy.getHolderName());
        response.setPremium(policy.getPremium());
        response.setStartDate(policy.getStartDate());
        response.setEndDate(policy.getEndDate());
        response.setStatus(policy.getStatus());
        return response;
    }
}
