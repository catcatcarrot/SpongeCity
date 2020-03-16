package org.boot.city.service;

import java.util.List;

import org.boot.city.entity.People;
import org.boot.city.entity.PeopleTable;

public interface PeopleService {
	
	List<People> getAllPeople();
	
	List<People> searchPeopleByNum(String peopleNum);
	
	int insertPeople(PeopleTable people);
	
	int deletePeopleByNum(String number);

}
