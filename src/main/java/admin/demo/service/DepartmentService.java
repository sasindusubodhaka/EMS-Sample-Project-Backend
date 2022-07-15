package admin.demo.service;

import admin.demo.exception.DepartmentCollectionException;
import admin.demo.model.Department;
import admin.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment(Department department) throws DepartmentCollectionException {
        Department resultDept = departmentRepository.findByName(department.getName());
        if(resultDept==null){
            return departmentRepository.saveAndFlush(department);
        }
        else {
            throw new DepartmentCollectionException(DepartmentCollectionException.DepartmentAlreadyExist());
        }
    }

    public List<Department> getDeptList() {
        List<Department> departmentList = departmentRepository.findAll();
//        departmentList.forEach(n->System.out.printf(n.getName()));
        return departmentList;
    }
}
