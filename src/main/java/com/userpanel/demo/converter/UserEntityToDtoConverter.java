package com.userpanel.demo.converter;

import com.userpanel.demo.dto.UserDto;
import com.userpanel.demo.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserEntityToDtoConverter implements Converter<Optional<User> , UserDto> {

    @Override
    public UserDto convert(Optional<User> entity) {
        UserDto userDto = new UserDto();
        userDto.setName(entity.get().getName());
        userDto.setSurname(entity.get().getSurname());
        userDto.setPhone(entity.get().getPhone());
        return userDto;
    }
}
