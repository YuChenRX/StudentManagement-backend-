package oil.moe.service.controller.student;

import io.swagger.annotations.ApiOperation;
import oil.moe.dao.StudentDB;
import oil.moe.dto.result.RestFulBuilder;
import oil.moe.dto.result.RestFulResult;
import oil.moe.dto.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentService {
    @Autowired
    StudentDB db;

    @ApiOperation(value = "this is get student by id", httpMethod = "GET")
    @GetMapping("/student/{id}")
    public Object getStudentById(@PathVariable String id) {

        return new RestFulResult(HttpServletResponse.SC_OK, RestFulBuilder.builder(200, id, "1"));
    }

    @ApiOperation("get all student")
    @GetMapping("/students")
    public List<Student> getStudents() {
        return null;
    }
}
