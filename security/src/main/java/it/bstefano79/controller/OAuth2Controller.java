package it.bstefano79.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.bstefano79.config.jwt.JwtUtils;
import it.bstefano79.dto.UserDto;
import it.bstefano79.entity.User;
import it.bstefano79.exception.FigurineRuntimeException;
import it.bstefano79.repository.UserRepository;

@RestController
@RequestMapping("/oauth2/login/")
public class OAuth2Controller {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@GetMapping
	public ResponseEntity<?> getLoginOAuth2(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
		if(oAuth2AuthenticationToken==null){
			throw new FigurineRuntimeException("Impossibile accedere a questa risorsa", HttpStatus.BAD_REQUEST);
		}
		String mail = oAuth2AuthenticationToken.getPrincipal().getAttribute("email");
		User user = userRepository.findByEmail(mail).orElse(null);
		if(user==null){
			return ResponseEntity.status(HttpStatus.OK).body(Map.of(
		            "message", "questo utente proveniente da "+oAuth2AuthenticationToken.getAuthorizedClientRegistrationId() +" non è registrato"));
		}
		UserDto usertDto = new UserDto(user);
		ResponseCookie jwtCookie = jwtUtils.generateJwtCookieFromUserDto(usertDto);
		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
		        .body(new UserDto(usertDto.getId(),
		        		usertDto.getUsername(),
		        		usertDto.getEmail(),
		        		usertDto.getRoles()));
	}

}
