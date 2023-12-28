package top.malchinee.visitor.impl;
// CTO���Ĵ����������Ʒ����

import top.malchinee.person.impl.Engineer;
import top.malchinee.person.impl.Manager;
import top.malchinee.person.impl.Researcher;
import top.malchinee.visitor.Visitor;

public class CTOVisitor implements Visitor {
    @Override
    public void visitEngineer(Engineer engineer) {
        System.out.println("����ʦ: " + engineer.getName() + ", ��������: " + engineer.getCodeLines());
    }

    @Override
    public void visitManager(Manager manager) {
        System.out.println("����: " + manager.getName() + ", ��Ʒ����: " + manager.getProducts());
    }

    public void visitResearcher(Researcher researcher){
		System.out.println("�о�Ա: " + researcher.getName() + ", ��������: " + researcher.getPapers());

	}
}