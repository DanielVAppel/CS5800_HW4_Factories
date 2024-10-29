package org.CS5800.factories;

import org.CS5800.enmus.DietPlan;

import java.util.List;
import java.util.Random;

public class CarbsFactory {
    public String getCarb(DietPlan dietPlan) {
        List<String> carbs = switch (dietPlan) {
            case PALEO -> List.of("Pistachio"); // Paleo restricts most carbs except Pistachio
            case VEGAN -> List.of("Bread", "Lentils", "Pistachio");
            case NUT_ALLERGY -> List.of("Cheese", "Bread", "Lentils"); // Excludes Pistachio for nut allergy
            case NO_RESTRICTION -> List.of("Cheese", "Bread", "Lentils", "Pistachio"); // Excludes Pistachio for nut allergy
            default -> throw new IllegalArgumentException("Unknown diet plan: " + dietPlan);
        };

        return carbs.get(new Random().nextInt(carbs.size()));
    }
}