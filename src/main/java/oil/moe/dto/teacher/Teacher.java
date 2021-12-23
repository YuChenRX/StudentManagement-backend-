package oil.moe.dto.teacher;

import oil.moe.dto.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long tId;
    @Column
    String teacherName;

    @ManyToMany
    List<Student> students;

    @Column
    String username;
    @Column
    String password;


    @Override
    public String toString() {
        return "Teacher{" +
                "tId=" + tId +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
