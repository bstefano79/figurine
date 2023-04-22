package it.bstefano79.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.bstefano79.entity.User;
import it.bstefano79.repository.UserRepository;

@RestController
@RequestMapping("/oauth2/login/")
public class OAuth2Controller {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public void getLoginOAuth2(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
		String mail = oAuth2AuthenticationToken.getPrincipal().getAttribute("email");
		User u = userRepository.findByEmail(mail).orElse(null);
		return;
	}

}
