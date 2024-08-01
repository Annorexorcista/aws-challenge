package com.example.demo.adapters.driving.http.mapper;

import com.example.demo.adapters.driving.http.dto.request.UserRequest;
import com.example.demo.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IUserRequestMapper {

    @Mapping(target = "id", ignore = true)
    User toUser(UserRequest userRequest);
}
