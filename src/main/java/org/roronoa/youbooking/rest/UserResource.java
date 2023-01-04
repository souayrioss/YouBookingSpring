package org.roronoa.youbooking.rest;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.roronoa.youbooking.config.JwtUtils;
import org.roronoa.youbooking.dto.AuthDto;
import org.roronoa.youbooking.dto.ResponseDTO;
import org.roronoa.youbooking.dto.UserAppDto;
import org.roronoa.youbooking.entity.UserApp;
import org.roronoa.youbooking.service.IUserService;
import org.roronoa.youbooking.util.EntityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.roronoa.youbooking.util.IConstantes.*;


@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserResource {

    private final IUserService userService;
    private final JwtUtils jwtUtils;

    private final AuthenticationManager authenticationManager;

    @PostMapping(path = "/register")
    public ResponseEntity<ResponseDTO<UserAppDto>> register(@RequestBody @Valid UserAppDto userDTO){
        try {
            UserApp user = EntityUtils.userDTOToUser(userDTO);
            UserApp userApp = userService.save(user);
            ResponseDTO<UserAppDto> response = new ResponseDTO<>() ;
            response.setData(EntityUtils.userToUserDTO(userApp));
            response.setStatus(CODE_001);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ResponseDTO<UserAppDto> response = new ResponseDTO<>() ;
            response.setStatus(CODE_000);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
    @PostMapping(path = "/login")
    public ResponseEntity<ResponseDTO<UserDetails>> login(@RequestBody @Valid AuthDto authDto){
        try {
            Authentication test = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDto.getEmail(),authDto.getPassword()));
            System.out.println(test);
            UserDetails user = userService.findByEmail(authDto.getEmail());
            ResponseDTO<UserDetails> response = new ResponseDTO<>() ;
            if (user != null){
               response.setMessage(jwtUtils.generateToken(user));
                   response.setStatus(CODE_001);
                   response.setData(user);
            }else {
                response.setMessage("user not found");
                response.setStatus(CODE_002);
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ResponseDTO<UserDetails> response = new ResponseDTO<>() ;
            response.setStatus(CODE_000);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping(path = "/user/{uuid}")
    public ResponseEntity<ResponseDTO<UserAppDto>> getUser(@PathVariable @NotEmpty @NotBlank String uuid){
        try {
            ResponseDTO<UserAppDto> response = new ResponseDTO<>() ;
            UserApp user = userService.getUser(uuid);
            if (!Objects.isNull(user)){
                response.setData(EntityUtils.userToUserDTO(user));
                response.setStatus(CODE_001);
            }else {
                response.setStatus("user not exist");
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ResponseDTO<UserAppDto> response = new ResponseDTO<>() ;
            response.setStatus(CODE_000);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
    @GetMapping(path = "/users")
    public ResponseEntity<ResponseDTO<List<UserAppDto>>> getListUser(){
        try {
           List<UserApp> users = userService.getListUsers();
            ResponseDTO<List<UserAppDto>> response = new ResponseDTO<>() ;
            List<UserAppDto> usersDTO = users.stream().map(userApp -> EntityUtils.userToUserDTO(userApp)).collect(Collectors.toList());
            response.setStatus(CODE_001);
            response.setData(usersDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ResponseDTO<List<UserAppDto >> response = new ResponseDTO<>() ;
            response.setStatus(CODE_000);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

}
