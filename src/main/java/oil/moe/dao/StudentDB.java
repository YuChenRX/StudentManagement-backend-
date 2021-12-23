package oil.moe.dao;

import oil.moe.dto.student.Student;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface StudentDB extends PagingAndSortingRepository<Student, Long> {

}

