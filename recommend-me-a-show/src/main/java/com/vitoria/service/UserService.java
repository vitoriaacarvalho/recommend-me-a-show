package com.vitoria.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitoria.dto.ResponseDto;
import com.vitoria.dto.user.SignInDto;
import com.vitoria.dto.user.SignInResponseDto;
import com.vitoria.dto.user.SignUpDto;
import com.vitoria.exceptions.AuthenticationFailException;
import com.vitoria.exceptions.CustomException;
import com.vitoria.models.AuthenticationToken;
import com.vitoria.models.User;
import com.vitoria.repositories.TheUserRepository;

@Service
public class UserService {
	
	@Autowired
	private TheUserRepository userRepo;
	
	@Autowired
	private AuthenticationService authService;
	
	//Signing UP:
	
	@Transactional
	public ResponseDto signUp(SignUpDto signUpDto) {
		//does user exist?
		if(Objects.nonNull(userRepo.findByEmail(signUpDto.getEmail()))) {
			throw new CustomException("user already exists");
		}
		//hashing the password
		String encryptedPassword=signUpDto.getPassword();
	

        try {
            encryptedPassword = hashPassword(signUpDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
		
		User user=new User(signUpDto.getName(), signUpDto.getEmail(), encryptedPassword);
		
		//saving the user
		userRepo.save(user);
		
		//time to create our token
		final AuthenticationToken authenticationToken=new AuthenticationToken(user);
		authService.saveConfirmationToken(authenticationToken);
		ResponseDto responseDto=new ResponseDto("success", "user created successfully");
		
		return responseDto;
	}

	private String hashPassword(String password) throws NoSuchAlgorithmException{
		MessageDigest md=MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest=md.digest();
		String hash=DatatypeConverter.printHexBinary(digest).toUpperCase();
		return hash;
	}
	
	//Signing IN:
	
	public SignInResponseDto signIn(SignInDto signInDto) {
		//find user by email
		User user=userRepo.findByEmail(signInDto.getEmail());
		if(Objects.isNull(user)) {
			throw new AuthenticationFailException("user is not valid");
		}
		//finding the password in the database
		try {
			if(!user.getPassword().equals(hashPassword(signInDto.getPassword()))) {
				throw new AuthenticationFailException("wrong password");
			}
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		AuthenticationToken token=authService.getToken(user);
		
		//retrieve the token
		if(Objects.isNull(token)) {
			throw new CustomException("token is not present");
		}
		
		return new SignInResponseDto("success", token.getToken());
		
	}
	
	
	
}
