package com.example.microservice.mapper;

import com.example.microservice.dto.request.EmployeeDTO;
import com.example.microservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO toDTO(Employee employee);
    Employee toEntity(EmployeeDTO employeeDTO);

    List<EmployeeDTO> toDTOs(List<Employee> employees);
}
