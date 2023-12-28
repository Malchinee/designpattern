package top.malchinee.person.impl;// Researcher

import top.malchinee.person.Staff;
import top.malchinee.visitor.Visitor;

import java.util.Random;

public class Researcher extends Staff {

	private int kpi;// Ա��KPI

    public Researcher(String name) {
        super(name);
    }
    public int getKPI(){
		kpi = new Random().nextInt(10);
		return kpi;
	}

    @Override
    public void accept(Visitor visitor) {
        visitor.visitResearcher(this);
    }
    // number of papers published in one year
    public int getPapers(){
		return new Random().nextInt(50);
	}
	// number of projects finished in one year
	public int getProjects(){
		return new Random().nextInt(5);
	}
	// number of patents registered in one year
	public int getPatents(){
		return new Random().nextInt(5);
	}
}