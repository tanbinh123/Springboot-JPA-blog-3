package kr.nexparan.blog.api;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.nexparan.blog.dto.ResponseDto;
import kr.nexparan.blog.model.User;
import kr.nexparan.blog.repository.UserRepository;

@RestController
public class UserApiController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {
		//User u = userRepository.save(user);
		System.out.println("호출됨");
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}
}
