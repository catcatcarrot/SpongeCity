package org.boot.city.service.impl;

import java.util.List;

import org.boot.city.entity.People;
import org.boot.city.entity.PeopleTable;
import org.boot.city.mapper.PeopleMapper;
import org.boot.city.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl implements PeopleService{
	
	@Autowired
	private PeopleMapper peopleMapper;

	@Override
	public List<People> getAllPeople() {
		return peopleMapper.getAllPeople();
	}

	@Override
	public List<People> searchPeopleByNum(String peopleNum) {
		return peopleMapper.searchPeopleByNum(peopleNum);
	}

	@Override
	public int insertPeople(PeopleTable people) {
		return peopleMapper.insertPeople(people);
	}

	@Override
	public int deletePeopleByNum(String number) {
		return peopleMapper.deletePeopleByNum(number);
	}

}
