package mode.creational.design.factory.abstrac.chapter15;

import mode.creational.design.factory.abstrac.chapter15.mapper.IUserMapper;
import mode.creational.design.factory.abstrac.chapter15.mapper.IDepartmentMapper;

/**
 * Created by dennis on 2018/3/6.
 */
public class DataAccess {

    private static final String classPackage = "mode.creational.design.pattern.factory.chapter15.database.";

    private static final String dbName = "SqlServer"; //如果采用spring可以从配置文件里读

    public static IUserMapper createUserMapper() throws Exception {

        String className = classPackage + dbName + "UserMapper";

        return (IUserMapper)Class.forName(className).newInstance();
    }

    public static IDepartmentMapper createDepartmentMapper() throws Exception {

        String className = classPackage + dbName + "DepartmentMapper";

        return (IDepartmentMapper)Class.forName(className).newInstance();
    }
}
