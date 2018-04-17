package com.rmatejak.braintri.controller;

import com.rmatejak.braintri.persistence.dto.UserFormDto;
import com.rmatejak.braintri.persistence.entity.Profession;
import com.rmatejak.braintri.persistence.view.UserViewDto;
import com.rmatejak.braintri.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/adduser")
    public ResponseEntity<Void> addUser(@Valid @RequestBody UserFormDto userFormDto) {
        userService.addUser(userFormDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/getallbyname")
    public ResponseEntity<List<UserViewDto>> getUsersByName() {
        return new ResponseEntity<List<UserViewDto>>(userService.getUsersByName(), HttpStatus.OK);
    }

    @GetMapping(value = "/getallbysurname")
    public ResponseEntity<List<UserViewDto>> getUsersBySurname() {
        return new ResponseEntity<List<UserViewDto>>(userService.getUsersBySurname(), HttpStatus.OK);
    }

    @GetMapping(value = "/getallbyemail")
    public ResponseEntity<List<UserViewDto>> getUsersByEmail() {
        return new ResponseEntity<List<UserViewDto>>(userService.getUsersByEmail(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletebyid/{id}")
    public ResponseEntity<Void> deleteUserById(@Valid @PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/count/{profession}")
    public ResponseEntity<Long> count(@PathVariable Profession profession) {
        return new ResponseEntity<Long>(userService.countByProfession(profession), HttpStatus.OK);
    }
}

