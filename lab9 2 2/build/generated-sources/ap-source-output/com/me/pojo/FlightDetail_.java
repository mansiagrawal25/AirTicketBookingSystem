package com.me.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FlightDetail.class)
public abstract class FlightDetail_ {

	public static volatile SingularAttribute<FlightDetail, Long> airplane_id;
	public static volatile SingularAttribute<FlightDetail, Integer> amount;
	public static volatile SingularAttribute<FlightDetail, String> arrDate;
	public static volatile SingularAttribute<FlightDetail, String> deptTime;
	public static volatile SingularAttribute<FlightDetail, Integer> availableSeats;
	public static volatile SingularAttribute<FlightDetail, String> dest;
	public static volatile SingularAttribute<FlightDetail, Integer> flight_id;
	public static volatile SingularAttribute<FlightDetail, Integer> totalSeats;
	public static volatile SingularAttribute<FlightDetail, String> travelClass;
	public static volatile SingularAttribute<FlightDetail, String> arrivalTime;
	public static volatile SingularAttribute<FlightDetail, String> flight_name;
	public static volatile SingularAttribute<FlightDetail, String> from;
	public static volatile SingularAttribute<FlightDetail, String> deptDate;

	public static final String AIRPLANE_ID = "airplane_id";
	public static final String AMOUNT = "amount";
	public static final String ARR_DATE = "arrDate";
	public static final String DEPT_TIME = "deptTime";
	public static final String AVAILABLE_SEATS = "availableSeats";
	public static final String DEST = "dest";
	public static final String FLIGHT_ID = "flight_id";
	public static final String TOTAL_SEATS = "totalSeats";
	public static final String TRAVEL_CLASS = "travelClass";
	public static final String ARRIVAL_TIME = "arrivalTime";
	public static final String FLIGHT_NAME = "flight_name";
	public static final String FROM = "from";
	public static final String DEPT_DATE = "deptDate";

}

