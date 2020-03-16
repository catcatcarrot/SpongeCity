package org.boot.city.mapper;

import java.util.List;

import org.boot.city.entity.People;
import org.boot.city.entity.PeopleTable;

public interface PeopleMapper {
	
	List<People> getAllPeople();
	
	List<People> searchPeopleByNum(String peopleNum);
	
	int insertPeople(PeopleTable people);
	
	int deletePeopleByNum(String number);
	
	List<People> getPeopleByRegion(Integer rId);

}
