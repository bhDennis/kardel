package mode.creational.design.prototype.chapter9;

import java.util.Date;

public class Resume implements Cloneable{

    private String name;

    private Integer age;

    private WorkExperience workExperience;

    public Resume(){
        workExperience = new WorkExperience();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public WorkExperience getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Date timeArea,String company){
        this.workExperience.setTimeArea(timeArea);
        this.workExperience.setCompany(company);
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workExperience=" + workExperience +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
