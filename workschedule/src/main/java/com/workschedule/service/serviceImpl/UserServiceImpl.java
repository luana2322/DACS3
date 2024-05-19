package com.workschedule.service.serviceImpl;

import com.workschedule.Exception.NotFoundException;
import com.workschedule.Exception.ResourceNotFoundException;
import com.workschedule.dto.UserDto;
import com.workschedule.model.Users;
import com.workschedule.repository.UsersRepository;
import com.workschedule.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UsersService {
@Autowired
private UsersRepository usersRepository;

    @Override
    public List<Users> findAll() {
        List<Users> usersList=usersRepository.findAll();
        return usersList;
    }

    @Override
    public Users findById(Long id) {
        if (usersRepository.findById(id) != null) {
            Users users = usersRepository.findById(id).get();
            return users;
        } else {
            return null;
        }
    }

    @Override
    public void deteleById(Long id) {
    }

    @Override
    public Users save(UserDto userDto) {
        Users users=new Users();

        List<Users> usersList=usersRepository.findAll();

        for (Users user : usersList) {
            if(user.getEmail().equals(userDto.getEmaildto())){
                throw new ResourceNotFoundException("Email already exists.");
            }
        }

         if(userDto.getUserName().equals(userDto.getEmaildto())){
    throw new ResourceNotFoundException("Username and email must not be the same.");
        }

        users.setEmail(userDto.getEmaildto());
        users.setPassword(userDto.getPassworddto());
        users.setUserName(userDto.getUserName());
        return usersRepository.save(users);
    }

    @Override
    public Users update(Users users) {
        return null;
    }

    @Override
    public Users login(UserDto userDto) throws NotFoundException {
        List<Users> usersList=findAll();



        for (Users user : usersList) {
            if(user.getEmail().equals(userDto.getEmaildto())
            &&user.getPassword().equals(userDto.getPassworddto())){
                return user;
            }
        }

        throw new ResourceNotFoundException("User with emai "+userDto.getEmaildto()+"not found!!!");
    }
}
