package mode.creational.design.factory.abstrac.chapter15.model;

import mode.creational.design.factory.abstrac.chapter15.mapper.IDepartmentMapper;
import mode.creational.design.factory.abstrac.chapter15.mapper.IUserMapper;

/**
 * Created by dennis on 2018/3/5.
 */
public interface IFactory {

    IUserMapper createUserMapper();

    IDepartmentMapper createDepartmentMapper();
}
