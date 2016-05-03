package datanucleus.dao;

import datanucleus.dao.ress.Crew;

public interface CrewDAO extends DAO<Crew>{
	Crew getElement(String firstName, String lastName);
}
