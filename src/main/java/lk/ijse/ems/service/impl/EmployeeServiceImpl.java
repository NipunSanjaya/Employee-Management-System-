package lk.ijse.ems.service.impl;

import lk.ijse.ems.dto.EmployeeDTO;
import lk.ijse.ems.entity.Employee;
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
}
