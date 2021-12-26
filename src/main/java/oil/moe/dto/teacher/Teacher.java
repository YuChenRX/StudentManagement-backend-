package oil.moe.dto.teacher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oil.moe.dto.student.Student;

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
    Long id;
    @Column
    String teacherName;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    List<Student> students;

    @Override
    public String toString() {
        return "Teacher{" +
                "tId=" + id +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
