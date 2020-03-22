package christmas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tudelft.christmas.ChristmasDiscount;
import tudelft.christmas.Clock;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ChristmasDiscountTest {

	@Test
	void isChristmas() {
		Clock fakeClock = Mockito.mock(Clock.class);

		GregorianCalendar christmasDay = new GregorianCalendar(2019, Calendar.DECEMBER, 25);
		Mockito.when(fakeClock.today()).thenReturn(christmasDay);

		ChristmasDiscount discount = new ChristmasDiscount(fakeClock);
		double result = discount.applyDiscount(100);
		Assertions.assertEquals(85, result, 0.0001);
	}

	@Test
	void notChristmas() {
		Clock fakeClock = Mockito.mock(Clock.class);

		GregorianCalendar christmasDay = new GregorianCalendar(2019, Calendar.DECEMBER, 26);
		Mockito.when(fakeClock.today()).thenReturn(christmasDay);

		ChristmasDiscount discount = new ChristmasDiscount(fakeClock);
		double result = discount.applyDiscount(100);
		Assertions.assertEquals(100, result, 0.0001);
	}
}
