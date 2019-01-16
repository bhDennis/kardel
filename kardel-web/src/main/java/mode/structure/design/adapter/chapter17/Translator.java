package mode.structure.design.adapter.chapter17;

/**
 * Created by dennis on 2018/3/11.
 */
public class Translator extends AbstractPlayer{

    private ForeignCenter foreignCenter = new ForeignCenter();

    public Translator(String name){
        super(name);
        foreignCenter.setName(name);
    }

    @Override
    void attack() {

        foreignCenter.attack();
    }

    @Override
    void defense() {

        foreignCenter.defense();
    }
}
