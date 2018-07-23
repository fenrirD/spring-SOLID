package com.yun.solid.partner.shinhan;

import com.yun.solid.partner.payment.CardPaymentDto;
import com.yun.solid.partner.payment.CardType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ShinhanCardApiTest {

    @InjectMocks
    private ShinhanCardApi shinhanCardApi;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void pay() {

        final ShinhanCardDto.PaymentRequest request = ShinhanCardDto.PaymentRequest.builder()
                .shinhanCardNumber("card")
                .cvc("csv")
                .build();

        shinhanCardApi.pay(request);


        verify(restTemplate, atLeastOnce()).postForObject(anyString(), any(), any());


    }
}