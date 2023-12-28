package top.malchinee.insurance.impl;

import top.malchinee.insurance.AutoInsurance;

public class Property implements AutoInsurance {
    private String description;

    @Override
    public String getInfo() {
        description = "Property-Damage Liability Coverage: "+
                "This coverage pays for the repair "+
                "and replacement of vehicles and "+
                "other property damaged when you "+
                "or another authorized driver  "+
                "causes an accident";
        return description;
    }
}
