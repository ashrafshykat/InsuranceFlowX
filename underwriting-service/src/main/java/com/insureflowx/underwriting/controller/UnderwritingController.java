package com.insureflowx.underwriting.controller;

import com.insureflowx.underwriting.dto.UnderwritingDTO;
import com.insureflowx.underwriting.service.UnderwritingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/underwriting")
public class UnderwritingController {

    private final UnderwritingService underwritingService;

    public UnderwritingController(UnderwritingService underwritingService) {
        this.underwritingService = underwritingService;
    }

    @PostMapping("/assess")
    public ResponseEntity<UnderwritingDTO.EvaluationResponse> assessRisk(
            @RequestBody UnderwritingDTO.EvaluationRequest request) {
        return ResponseEntity.ok(underwritingService.evaluateRisk(request));
    }
}
