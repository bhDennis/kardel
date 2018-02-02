package mode.chapter9;

import java.util.Date;

public class ResumeDeepCopy implements Cloneable{

    private String name;

    private Integer age;

    private WorkExperience workExperience;

    public ResumeDeepCopy(){

        workExperience  = new WorkExperience();
    }

    private ResumeDeepCopy(WorkExperience workExperience) throws CloneNotSupportedException {

        this.workExperience = (WorkExperience) workExperience.clone();
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
        return "ResumeDeepCopy{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workExperience=" + workExperience +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        ResumeDeepCopy resumeDeepCopy = new ResumeDeepCopy(this.workExperience);
        resumeDeepCopy.name  = this.name;
        resumeDeepCopy.age = this.age;

        return resumeDeepCopy;
    }
}
