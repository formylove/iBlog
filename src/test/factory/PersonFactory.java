package test.factory;

import test.entity.Customer;
import test.entity.Employee;
import test.entity.Person;

public class PersonFactory {

	public PersonFactory() {
	}
public static Person getPerson(String type) {
	if (type.equals("emp")) {
		return new Employee();
	} else {
		return new Customer();
	}
}
}
