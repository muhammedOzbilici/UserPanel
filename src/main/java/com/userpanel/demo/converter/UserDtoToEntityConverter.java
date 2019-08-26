package com.userpanel.demo.converter;

import com.userpanel.demo.dto.UserDto;
import com.userpanel.demo.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToEntityConverter implements Converter<UserDto, User> {

    @Override
    public User convert(UserDto userDto) {

        User entity = new User();
        entity.setName(userDto.getName());
        entity.setSurname(userDto.getSurname());
        entity.setPhone(userDto.getPhone());

        return entity;
    }
}
