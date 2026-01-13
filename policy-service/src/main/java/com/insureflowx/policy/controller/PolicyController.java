package com.insureflowx.policy.controller;

import com.insureflowx.policy.dto.PolicyDTO;
import com.insureflowx.policy.service.PolicyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping
    public ResponseEntity<PolicyDTO.Response> createPolicy(@Valid @RequestBody PolicyDTO.CreateRequest request) {
        return ResponseEntity.ok(policyService.createPolicy(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolicyDTO.Response> getPolicy(@PathVariable UUID id) {
        return ResponseEntity.ok(policyService.getPolicy(id));
    }

    @GetMapping
    public ResponseEntity<List<PolicyDTO.Response>> getAllPolicies() {
        return ResponseEntity.ok(policyService.getAllPolicies());
    }
}
