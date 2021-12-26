package oil.moe.dto.student;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(mappedBy = "score", fetch = FetchType.LAZY)
    @JsonIgnore
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
