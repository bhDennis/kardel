package mode.chapter15;

/**
 * Created by dennis on 2018/3/6.
 */
public class SqlServerDepartmentMapper implements IDepartmentMapper{


    @Override
    public void insert(Department department) {
        System.out.println("sql server insert department");
    }

    @Override
    public Department getById(Integer id) {
        return null;
    }
}
