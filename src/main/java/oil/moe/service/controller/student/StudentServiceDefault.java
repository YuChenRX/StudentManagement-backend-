package oil.moe.service.controller.student;

import io.swagger.annotations.ApiOperation;
import oil.moe.dao.StudentDB;
import oil.moe.dto.result.RestFulBuilder;
import oil.moe.dto.result.RestFulResult;
import oil.moe.dto.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/student")
@Secured("ROLE_user")
public class StudentServiceDefault {
    @Autowired
    StudentDB db;


    @ApiOperation(value = "this is get student by id", httpMethod = "GET")
    @GetMapping("{id}")
    public Object getStudentById(@PathVariable String id) {

        return new RestFulResult(HttpServletResponse.SC_OK, RestFulBuilder.builder(200, id, "1"));
    }

    @ApiOperation("get all student")
    @GetMapping("")
    public List<Student> getStudents(@NotEmpty Integer beginPage, @NotEmpty Integer limit) {
        return db.findAll(PageRequest.of(beginPage,limit)).toList();
    }


    @ApiOperation("add a student")
    @PostMapping("")
    public boolean postStudent(Student student) {
        return false;
    }

    @ApiOperation("modify  student,need all information")
    @PutMapping("/{id}")
    public boolean putStudent(Student student,@PathVariable Long id) {
        return false;
    }


    @ApiOperation("modify  student,need some information")
    @PatchMapping("/{id}")
    public boolean patchStudent(Student student,@PathVariable Long id) {
        return false;
    }

    @ApiOperation("delete a student")
    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable Long id) {
        return db.deleteByStudentId(id)!=null;
    }
}
