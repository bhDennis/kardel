package mode.chapter15;

/**
 * Created by dennis on 2018/3/5.
 */
public interface IDepartmentMapper {

    void insert(Department department);

    Department getById(Integer id);
}