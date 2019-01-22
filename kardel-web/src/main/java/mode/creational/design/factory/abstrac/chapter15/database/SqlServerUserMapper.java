package mode.creational.design.factory.abstrac.chapter15.database;

import mode.creational.design.factory.abstrac.chapter15.mapper.IUserMapper;
import mode.creational.design.factory.abstrac.chapter15.model.UserForFactory;

/**
 * Created by dennis on 2018/3/6.
 */
public class SqlServerUserMapper implements IUserMapper {

    @Override
    public void insert(UserForFactory userForFactory) {

        System.out.println("sql server insert userForFactory");
    }

    @Override
    public UserForFactory getById(Integer id) {
        return null;
    }
}
