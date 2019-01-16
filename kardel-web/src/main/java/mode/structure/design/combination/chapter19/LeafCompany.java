package mode.structure.design.combination.chapter19;

/**
 * Created by dennis on 2018/3/13.
 */
public class LeafCompany extends Company{


    public LeafCompany(String name){
        super(name);
    }

    @Override
    void add(Company company){

        try {
            throw new Exception("不支持添加");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    void remove(Company company) {

        try {
            throw new Exception("不支持移除");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    void disPlay() {
       System.out.println(name);
    }
}
