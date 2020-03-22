package tudelft.invoice;

public class CustomerBuilder {


	private final Customer customer;

	public CustomerBuilder() {
		customer = new Customer();

		customer.setName("mauricio");
		customer.setLastName("aniche");
		customer.setAge(34);
	}

	public Customer build() {
		return customer;
	}

	public CustomerBuilder setAge(int age) {
		this.customer.setAge(age);
		return this;
	}

	// to be continued...
}
