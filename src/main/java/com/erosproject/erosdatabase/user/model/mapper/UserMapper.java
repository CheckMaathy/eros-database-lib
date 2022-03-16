package com.erosproject.erosdatabase.user.model.mapper;


import com.erosproject.erosdatabase.user.dto.UserDTO;
import com.erosproject.erosdatabase.user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);
}
