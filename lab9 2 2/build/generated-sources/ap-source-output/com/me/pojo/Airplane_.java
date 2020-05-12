package com.me.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Airplane.class)
public abstract class Airplane_ {

	public static volatile SingularAttribute<Airplane, String> airplane_id;
	public static volatile SingularAttribute<Airplane, String> owner;
	public static volatile SetAttribute<Airplane, Flight> flights;
	public static volatile SingularAttribute<Airplane, String> airlineName;

	public static final String AIRPLANE_ID = "airplane_id";
	public static final String OWNER = "owner";
	public static final String FLIGHTS = "flights";
	public static final String AIRLINE_NAME = "airlineName";

}

