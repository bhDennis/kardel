package mode.creational.design.factory.abstrac.chapter15.mapper;

import mode.creational.design.factory.abstrac.chapter15.model.UserForFactory;

/**
 * Created by dennis on 2018/3/5.
 */
public interface IUserMapper {

    void insert(UserForFactory userForFactory);

    UserForFactory getById(Integer id);
}
