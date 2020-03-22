package tudelft.invoice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InvoiceFilter {

	private InvoiceRepository invoiceDao;
	private List<InvoiceAcceptedAction> actions;

	public InvoiceFilter(InvoiceRepository invoiceDao, List<InvoiceAcceptedAction> actions) {
		this.invoiceDao = invoiceDao;
		this.actions = actions;
	}

	public List<Invoice> filter() {

		List<Invoice> allInvoices = invoiceDao.all();

		if(allInvoices == null)
			return Collections.emptyList();

		List<Invoice> filtered = new ArrayList<>();
		for(Invoice inv : allInvoices) {
			if(inv.getValue() < 100.0) {
				filtered.add(inv);

				for (InvoiceAcceptedAction action : actions) {
					action.notify(inv);
				}

			}

		}

		return filtered;

	}
}