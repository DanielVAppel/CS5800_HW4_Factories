package org.CS5800.factories;

import org.CS5800.enmus.DietPlan;

import java.util.List;
import java.util.Random;

public class ProteinFactory {
    public String getProtein(DietPlan dietPlan) {
        List<String> proteins = switch (dietPlan) {
            case VEGAN -> List.of("Beef", "Tofu"); // Vegan diet excludes animal products
            case PALEO -> List.of("Fish", "Chicken", "Beef"); // Vegan diet excludes animal products
            case NO_RESTRICTION, NUT_ALLERGY -> List.of("Fish", "Chicken", "Beef", "Tofu");
            default -> throw new IllegalArgumentException("Unknown diet plan: " + dietPlan);
        };

        return proteins.get(new Random().nextInt(proteins.size()));
    }
}
