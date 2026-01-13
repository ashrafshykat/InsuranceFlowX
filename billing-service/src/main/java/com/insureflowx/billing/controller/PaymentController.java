package com.insureflowx.billing.controller;

import com.insureflowx.billing.dto.PaymentDTO;
import com.insureflowx.billing.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/pay")
    public ResponseEntity<PaymentDTO.Response> processPayment(@RequestBody PaymentDTO.ProcessRequest request) {
        return ResponseEntity.ok(paymentService.processPayment(request));
    }
}
