/*package br.com.zup.Projeto.controller;


import br.com.zup.Projeto.NOVOSecurity.model.UserDto;
import br.com.zup.Projeto.NOVOSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    //@Secured("ROLE_USER")
    //@PreAuthorize("hasRole('USER')")//
    ////@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> getOne(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto user){
        return ResponseEntity.ok(userService.save(user));
    }
}



*/