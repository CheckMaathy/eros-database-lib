package com.erosproject.database.user.model.mapper;


import com.erosproject.database.user.model.User;
import com.erosproject.database.user.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);
}
