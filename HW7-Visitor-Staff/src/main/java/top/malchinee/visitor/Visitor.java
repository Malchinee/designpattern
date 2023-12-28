package top.malchinee.visitor;

import top.malchinee.person.impl.Engineer;
import top.malchinee.person.impl.Manager;
import top.malchinee.person.impl.Researcher;

public interface Visitor {

    // ���ʹ���ʦ����
    void visitEngineer(Engineer engineer);

    // ���ʾ�������
    void visitManager(Manager manager);

    //�����о�Ա����
    void visitResearcher(Researcher researcher);
}