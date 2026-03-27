package com.growvity.growvity.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.growvity.growvity.ApiResponse.ApiResponse;
import com.growvity.growvity.model.Payment;
import com.growvity.growvity.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Payment>>> getAllPayments(){

        List<Payment> payments = paymentService.getAllPayments();

        return ResponseEntity.ok(
                new ApiResponse<>("Payments fetched successfully", payments, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Payment>> getPayment(@PathVariable Long id){

        Payment payment = paymentService.getPayment(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Payment found", payment, true));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Payment>> createPayment(@RequestBody Payment payment){

        Payment saved = paymentService.savePayment(payment);

        return ResponseEntity.ok(
                new ApiResponse<>("Payment created successfully", saved, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Payment>> updatePayment(
            @PathVariable Long id,
            @RequestBody Payment payment){

        Payment updatedPayment = paymentService.updatePayment(id,payment);

        return ResponseEntity.ok(
                new ApiResponse<>("Payment updated successfully", updatedPayment, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deletePayment(@PathVariable Long id){

        paymentService.deletePayment(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Payment deleted successfully", null, true));
    }
}