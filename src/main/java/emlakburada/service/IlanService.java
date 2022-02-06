package emlakburada.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import emlakburada.model.Ilan;
import emlakburada.repository.DbConnectionRepository;
import emlakburada.repository.IlanRepository;

@Service
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS )
public class IlanService {

	@Autowired
	private IlanRepository ilanRepository;

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

	public List<Ilan> getAllIlan() {
		System.out.println("IlanService -> ilanRepository: " + ilanRepository.toString());
		kullaniciService.getAllKullanici();
		return ilanRepository.fetchAllIlan();
	}

}
