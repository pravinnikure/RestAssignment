package com.copious.restAPI.RestApi.Controller;

import com.copious.restAPI.RestApi.Model.GenericResponse;
import com.copious.restAPI.RestApi.Model.User;
import com.copious.restAPI.RestApi.Service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController

public class UserController {
    @Autowired
    private  UserService userService;

/*
    @RequestMapping("/users")
    public List<User> users()
    {
        return userService.getAllUser();
    }
*/

    @GetMapping("/getAll")
    public List<User> getAllUser()
    {
       return userService.getAll();
    }

    @PostMapping("/add")
    public List<User> addUser(@Valid @RequestBody User user)
    {
        return userService.addUser(user);
    }

    @PutMapping("/edit")
    public User updateUser(@RequestBody User user)
    {
        return userService.updateUser(user);
    }


/*    @GetMapping(value = "getByName/{firstName}")
    public User getUserByName(@ApiParam(value = "First name value to get an User", required = true)
            @PathVariable("firstName") String firstName){
        return userService.getUserByFirstName(firstName);
    }*/



    //find by id



    @GetMapping("get/{id_Number}")
    @ApiOperation(value = "get user by id.", notes = "Get user")
    public ResponseEntity<GenericResponse<User>> getUserById_Number(@PathVariable(name = "id_Number") String id_Number) {
        return new ResponseEntity<>(
                new GenericResponse<>(true,
                        HttpStatus.OK.name(),
                        userService.getUserById(id_Number)),
                HttpStatus.OK
        );
    }
    @ApiOperation(value = "Validates user against business rules defined.", notes = "Validate user against business rules defined.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The Client validated successfully", response = User.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Resource not found", response = Response.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Response.class),
    })

    @PostMapping("/validate")
    public ResponseEntity<GenericResponse<Optional<User>>> validateClient(@Valid @RequestBody User user) {
        return new ResponseEntity<>(
                new GenericResponse<>(true,
                        HttpStatus.OK.name(),
                        userService.validateUser(user)),
                HttpStatus.OK
        );
    }


/*
    //find by mobile
    @GetMapping(value = "getByMobile/{mobileNumber}")
    public User getUserByMobile(@ApiParam(value = "Id value to get an User", required = true)
            @PathVariable("mobileNumber") String mobileNumber){
        return userService.getUserByMobile(mobileNumber);
    }

*/


}
