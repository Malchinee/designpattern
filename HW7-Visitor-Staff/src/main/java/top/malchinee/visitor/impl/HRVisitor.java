package top.malchinee.visitor.impl;

import top.malchinee.person.impl.Engineer;
import top.malchinee.person.impl.Manager;
import top.malchinee.person.impl.Researcher;
import top.malchinee.visitor.Visitor;

public class HRVisitor implements Visitor {
    @Override
    public void visitEngineer(Engineer engineer) {
        System.out.println("Engineer:" + engineer.getName() + " KPI:" + engineer.getKPI()+
                " 代码行数:" + engineer.getCodeLines());
    }

    @Override
    public void visitManager(Manager manager) {
        System.out.println("Manager:" + manager.getName() + " KPI:" + manager.getKPI() +
                " 产品数:" + manager.getProducts());
    }

    public void visitResearcher(Researcher researcher){
        System.out.println("Researcher:" + researcher.getName() + " KPI:" + researcher.getKPI()+
                " 论文数:" + researcher.getPapers()+" 专利数:"+researcher.getPatents()+
                " 产品数:"+researcher.getProjects());
    }
}