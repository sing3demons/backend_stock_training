package com.sing3demons.backend.mapper;

import com.sing3demons.backend.entity.User;
import com.sing3demons.backend.models.MRegisterResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    MRegisterResponse toRegisterResponse(User user);
}
