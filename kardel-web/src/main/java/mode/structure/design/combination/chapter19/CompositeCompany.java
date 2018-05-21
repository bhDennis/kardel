package mode.structure.design.combination.chapter19;

import java.util.List;
import java.util.ArrayList;
/**
 * 组合类
 * Created by dennis on 2018/3/13.
 */
public class CompositeCompany extends Company {

    private List<Company> companyList = new ArrayList<Company>();

    public CompositeCompany(String name) {
        super(name);
    }

    @Override
    void add(Company company) {

        companyList.add(company);
    }

    @Override
    void remove(Company company) {

        companyList.remove(company);
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    @Override
    void disPlay() {
        System.out.println(this.name);
        this.companyList.forEach(company -> {
            if(company instanceof CompositeCompany){
                CompositeCompany emp = (CompositeCompany)company;
                if(emp.getCompanyList().size()>0){
                    emp.disPlay();
                }
            }else{
                System.out.println(company.getName());
            }
        });
    }
}
