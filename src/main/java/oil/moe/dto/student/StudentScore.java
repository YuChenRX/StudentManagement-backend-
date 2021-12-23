package oil.moe.dto.student;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class StudentScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(mappedBy = "score", fetch = FetchType.LAZY)
    Student student;

    @Column
    Double math;
    @Column
    Double java;
    @Column
    Double mysql;

    @Override
    public String toString() {
        return "StudentScore{" +
                "id=" + id +
                ", math=" + math +
                ", java=" + java +
                ", mysql=" + mysql +
                '}';
    }
}
