package kr.nexparan.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.nexparan.blog.model.RoleType;
import kr.nexparan.blog.model.User;
import kr.nexparan.blog.repository.UserRepository;

@Controller
public class IndexController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/dummy/join")
	public String join(User user) {
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원 가입이 완료 되었습니다.";
	}
}
