package admin.demo.controller;

import admin.demo.exception.DepartmentCollectionException;
import admin.demo.exception.UserCollectionException;
import admin.demo.model.Account;
import admin.demo.model.Department;
import admin.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "demo")
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) throws DepartmentCollectionException{
        return new ResponseEntity<>(departmentService.addDepartment(department), HttpStatus.OK);
    }

    @GetMapping("/getDeptList")
    public List<Department> getDeptList() throws DepartmentCollectionException {
        List<Department> departmentList = departmentService.getDeptList();
        departmentList.forEach(n->System.out.printf(n.getName()));
        return departmentList;
    }

}
