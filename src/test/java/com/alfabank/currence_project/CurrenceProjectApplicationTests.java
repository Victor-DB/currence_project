package com.alfabank.currence_project;

import com.alfabank.currence_project.controller.CurrencyController;
import com.alfabank.currence_project.feign.api.CurrencyApi;
import com.alfabank.currence_project.model.Currency;
import com.alfabank.currence_project.model.Gif;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CurrenceProjectApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	CurrencyController currencyController;

	@Autowired
	Gif gif;

	@MockBean
	CurrencyApi currencyApi;

	@Value("${localhost}")
	private String localhost;

	@Test
	public void testTodayIsUpper() throws Exception {

		Currency currencyToday = prepareCurrency(74.2);

		Mockito.doReturn(currencyToday)
				.when(currencyApi)
				.getLatestCurrency();

		Currency currencyYesterday = prepareCurrency(73.8);

		Mockito.doReturn(currencyYesterday)
				.when(currencyApi)
				.getHistoricalCurrency();

		this.mockMvc.perform(get(localhost))
				.andDo(print())
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl(gif.getUpQuotes()));
	}

	@Test
	public void testTodayIsLower() throws Exception {

		Currency currencyToday = prepareCurrency(72.5);

		Mockito.doReturn(currencyToday)
				.when(currencyApi)
				.getLatestCurrency();

		Currency currencyYesterday = prepareCurrency(73.8);

		Mockito.doReturn(currencyYesterday)
				.when(currencyApi)
				.getHistoricalCurrency();

		this.mockMvc.perform(get(localhost))
				.andDo(print())
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl(gif.getLowQuotes()));
	}

	private Currency prepareCurrency(Double course) {
		Currency currency = new Currency();
		Map<String, Double> rates = new HashMap<>();
		rates.put("RUB", course);
		currency.setRates(rates);
		return currency;
	}

}
