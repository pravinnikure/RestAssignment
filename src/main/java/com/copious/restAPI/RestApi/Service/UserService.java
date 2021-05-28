package com.copious.restAPI.RestApi.Service;

import com.copious.restAPI.RestApi.Constants.ExceptionCode;
import com.copious.restAPI.RestApi.Dao.UserDao;
import com.copious.restAPI.RestApi.Exceptions.InvalidUserException;
import com.copious.restAPI.RestApi.Exceptions.UserNotFoundException;
import com.copious.restAPI.RestApi.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(String id_Number)
    {
        return userDao.getUserById(id_Number)
                .orElseThrow(()->new UserNotFoundException(ExceptionCode.NO_USER_FOUND
                        ,"User not found"
                        ,"User not found"));
    }

    public User getUserByMobileNumber(String mobileNumber)
    {
        return userDao.getUserByMobile(mobileNumber)
                .orElseThrow(()->new UserNotFoundException(ExceptionCode.NO_USER_FOUND
                        ,"User's mobile not found"
                        ,"User's mobile not found"));
    }

/*    //Get user based on first name
    public User getUserByFirstName(@RequestBody String firstName)
    {
        return userList
                .stream()
                .filter(u ->u.getFirstName().equals(firstName))
                .findFirst().get();
    }
 */   //Get user based on id




    public Optional<User> validateUser(User user)
    {
        try{
            return Stream.of(user)
                    .map(u ->
                    {
                        if(isNotValidSAId(u.getId_Number())){
                            throw new InvalidUserException(ExceptionCode.NO_USER_FOUND,ExceptionCode
                                    .INVALID_USER.getErrorMessege(),
                                    u.getId_Number()+" Is not valid"
                            );
                        }
                        else{
                            if(isDuplicateId(u.getId_Number())){
                                throw new InvalidUserException(ExceptionCode.INVALID_USER,ExceptionCode.INVALID_USER.getErrorMessege(),
                                        u.getId_Number()+"Is duplicate"
                                );

                            }
                            else if(isDuplicateMobile(u.getMobileNumber())){
                                throw new InvalidUserException(ExceptionCode.INVALID_USER,ExceptionCode.INVALID_USER.getErrorMessege(),
                                        u.getMobileNumber()+"is duplicate mobile number");

                            }
                            return u;
                        }

                    }).findFirst();
        }catch (Exception e)
        {
            throw e;
        }


    }

    private boolean isValidSAId(String id_Number)
    {
        return id_Number.length()==13;
    }

    private boolean isNotValidSAId(String id_Number) {
        return !isValidSAId(id_Number);
    }


    private boolean isDuplicateId(String id_Number)
    {
        return userDao.getUserById(id_Number).isPresent();
    }

    private boolean isDuplicateMobile(String mobileNumber)
    {
        return userDao.getUserByMobile(mobileNumber).isPresent();
    }



    public List<User> addUser(User user)
    {
        return  userDao.addUser(user);
    }

    public User updateUser(User user)
    {
        return  userDao.updateUser(user);
    }
    public List<User> getAll()
    {
        return  userDao.getAllUser();
    }

/*
    //Get user based on Mobile numbet
    public User getUserByMobile(@RequestBody String mobileNumber )
    {
        return userList
                .stream()
                .filter(u ->u.getMobileNumber()==mobileNumber)
                .findFirst().get();
    }
*/







}

