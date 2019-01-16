package mode.creational.design.prototype.chapter9;

import java.util.Date;

public class WorkExperience implements Cloneable{

    private Date timeArea;

    private String company;

    public Date getTimeArea() {
        return timeArea;
    }

    public void setTimeArea(Date timeArea) {
        this.timeArea = timeArea;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "timeArea=" + timeArea +
                ", company='" + company + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
