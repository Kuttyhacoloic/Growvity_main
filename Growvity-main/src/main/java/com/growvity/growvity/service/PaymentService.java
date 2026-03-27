package com.growvity.growvity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growvity.growvity.globalException.BadRequestException;
import com.growvity.growvity.globalException.ResourceNotFoundException;
import com.growvity.growvity.model.Payment;
import com.growvity.growvity.repo.PaymentRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepo paymentRepo;

    public List<Payment> getAllPayments(){
        return paymentRepo.findAll();
    }

    public Payment getPayment(Long id){
        return paymentRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Payment not found with id: " + id));
    }

    public Payment savePayment(Payment payment){

        if(payment.getAmount() <= 0){
            throw new BadRequestException("Invalid payment amount");
        }

        return paymentRepo.save(payment);
    }

    public Payment updatePayment(Long id, Payment updated){

        Payment existing = getPayment(id);

        if(updated.getPaymentStatus() != null){
            existing.setPaymentStatus(updated.getPaymentStatus());
        }

        return paymentRepo.save(existing);
    }

    public void deletePayment(Long id){
        Payment payment = getPayment(id);
        paymentRepo.delete(payment);
    }
}