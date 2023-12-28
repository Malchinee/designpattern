package top.malchinee;

import top.malchinee.person.impl.Engineer;
import top.malchinee.person.impl.Manager;
import top.malchinee.person.impl.Researcher;
import top.malchinee.visitor.impl.CEOVisitor;
import top.malchinee.visitor.impl.CTOVisitor;
import top.malchinee.visitor.impl.HRVisitor;

public class Client {

    public static void main(String[] args) {

        BusinessReport report = new BusinessReport();

         report.attach(new Manager("Manager-A"));
		 report.attach(new Engineer("Engineer-A"));
		 report.attach(new Engineer("Engineer-B"));
		 report.attach(new Engineer("Engineer-C"));
		 report.attach(new Manager("Manager-B"));
         report.attach(new Engineer("Engineer-D"));
         report.attach(new Researcher("Anna-Sun"));
         report.attach(new Researcher("Andy-Sun"));



        // ��������
       // BusinessReport report = new BusinessReport();
        System.out.println("=========== CEO������ ===========");
        report.acceptAll(new CEOVisitor());
        System.out.println("=========== CTO������ ===========");
        report.acceptAll(new CTOVisitor());

        System.out.println("=========== HR ������ ===========");
		report.acceptAll(new HRVisitor());
    }
}