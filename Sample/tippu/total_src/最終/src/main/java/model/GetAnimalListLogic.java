package model;

import java.util.List;

import dao.AnimalDAO;
import servlet.Search;


public class GetAnimalListLogic {

	public List<AnimalInfo>execute(){
		AnimalDAO dao = new AnimalDAO();
		List<AnimalInfo>animalList = dao.findAll();
		return animalList;
	}

}
