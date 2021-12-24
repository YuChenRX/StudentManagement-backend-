package oil.moe.dao;

import oil.moe.dto.student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface StudentDB extends PagingAndSortingRepository<Student, Long> {
    Page<Student> findAll(Pageable pageable);
    Student deleteByStudentId(Long id);
}

