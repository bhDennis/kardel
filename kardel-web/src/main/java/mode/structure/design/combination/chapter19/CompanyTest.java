package mode.structure.design.combination.chapter19;

/**
 * Created by dennis on 2018/3/13.
 */
public class CompanyTest {

    public static void main(String[] args){

        Company root = new CompositeCompany("北京总公司");

        Company leafA = new LeafCompany("总公司人力资源部");
        Company leafB = new LeafCompany("总公司财务部");
        Company childRenCompanyC = new CompositeCompany("华东分公司");

        root.add(leafA);
        root.add(leafB);
        root.add(childRenCompanyC);

        Company leafCA = new LeafCompany("南京办事处");
        Company leafCB = new LeafCompany("杭州办事处");
        Company leafCC = new LeafCompany("华东分公司人力资源部");
        Company leafCD = new LeafCompany("华东分公司财务部");

        childRenCompanyC.add(leafCC);
        childRenCompanyC.add(leafCD);
        childRenCompanyC.add(leafCA);
        childRenCompanyC.add(leafCB);

        root.disPlay();
    }
}
