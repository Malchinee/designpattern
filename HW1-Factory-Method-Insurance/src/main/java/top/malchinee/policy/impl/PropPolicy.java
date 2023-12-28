package top.malchinee.policy.impl;

import top.malchinee.insurance.AutoInsurance;
import top.malchinee.insurance.impl.Property;
import top.malchinee.policy.PolicyProducer;

public class PropPolicy implements PolicyProducer {
    @Override
    public AutoInsurance getAutoObj() {
        return new Property();
    }
}
