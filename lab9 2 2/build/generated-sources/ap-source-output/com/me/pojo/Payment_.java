package com.me.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Payment.class)
public abstract class Payment_ {

	public static volatile SingularAttribute<Payment, String> expiration_year;
	public static volatile SingularAttribute<Payment, Passenger> passenger;
	public static volatile SingularAttribute<Payment, Long> creditCardNumber;
	public static volatile SingularAttribute<Payment, String> expiration_month;
	public static volatile SingularAttribute<Payment, String> fullName;
	public static volatile SingularAttribute<Payment, String> bankName;

	public static final String EXPIRATION_YEAR = "expiration_year";
	public static final String PASSENGER = "passenger";
	public static final String CREDIT_CARD_NUMBER = "creditCardNumber";
	public static final String EXPIRATION_MONTH = "expiration_month";
	public static final String FULL_NAME = "fullName";
	public static final String BANK_NAME = "bankName";

}

