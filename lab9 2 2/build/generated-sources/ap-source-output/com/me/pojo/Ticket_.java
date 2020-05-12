package com.me.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Ticket.class)
public abstract class Ticket_ {

	public static volatile SingularAttribute<Ticket, FlightDetail> flightDetails;
	public static volatile SingularAttribute<Ticket, Passenger> passengerDetails;
	public static volatile SingularAttribute<Ticket, Long> ticket_id;

	public static final String FLIGHT_DETAILS = "flightDetails";
	public static final String PASSENGER_DETAILS = "passengerDetails";
	public static final String TICKET_ID = "ticket_id";

}

