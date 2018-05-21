package mode.structure.design.combination.chapter19;

/**
 * Created by dennis on 2018/3/13.
 */
public abstract class Company {

    protected String name;

    public Company(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void add(Company company);

    abstract void remove(Company company);

    abstract void disPlay();
}
