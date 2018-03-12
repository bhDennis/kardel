package mode.chapter9;

import java.util.Date;

public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException {


        Resume resume = new Resume();
        resume.setName("hzx");
        resume.setAge(22);
        resume.setWorkExperience(new Date(1991,01,11),"ahs");

        Resume resume1 = (Resume)resume.clone();
        resume1.setName("zjj");
        resume1.setAge(23);
        resume1.setWorkExperience(new Date(1992,9,10),"eleme");

        System.out.println(resume.toString());
        System.out.println(resume1.toString()); //这两句输出的workExperience值均是resume1中的workExperience字段值，可见resume和resume1中的workExperience是同一个对象
        System.out.println("workExperience的hashCode:"+resume.getWorkExperience().hashCode()+","+resume1.getWorkExperience().hashCode());


        System.out.println("---上面是浅拷贝，下面是深拷贝--");

        ResumeDeepCopy resumeDeepCopy = new ResumeDeepCopy();
        resumeDeepCopy.setName("hzx");
        resumeDeepCopy.setAge(22);
        resumeDeepCopy.setWorkExperience(new Date(1991,01,11),"ahs");

        ResumeDeepCopy resumeDeepCopy1 = (ResumeDeepCopy)resumeDeepCopy.clone();
        resumeDeepCopy1.setName("zjj2");
        resumeDeepCopy1.setWorkExperience(new Date(1992,9,10),"eleme");
        System.out.println(resumeDeepCopy.toString());
        System.out.println(resumeDeepCopy1.toString());

        System.out.println("workExperience的hashCode:"+resumeDeepCopy.getWorkExperience().hashCode()+","+resumeDeepCopy1.getWorkExperience().hashCode());
    }

}
