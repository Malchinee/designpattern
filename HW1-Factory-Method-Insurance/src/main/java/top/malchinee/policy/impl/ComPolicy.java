package top.malchinee.policy.impl;

import top.malchinee.insurance.AutoInsurance;
import top.malchinee.insurance.impl.ComCover;
import top.malchinee.policy.PolicyProducer;

public class ComPolicy implements PolicyProducer {

    public AutoInsurance getAutoObj() {
        return new ComCover();
    }
}
