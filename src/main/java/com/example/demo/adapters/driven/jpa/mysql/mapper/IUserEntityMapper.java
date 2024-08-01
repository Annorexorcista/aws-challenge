package com.example.demo.adapters.driven.jpa.mysql.mapper;

import com.example.demo.adapters.driven.jpa.mysql.entity.UserEntity;
import com.example.demo.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IUserEntityMapper {
    UserEntity toEntity(User user);
    User toUser(UserEntity userEntity);
}
