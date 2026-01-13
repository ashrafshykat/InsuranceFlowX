package com.insureflowx.billing.service;

import com.insureflowx.billing.domain.Payment;
import com.insureflowx.billing.domain.PaymentStatus;
import com.insureflowx.billing.dto.PaymentDTO;
import com.insureflowx.billing.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentDTO.Response processPayment(PaymentDTO.ProcessRequest request) {
        String transactionId = "TXN-" + UUID.randomUUID().toString();

        Payment payment = Payment.builder()
                .transactionId(transactionId)
                .policyNumber(request.getPolicyNumber())
                .amount(request.getAmount())
                .status(PaymentStatus.COMPLETED) // Simulating success
                .build();

        Payment saved = paymentRepository.save(payment);
        return mapToResponse(saved);
    }

    private PaymentDTO.Response mapToResponse(Payment payment) {
        PaymentDTO.Response response = new PaymentDTO.Response();
        response.setId(payment.getId());
        response.setTransactionId(payment.getTransactionId());
        response.setPolicyNumber(payment.getPolicyNumber());
        response.setAmount(payment.getAmount());
        response.setStatus(payment.getStatus());
        response.setPaymentDate(payment.getPaymentDate());
        return response;
    }
}
