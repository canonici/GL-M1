package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import datanucleus.dao.*;
import datanucleus.dao.ress.*;

public class DAOTest {
	/*
	@Test
	public void test(){
		
		FlightDAO flightDAO=DAOFactory.getFlightDAO();
		PlaneDAO planeDAO=DAOFactory.getPlaneDAO();
		UserDAO userDAO=DAOFactory.getUserDAO();
		CrewDAO crewDAO=DAOFactory.getCrewDAO();
		AirportDAO airportDAO=DAOFactory.getAirportDAO();
		
		airportDAO.addElement(new Airport("Elie"));
		airportDAO.addElement(new Airport("Samia"));
		airportDAO.addElement(new Airport("Tantely"));
		
		airportDAO.deleteElement("Samia");
		
		Airport a=airportDAO.getElement("Elie");
		System.out.println(a);
		planeDAO.addElement(new Plane("1","Elie"));
		
		//airportDAO.editElement(1, new Airport(1,"Stefan"));
		
		
		Collection<Airport> b=airportDAO.getAll();
		
		if(b.isEmpty()){
			System.out.println("Empty");
		}
		
		for(Airport air:b){
			System.out.println(air);
		}
		
		Collection<Plane> c=planeDAO.getAll();
		
		for(Plane p:c){
			System.out.println(p);
		}
		
		
		userDAO.addElement(new User("alex2","Alex","Ashokoumar","pass","test@eu.com",UserStatus.CREW));
		System.out.println(userDAO.getElement("alex2"));

		crewDAO.addElement(new Crew("Si","Si","Chen","pass","test@eu.com",UserStatus.CREW,CrewStatus.PILOT));
		//crewDAO.deleteElement("Si");
		System.out.println(crewDAO.getAll());
		
		flightDAO.addElement(new Flight("AF057","Elie","Tantely",new Date(),new Date()));
		flightDAO.addElement(new Flight("AF056","Elie","Tantely",new Date(),new Date()));
		//flightDAO.deleteElement("AF057");
		//flightDAO.addNotam("AF057", "Super");;
		System.out.println(flightDAO.getAll());
		
	}
	*/

	@Before
	public void beforeTest() {
		System.out.println("------------------------");
	}
	    
	@After
	public void afterTest() {
		System.out.println("------------------------");
	}

	@Test
	public void testAirport(){
		System.out.println("Test Airport :\n");
		
		AirportDAO airportDAO=DAOFactory.getAirportDAO();
		
		airportDAO.addElement(new Airport("Elie"));
		airportDAO.addElement(new Airport("Samia"));
		airportDAO.addElement(new Airport("Tantely"));
		
		airportDAO.deleteElement("Samia");
		
		Airport a=airportDAO.getElement("Elie");
		System.out.println(a);
		

		Collection<Airport> b=airportDAO.getAll();
		
		if(b.isEmpty()){
			System.out.println("Empty");
		}
		
		for(Airport air:b){
			System.out.println(air);
		}
		
	}
	
	@Test
	public void testPlane(){
		System.out.println("Test Plane :\n");
		
		PlaneDAO planeDAO=DAOFactory.getPlaneDAO();

		//planeDAO.addElement(new Plane("Elie"));
		planeDAO.addElement(new Plane("TBS-253","Elie"));
		
		Collection<Plane> c=planeDAO.getAll();
		
		for(Plane p:c){
			System.out.println(p);
		}
	}
	
	@Test
	public void testUserAndCrew(){
		System.out.println("Test User & Crew :\n");
	
		UserDAO userDAO=DAOFactory.getUserDAO();
		CrewDAO crewDAO=DAOFactory.getCrewDAO();
		
		userDAO.addElement(new User("alex2","Alex","Ashokoumar","pass","test@eu.com",UserStatus.CREW));
		System.out.println(userDAO.getElement("alex2"));
		
		crewDAO.addElement(new Crew("Si","Si","Chen","pass","test@eu.com",UserStatus.CREW,CrewStatus.PILOT));
		crewDAO.deleteElement("Si");
		System.out.println(userDAO.getAll());
	}
	
	@Test
	public void testFlight() throws ParseException{
		System.out.println("\nTest Flight :\n");
		FlightDAO flightDAO=DAOFactory.getFlightDAO();
		
		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse("2007-03-06");
		Date date2=new SimpleDateFormat("yyyy-MM-dd").parse("2007-03-07");
		
		flightDAO.addElement(new Flight("AF057","Elie","Tantely",date1,new Date()));
		flightDAO.addElement(new Flight("AF057","Elie","Tantely",date2,new Date()));
		flightDAO.addElement(new Flight("AF057","Elie","Tantely",date1,new Date()));
		flightDAO.addElement(new Flight("AF057","Tantely","Elie",date1,new Date()));

		//flightDAO.deleteElement("AF057");
		//flightDAO.addNotam("AF057", "Super");
		
		Collection<Flight> flight=flightDAO.getAll();
		
		for(Flight f:flight){
			System.out.println(f);
		}
		
		/*
		flight=flightDAO.getAll(null);
		
		for(Flight f:flight){
			System.out.println(f);
		}
		*/
	}
}