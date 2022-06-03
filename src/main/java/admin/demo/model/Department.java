package admin.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @SequenceGenerator(
            name = "department_dept_id_seq",
            sequenceName = "department_dept_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_dept_id_seq"
    )
    @Column(name = "dept_id")
    private Integer departmentId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
