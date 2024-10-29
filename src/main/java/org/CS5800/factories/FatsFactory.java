package org.CS5800.factories;

import org.CS5800.enmus.DietPlan;

import java.util.List;
import java.util.Random;

public class FatsFactory {
    public String getFat(DietPlan dietPlan) {
        List<String> fats = switch (dietPlan) {
            case PALEO -> List.of("Avocado", "Tuna", "Peanuts"); // Paleo excludes Sour cream as it's dairy
            case VEGAN -> List.of("Avocado","Peanuts"); // Vegan diet excludes dairy and animal products
            case NUT_ALLERGY -> List.of("Avocado", "Sour cream", "Tuna"); // Nut allergy excludes Peanuts
            case NO_RESTRICTION -> List.of("Avocado", "Sour cream", "Tuna", "Peanuts");
            default -> throw new IllegalArgumentException("Unknown diet plan: " + dietPlan);
        };

        return fats.get(new Random().nextInt(fats.size()));
    }
}
