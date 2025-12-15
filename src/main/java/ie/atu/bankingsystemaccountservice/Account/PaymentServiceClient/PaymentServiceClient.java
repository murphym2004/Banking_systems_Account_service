package ie.atu.bankingsystemaccountservice.Account.PaymentServiceClient;

import ie.atu.bankingsystemaccountservice.Account.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service", url = "http://localhost:8080")
public interface PaymentServiceClient {

    @PostMapping("/payments")
    PaymentRequest createPayment(@RequestBody PaymentRequest paymentRequest);
}