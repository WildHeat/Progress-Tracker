package com.progresstracker.ProgressTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progresstracker.ProgressTracker.dto.AuthCredentialsRequest;
import com.progresstracker.ProgressTracker.model.User;
import com.progresstracker.ProgressTracker.util.JwtUtil;

@RestController
@RequestMapping("/api/v1/login")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired 
	private JwtUtil jwtUtil;

	@PostMapping()
	public ResponseEntity<?> login(@RequestBody AuthCredentialsRequest request){
		try {
            Authentication authenticate = authenticationManager
                .authenticate(
                    new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword()
                    )
                );

            User user = (User) authenticate.getPrincipal();
            user.setPassword(null);
            String jwt = jwtUtil.generateToken(user);
            System.out.println(jwt);
            return ResponseEntity.ok()
                .body(jwt);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
//		return ResponseEntity.ok(null);
	}
}
