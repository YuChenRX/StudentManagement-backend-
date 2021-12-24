package oil.moe.dao;

import oil.moe.dto.teacher.Teacher;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TeacherDB extends PagingAndSortingRepository<Teacher,Long> {

    Teacher deleteByTeacherId(Long id);
}
