package mode.chapter15;

/**
 * Created by dennis on 2018/3/5.
 */
public interface IUserMapper {

    void insert(User user);

    User getById(Integer id);
}
