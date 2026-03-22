package com.example.microservice.service;

import com.example.microservice.dto.request.EmployeeDTO;
import com.example.microservice.entity.Employee;
import com.example.microservice.mapper.EmployeeMapper;
import com.example.microservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repo;

    private final EmployeeMapper mapper = EmployeeMapper.INSTANCE;

    public EmployeeDTO create(EmployeeDTO dto) {
        Employee emp = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(emp));
    }

    public EmployeeDTO save(EmployeeDTO dto) {
        Employee emp = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(emp));
    }

    public List<EmployeeDTO> getAll() {
        return mapper.toDTOs(repo.findAll());
    }

    public EmployeeDTO getById(Long id) {
        return repo.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public EmployeeDTO update(Long id, EmployeeDTO dto) {
        Employee emp = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        emp.setName(dto.getName());
        emp.setSalary(dto.getSalary());
        return mapper.toDTO(repo.save(emp));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
