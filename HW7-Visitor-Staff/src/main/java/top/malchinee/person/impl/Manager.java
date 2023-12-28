package top.malchinee.person.impl;// Manager

import top.malchinee.person.Staff;
import top.malchinee.visitor.Visitor;

import java.util.Random;

public class Manager extends Staff {
	private int kpi;// Ա��KPI

    public Manager(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitManager(this);
    }
    public int getKPI(){
		kpi = new Random().nextInt(10);
		return kpi;
	}

    // products finished in one year
    public int getProducts() {
        return new Random().nextInt(10);
    }
}