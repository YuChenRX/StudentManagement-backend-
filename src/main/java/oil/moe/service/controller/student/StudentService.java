package oil.moe.service.controller.student;

import io.swagger.annotations.ApiOperation;
import oil.moe.dao.StudentDB;
import oil.moe.dto.result.RestfulData;
import oil.moe.dto.student.Student;
import oil.moe.service.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@EnableAspectJAutoProxy
@RestController
@RequestMapping("/student")
//@Secured("ROLE_user")
public class StudentService implements BaseController<Student> {
    @Autowired
    StudentDB db;

    static RestfulData restfulData = new RestfulData();

    // get ...
    // method :get
    @Override
    @ApiOperation(value = "this is get student by id", httpMethod = "GET")
    @GetMapping("{id}")
    public Student getById(@PathVariable Long id) {
        Optional<Student> byId = db.findById(id);
        System.out.println(byId);
        return byId.stream().collect(Collectors.toList()).get(0);
    }


    @Override
    @ApiOperation("get all student")
    @GetMapping("")
    public List<Student> getAll(int beginPage,int endPage) {
        System.out.println(beginPage+' '+endPage);
        Page<Student> allStudents = db.findAll(PageRequest.of(beginPage, endPage));
        return allStudents.toList();
    }


    //add
    //method: post
    @ApiOperation("add a student")
    @PostMapping("")
    public Student add(Student student) {
        System.out.println("post.....");
        System.out.println(student);
        Student save = db.save(student);
        return save;
    }

    //delete
    //method:delete


    @Override
    @ApiOperation("delete a student by id")
    @DeleteMapping("/{id}")
    public Student deleteById(@PathVariable Long id) {
        return db.deleteAllById(id);
    }


    //modify

    @ApiOperation("modify student,need all information")
    @PutMapping("/{id}")
    public Object modify(@PathVariable Long id) {
        System.out.println("put");
        if (id == 1) {
            System.out.println(1 / 0);
        }
        return "hello";
    }

    @Override
    @ApiOperation("modify  student,need some information")
    @PatchMapping("/{id}")
    public Student modify(Student student, @PathVariable Long id) {
        return db.save(student);
    }


}
