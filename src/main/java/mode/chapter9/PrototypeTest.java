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
        resume1.setWorkExperience(new Date(1992,9,10),"eleme");

        System.out.println(resume.toString());
        System.out.println(resume1.toString());

        System.out.println("---上面是浅拷贝，下面是深拷贝--");

        ResumeDeepCopy resumeDeepCopy = new ResumeDeepCopy();
        resumeDeepCopy.setName("hzx");
        resumeDeepCopy.setAge(22);
        resumeDeepCopy.setWorkExperience(new Date(1991,01,11),"ahs");


        ResumeDeepCopy resumeDeepCopy1 = (ResumeDeepCopy)resumeDeepCopy.clone();
        resumeDeepCopy1.setWorkExperience(new Date(1992,9,10),"eleme");
        System.out.println(resumeDeepCopy.toString());
        System.out.println(resumeDeepCopy1.toString());
    }

}
