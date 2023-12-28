package top.malchinee.person.impl;// ����ʦ

import top.malchinee.person.Staff;
import top.malchinee.visitor.Visitor;

import java.util.Random;

public class Engineer extends Staff {
	private int kpi;// Ա��KPI

    public Engineer(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitEngineer(this);
    }
    public int getKPI(){
		kpi = new Random().nextInt(10);
		return kpi;
	}
    // ����ʦһ��Ĵ�������
    public int getCodeLines() {
        return new Random().nextInt(100000);
    }
}