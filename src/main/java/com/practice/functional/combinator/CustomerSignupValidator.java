package com.practice.functional.combinator;

import java.util.function.Function;

public interface CustomerSignupValidator extends Function<Customer, CustomerSignupValidator.CustomerValidationResult>
{
	enum CustomerValidationResult {
		SUCCESS ,
		EMAIL_NOT_VALID ,
		PHONE_NUMBER_NOT_VALID ,
	}

	static CustomerSignupValidator isEmailValid()
	{
		return customer -> customer.getEmail().contains("@") ? CustomerValidationResult.SUCCESS : CustomerValidationResult.EMAIL_NOT_VALID;
	}

	static CustomerSignupValidator isPhoneNumberValid()
	{
		return customer -> customer.getPhoneNumber().startsWith("+0") ? CustomerValidationResult.SUCCESS : CustomerValidationResult.PHONE_NUMBER_NOT_VALID;
	}

	default CustomerSignupValidator and(CustomerSignupValidator other){
		return customer -> {
			CustomerValidationResult result = this.apply(customer);
			return result.equals(CustomerValidationResult.SUCCESS) ? other.apply(customer) : result;
		};
	}
}
