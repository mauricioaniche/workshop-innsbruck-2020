package tudelft.invoice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.xml.parsers.SAXParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvoiceFilterTest {

	@Test
	void test() {

		InvoiceRepository fakeRepository = Mockito.mock(InvoiceRepository.class);

		InvoiceAcceptedAction action1 = Mockito.mock(InvoiceAcceptedAction.class);
		InvoiceAcceptedAction action2 = Mockito.mock(InvoiceAcceptedAction.class);
		InvoiceAcceptedAction action3 = Mockito.mock(InvoiceAcceptedAction.class);

		List<InvoiceAcceptedAction> actions = Arrays.asList(action1, action2, action3);

		Invoice inv1 = new Invoice("Mauricio", 50);
		Invoice inv2 = new Invoice("Marcelo", 500);

		List<Invoice> invoices = Arrays.asList(inv1, inv2);

		Mockito.when(fakeRepository.all()).thenReturn(invoices);

		InvoiceFilter filter = new InvoiceFilter(fakeRepository, actions);
		List<Invoice> results = filter.filter();

		Assertions.assertEquals(1, results.size());
		Assertions.assertEquals(inv1, results.get(0));

		for (InvoiceAcceptedAction action : actions) {
			Mockito.verify(action).notify(inv1);
			Mockito.verify(action, Mockito.never()).notify(inv2);
		}

	}

}
