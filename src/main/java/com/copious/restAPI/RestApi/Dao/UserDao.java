package com.copious.restAPI.RestApi.Dao;

import com.copious.restAPI.RestApi.Model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserDao
{

    List<User> userList = new ArrayList<>(Arrays.asList(
            new User("Pravin","Nikure","8975588243","1234567891234","Pune 412405"),
            new User("Pravin123","Nikure123","8975588242","1234567891235","Pune 412405")
    ));

    public List<User> getAllUser()
    {
        return  userList;
    }
    public List<User> addUser(User user)
    {
        userList.add(user);
        return userList.stream().distinct().collect(Collectors.toList());
    }
    public User updateUser(User user)
    {
        //Updated employee
        userList
                .stream()
                .forEach(e->{
                    if(e.getId_Number()==user.getId_Number()){
                        e.setFirstName(user.getFirstName());
                        e.setLastName(user.getLastName());
                        e.setId_Number(user.getId_Number());
                        e.setMobileNumber(user.getMobileNumber());
                        e.setPhysical_address(user.getPhysical_address());

                    }
                });


        //Returbed updated employee

        return
                userList
                        .stream()
                        .filter(e->e.getId_Number() == user.getId_Number())
                        .findFirst()
                        .get();
    }




    public Optional<User> getUserById(String id_Number) {
        return   getAllUser()
                .stream().filter(c-> c.getId_Number().equals(id_Number)).findFirst();
    }
    public Optional<User> getUserByMobile(String mobileNumber) {
        return getAllUser()
                .stream().filter(c-> c.getMobileNumber().equals(mobileNumber)).findFirst();
    }
}
