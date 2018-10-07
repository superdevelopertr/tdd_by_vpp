package com.vpp.ex5.legacy_code;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoansApplicationTests {
	
	LoanApplication loan;
	LoanCalculatorController controller;

	@Before
	public void setup() {
		loan = spy(new LoanApplication());
		
		LoanRepository data = mock(LoanRepository.class);
		JavaMailSender mailSender = mock(JavaMailSender.class);
		RestTemplate restTemplate = mock(RestTemplate.class);
		
		controller = new LoanCalculatorController();
		controller.setData(data);
		controller.setMailSender(mailSender);
		controller.setRestTemplate(restTemplate);
	}

	@Test
	public void verifyLoanRateFor1Year() {

		loan.setPrincipal(1200);
		loan.setTermInMonths(12);

		doReturn(new BigDecimal(10)).when(loan).getInterestRate();
		controller.processNewLoanApplication(loan);

		assertEquals(new BigDecimal(110), loan.getRepayment());
	}

	@Test
	public void verifyLoanRateFor2Year() {
		loan.setPrincipal(1200);
		loan.setTermInMonths(24);

		doReturn(new BigDecimal(10)).when(loan).getInterestRate();
		controller.processNewLoanApplication(loan);

		assertEquals(new BigDecimal(60), loan.getRepayment());
	}
	
	@Test
	public void verifyLoanRateFor5Year() {
		loan.setPrincipal(5000);
		loan.setTermInMonths(60);

		doReturn(new BigDecimal(6.5)).when(loan).getInterestRate();
		controller.processNewLoanApplication(loan);

		assertEquals(new BigDecimal(111), loan.getRepayment());
	}

}
