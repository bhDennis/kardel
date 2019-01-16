package mode.creational.design.factory.abstrac.chapter15.database;

import mode.creational.design.factory.abstrac.chapter15.mapper.IUserMapper;
import mode.creational.design.factory.abstrac.chapter15.model.User;

/**
 * Created by dennis on 2018/3/6.
 */
public class SqlServerUserMapper implements IUserMapper {

    @Override
    public void insert(User user) {

        System.out.println("sql server insert user");
    }

    @Override
    public User getById(Integer id) {
        return null;
    }
}
