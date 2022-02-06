package emlakburada.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import emlakburada.model.Ilan;
import emlakburada.service.IlanService;

@RestController
public class IlanController {

	@Autowired
	private IlanService ilanService;

	@GetMapping(value = "/ilanlar")
	public List<String> getAllIlan() {
		System.out.println("ilanService:" + ilanService.toString());

		List<String> baslikList = new ArrayList<>();
		for (Ilan ilan : ilanService.getAllIlan()) {
			baslikList.add(ilan.getBaslik());
		}
		return baslikList;

	}

}
