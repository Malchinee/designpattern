package top.malchinee.policy.impl;

import top.malchinee.insurance.AutoInsurance;
import top.malchinee.insurance.impl.LuxeryCarInsurance;
import top.malchinee.policy.PolicyProducer;

public class LuxeryPolicy implements PolicyProducer {
    @Override
    public AutoInsurance getAutoObj() {
        return new LuxeryCarInsurance();
    }
}
