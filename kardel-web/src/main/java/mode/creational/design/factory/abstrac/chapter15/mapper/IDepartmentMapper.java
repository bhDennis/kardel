package mode.creational.design.factory.abstrac.chapter15.mapper;

import mode.creational.design.factory.abstrac.chapter15.model.Department;

/**
 * Created by dennis on 2018/3/5.
 */
public interface IDepartmentMapper {

    void insert(Department department);

    Department getById(Integer id);
}
