package emlakburada.controller;

import java.util.List;
import java.util.UUID;

import emlakburada.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import emlakburada.dto.request.AdvertRequest;
import emlakburada.dto.response.AdvertResponse;
import emlakburada.service.AdvertService;

@RestController
public class AdvertController {

	@Autowired
	private AdvertService advertService;
	@Autowired
	private UserService userService;

	@GetMapping(value = "/adverts")
	public ResponseEntity<List<AdvertResponse>> getAllAdvert() {
		return new ResponseEntity<>(advertService.getAllAdverts(), HttpStatus.OK);
	}

	@PostMapping(value = "/adverts")
	public ResponseEntity<AdvertResponse> createAdvert(@RequestBody AdvertRequest request) {
		return new ResponseEntity<>(advertService.saveAdvert(request), HttpStatus.CREATED);
	}

	@GetMapping(value = "/adverts/{advertNo}")
	public ResponseEntity<AdvertResponse> getAdvertByAdvertId(@PathVariable(required = false) int advertNo) {
		return new ResponseEntity<>(advertService.getAdvertByAdvertId(advertNo), HttpStatus.OK);
	}

	@PostMapping(value = "/adverts/{userId}" )
	public ResponseEntity<UUID> setFavoriteAdvert(@PathVariable UUID userId){
		return new ResponseEntity<>(advertService.setFavoriteAdvert(userId),HttpStatus.OK);
	}

	@GetMapping(value="/adverts/{userId}")
	public ResponseEntity<List<AdvertResponse>> getAdvertByUserId(@PathVariable UUID userId){
		return new ResponseEntity<>(advertService.getFavoriteAdvert(userId),HttpStatus.OK);
	}




}
