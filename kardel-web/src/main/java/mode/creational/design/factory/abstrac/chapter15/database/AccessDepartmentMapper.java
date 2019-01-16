package mode.creational.design.factory.abstrac.chapter15.database;

import mode.creational.design.factory.abstrac.chapter15.mapper.IDepartmentMapper;
import mode.creational.design.factory.abstrac.chapter15.model.Department;

/**
 * Created by dennis on 2018/3/6.
 */
public class AccessDepartmentMapper implements IDepartmentMapper {


    @Override
    public void insert(Department department) {
        System.out.println("access insert department");
    }

    @Override
    public Department getById(Integer id) {
        return null;
    }
}
