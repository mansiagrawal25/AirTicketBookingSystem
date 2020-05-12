package com.me.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Passenger.class)
public abstract class Passenger_ {

	public static volatile SingularAttribute<Passenger, String> firstName;
	public static volatile SingularAttribute<Passenger, String> lastName;
	public static volatile SingularAttribute<Passenger, String> address;
	public static volatile SingularAttribute<Passenger, String> gender;
	public static volatile SingularAttribute<Passenger, String> dob;
	public static volatile SingularAttribute<Passenger, Payment> payment;
	public static volatile SingularAttribute<Passenger, Long> id;
	public static volatile SingularAttribute<Passenger, String> phonenum;
	public static volatile SingularAttribute<Passenger, String> email;

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String ADDRESS = "address";
	public static final String GENDER = "gender";
	public static final String DOB = "dob";
	public static final String PAYMENT = "payment";
	public static final String ID = "id";
	public static final String PHONENUM = "phonenum";
	public static final String EMAIL = "email";

}

