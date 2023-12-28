package top.malchinee.insurance.impl;

import top.malchinee.insurance.AutoInsurance;

public class LuxeryCarInsurance implements AutoInsurance {

    private String description;
    @Override
    public String getInfo() {
        description = "LuxeryCarInsurance...";
        return description;
    }
}
