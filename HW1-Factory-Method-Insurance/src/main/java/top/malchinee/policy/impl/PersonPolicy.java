package top.malchinee.policy.impl;


import top.malchinee.insurance.AutoInsurance;
import top.malchinee.insurance.impl.PersonInjur;
import top.malchinee.policy.PolicyProducer;

public class PersonPolicy implements PolicyProducer {

   public AutoInsurance getAutoObj() {
      return new PersonInjur();
   }
}
