package emlakburada.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import emlakburada.dto.AdvertRequest;
import emlakburada.dto.response.AdvertResponse;
import emlakburada.model.Advert;
import emlakburada.model.RealEstate;
import emlakburada.model.User;
import emlakburada.repository.DbConnectionRepository;
import emlakburada.repository.IlanRepository;

@Service
public class AdvertService {

	@Autowired
	private IlanRepository advertRepository;

	@Autowired
	@Qualifier(value = "jdbcConnectionRepository")
	private DbConnectionRepository dbConn;

	@Autowired
	private KullaniciService kullaniciService;

	// @Autowired
//	public IlanService(IlanRepository ilanRepository) {
//		super();
//		this.ilanRepository = ilanRepository;
//	}

	public List<AdvertResponse> getAllAdverts() {
		// System.out.println("IlanService -> ilanRepository: " +
		// advertRepository.toString());
		// kullaniciService.getAllKullanici();
		List<AdvertResponse> advertList = new ArrayList<>();
		for (Advert advert : advertRepository.fetchAllAdverts()) {
			advertList.add(convertToAdvertResponse(advert));
		}
		return advertList;
	}

	public AdvertResponse createAdvert(AdvertRequest request) {
		Advert savedAdvert = advertRepository.saveAdvert(convertToAdvert(request));

		return convertToAdvertResponse(savedAdvert);
	}

	private AdvertResponse convertToAdvertResponse(Advert savedAdvert) {
		AdvertResponse response = new AdvertResponse();
		response.setBaslik(savedAdvert.getBaslik());
		response.setFiyat(savedAdvert.getFiyat());
		return response;
	}

	private Advert convertToAdvert(AdvertRequest request) {
		Advert advert = new Advert(new RealEstate(), new User(), new String[5]);
		advert.setBaslik(request.getBaslik());
		advert.setFiyat(request.getFiyat());
		return advert;
	}

}