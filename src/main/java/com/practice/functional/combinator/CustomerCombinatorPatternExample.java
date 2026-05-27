package com.practice.functional.combinator;

public class CustomerCombinatorPatternExample
{
	public static void main(String[] args)
	{
		Customer validCustomer = new Customer("John Doe", "john.doe@mail.com", "+0123456789", "New York");
		Customer invalidCustomer = new Customer("Jane Doe", "jane.doe@mail", "12345", "Los Angeles");

		CustomerSignupValidator.CustomerValidationResult result = CustomerSignupValidator
			.isEmailValid()
			.and(CustomerSignupValidator.isPhoneNumberValid()).and(
				customer -> customer.getPhoneNumber().substring(2).length() > 10
					? CustomerSignupValidator.CustomerValidationResult.PHONE_NUMBER_NOT_VALID
					: CustomerSignupValidator.CustomerValidationResult.SUCCESS
			).apply(validCustomer);

		System.out.println(result);

	}
}
