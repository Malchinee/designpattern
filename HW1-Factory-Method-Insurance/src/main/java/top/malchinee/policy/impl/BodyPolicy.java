package top.malchinee.policy.impl;

import top.malchinee.insurance.AutoInsurance;
import top.malchinee.insurance.impl.BodyInjur;
import top.malchinee.policy.PolicyProducer;

public class BodyPolicy implements PolicyProducer {
    public AutoInsurance getAutoObj() {
       return new BodyInjur();
    }
}
