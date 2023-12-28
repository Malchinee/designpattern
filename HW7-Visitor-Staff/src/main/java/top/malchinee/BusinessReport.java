package top.malchinee;// Ա��ҵ�񱨱���
// CompositeStructure��
import top.malchinee.person.Staff;
import top.malchinee.visitor.Visitor;

import java.util.*;

public class BusinessReport {

    private ArrayList<Staff> staff = new ArrayList<>();

    public void attach(Staff s){
		staff.add(s);
	}
    /*
    public BusinessReport() {
       staff.add(new Manager("Manager-A"));
       staff.add(new Engineer("Engineer-A"));
       staff.add(new Engineer("Engineer-B"));
       staff.add(new Engineer("Engineer-C"));
       staff.add(new Manager("Manager-B"));
       staff.add(new Engineer("Engineer-D"));
    }*/

    /**
     * Ϊ������չʾ�������е�Staff����accept������
     * @param visitor ��˾�߲㣬��CEO��CTO
     */
    public void acceptAll(Visitor visitor) {
        for (int k=0; k< staff.size(); k++) {
		    staff.get(k).accept(visitor);
        }
    }
}