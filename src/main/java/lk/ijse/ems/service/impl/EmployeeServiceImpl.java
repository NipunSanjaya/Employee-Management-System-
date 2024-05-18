package lk.ijse.ems.service.impl;

import lk.ijse.ems.dto.EmployeeDTO;
import lk.ijse.ems.entity.Employee;
import lk.ijse.ems.exception.ResourceNotFoundException;
import lk.ijse.ems.mapper.EmployeeMapper;
import lk.ijse.ems.repository.EmployeeRepository;
import lk.ijse.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee saveEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDTO(saveEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("employee is not exists with given id : " + employeeId));
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }
}
