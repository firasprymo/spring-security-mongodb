package com.prymodev.iliwap.mapper;


import com.prymodev.iliwap.DTO.UserDTO;
import com.prymodev.iliwap.entity.AppUser;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends IEntityMapper<UserDTO, AppUser> {

}