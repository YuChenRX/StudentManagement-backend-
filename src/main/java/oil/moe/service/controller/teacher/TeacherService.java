package oil.moe.service.controller.teacher;

import io.swagger.annotations.ApiOperation;
import oil.moe.dao.TeacherDB;
import oil.moe.dto.result.RestFulBuilder;
import oil.moe.dto.result.RestFulResult;
import oil.moe.dto.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@Secured("ROLE_user")
public class TeacherService {
    @Autowired
    TeacherDB db;


    @ApiOperation(value = "this is get teacher by id", httpMethod = "GET")
    @GetMapping("{id}")
    public Object getTeacherById(@PathVariable String id) {

        return new RestFulResult(HttpServletResponse.SC_OK, RestFulBuilder.builder(200, id, "1"));
    }

    @ApiOperation("get all teacher")
    @GetMapping("")
    public List<Teacher> getTeachers(@NotEmpty Integer beginPage, @NotEmpty Integer limit) {
        return db.findAll(PageRequest.of(beginPage,limit)).toList();
    }


    @ApiOperation("add a teacher")
    @PostMapping("")
    public boolean postTeacher(Teacher teacher) {
        return false;
    }

    @ApiOperation("modify  teacher,need all information")
    @PutMapping("/{id}")
    public boolean putTeacher(Teacher teacher,@PathVariable Long id) {
        return false;
    }


    @ApiOperation("modify  teacher,need some information")
    @PatchMapping("/{id}")
    public boolean patchTeacher(Teacher teacher,@PathVariable Long id) {
        return false;
    }

    @ApiOperation("delete a teacher")
    @DeleteMapping("/{id}")
    public boolean deleteTeacher(@PathVariable Long id) {
        return db.deleteByTeacherId(id)!=null;
    }
}
