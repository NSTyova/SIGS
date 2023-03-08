package org.fao.resources;

import org.fao.model.PaymentTransaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	
	
	@Value("${proxypay.apiKey}")
    private String apiKey;
    
    @Value("${proxypay.secretKey}")
    private String secretKey;
	/*
	   @PostMapping("/create")
	    public ResponseEntity<String> createPaymentTransaction(@RequestBody PaymentTransaction paymentTransaction) {
	        ProxyPayClient proxyPayClient = new ProxyPayClient(apiKey, secretKey);

	        TransactionRequest transactionRequest = new TransactionRequest.Builder()
	                .amount(paymentTransaction.getAmount())
	                .reference(paymentTransaction.getReference())
	                .description(paymentTransaction.getDescription())
	                .callbackUrl(paymentTransaction.getCallbackUrl())
	                .build();

	        try {
	            TransactionResponse transactionResponse = proxyPayClient.createTransaction(transactionRequest);
	            return ResponseEntity.ok(transactionResponse.getCheckoutUrl());
	        } catch (ProxyPayException e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar transação de pagamento.");
	        }
	    }*/

}
