package top.malchinee.policy.impl;


import top.malchinee.insurance.AutoInsurance;
import top.malchinee.insurance.impl.Collision;
import top.malchinee.policy.PolicyProducer;

public class CollPolicy implements PolicyProducer {
    public AutoInsurance getAutoObj() {
        return new Collision();
    }
}
