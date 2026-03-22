package com.example.microservice.controller;

import com.example.microservice.dto.request.EmployeeDTO;
import com.example.microservice.entity.Employee;
import com.example.microservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

    private final RestTemplate restTemplate = new RestTemplate();

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/emp")
    public List<EmployeeDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/emp/{id}")
    public EmployeeDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/emp")
    public EmployeeDTO create(@RequestBody EmployeeDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public EmployeeDTO update(@PathVariable Long id, @RequestBody EmployeeDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}