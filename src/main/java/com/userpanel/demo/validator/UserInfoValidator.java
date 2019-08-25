package com.userpanel.demo.validator;

import com.userpanel.demo.dto.UserDto;
import com.userpanel.demo.exception.MissingMandatoryFieldException;
import org.springframework.stereotype.Component;

@Component
public class UserInfoValidator {
    public void validate(UserDto userDto) {
        if (userDto == null || userDto.getName() == null || userDto.getSurname() == null
                || userDto.getPhone() == null){
            throw  new MissingMandatoryFieldException("missing.field");
        }

    }
}
