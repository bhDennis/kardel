package mode.structure.design.decorator.chapter6;

public class Finery extends Person{

    protected Person component;

    public void decorate(Person component){
        this.component = component;
    }

    public void show(){

        if(component != null){

            component.show();
        }
    }
}
