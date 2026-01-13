package com.insureflowx.claims.controller;

import com.insureflowx.claims.dto.ClaimDTO;
import com.insureflowx.claims.service.ClaimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping
    public ResponseEntity<ClaimDTO.Response> submitClaim(@RequestBody ClaimDTO.CreateRequest request) {
        return ResponseEntity.ok(claimService.submitClaim(request));
    }

    @GetMapping
    public ResponseEntity<List<ClaimDTO.Response>> getAllClaims() {
        return ResponseEntity.ok(claimService.getAllClaims());
    }
}
