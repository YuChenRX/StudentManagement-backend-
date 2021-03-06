package oil.moe.dto.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oil.moe.dto.teacher.Teacher;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    public Long id;
    @Column
    public String name;
    @Column
    public Integer age;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id")
    StudentScore score;

    @ManyToMany(cascade = {CascadeType.ALL})
    List<Teacher> teacherList;


    public Student(String name,  Integer age, StudentScore score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", teacher=" + teacherList +
                '}';
    }
}
