package mode.creational.design.factory.abstrac.chapter15.mapper;

import mode.creational.design.factory.abstrac.chapter15.model.User;

/**
 * Created by dennis on 2018/3/5.
 */
public interface IUserMapper {

    void insert(User user);

    User getById(Integer id);
}
