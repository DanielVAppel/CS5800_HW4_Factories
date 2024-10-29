package org.CS5800.factories;

import org.CS5800.enmus.DietPlan;

public class MacronutrientFactory {
    private static MacronutrientFactory instance;
    private final CarbsFactory carbsFactory;
    private final ProteinFactory proteinFactory;
    private final FatsFactory fatsFactory;

    private MacronutrientFactory() {
        carbsFactory = new CarbsFactory();
        proteinFactory = new ProteinFactory();
        fatsFactory = new FatsFactory();
    }

    public static MacronutrientFactory getInstance() {
        if (instance == null) {
            instance = new MacronutrientFactory();
        }
        return instance;
    }

    public String createCarb(DietPlan dietPlan) {
        return carbsFactory.getCarb(dietPlan);
    }

    public String createProtein(DietPlan dietPlan) {
        return proteinFactory.getProtein(dietPlan);
    }

    public String createFat(DietPlan dietPlan) {
        return fatsFactory.getFat(dietPlan);
    }
}
