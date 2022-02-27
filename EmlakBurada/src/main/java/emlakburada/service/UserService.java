package emlakburada.service;

import emlakburada.dto.request.UserRequest;
import emlakburada.dto.response.UserResponse;
import emlakburada.model.User;
import emlakburada.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import emlakburada.repository.DbConnectionRepository;
import emlakburada.repository.AdvertRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

	@Autowired
	@Qualifier(value = "mongoConnectionRepository")
	private DbConnectionRepository dbConn;

	@Autowired
	private AdvertRepository advertRepository;

	@Autowired
	private UserRepository userRepository;

	public List<UserResponse> getAllUsers() {
		List<UserResponse> userList = new ArrayList<>();

		for (User user : userRepository.fetchAllUsers()) {
			userList.add(convertToUserResponse(user));
		}
		return userList;
	}

	public UserResponse createUser(UserRequest request){
		User savedUser = userRepository.saveUser(convertToUser(request));
		return convertToUserResponse(savedUser);
	}

	private UserResponse convertToUserResponse(User user){
		UserResponse response = new UserResponse();

		response.setUserId(user.getUserID());
		response.setBiyografi(user.getBiyografi());
		response.setIsim(user.getIsim());
		response.setEmail(user.getEmail());
		response.setFotograf(user.getFotograf());

		return response;
	}
	private User convertToUser(UserRequest request){
		User user = new User();

		user.setUserID(user.generateId());
		user.setIsim(request.getIsim());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setKullaniciTipi(request.getKullaniciTipi());
		user.setBiyografi(request.getBiyografi());
		user.setFotograf(request.getFotograf());

		return user;

	}
}
