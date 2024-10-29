package org.CS5800.main;

import org.CS5800.enmus.DietPlan;
import org.CS5800.factories.MacronutrientFactory;
import org.CS5800.models.Customer;

public class MealDriver {
    public static void main(String[] args) {
        MacronutrientFactory factory = MacronutrientFactory.getInstance();

        Customer[] customers = {
                new Customer("Alice", DietPlan.NO_RESTRICTION),
                new Customer("Timmy", DietPlan.NO_RESTRICTION),
                new Customer("Joe", DietPlan.NO_RESTRICTION),
                new Customer("Bob", DietPlan.PALEO),
                new Customer("Cathy", DietPlan.VEGAN),
                new Customer("Dan", DietPlan.NUT_ALLERGY),
        };

        for (Customer customer : customers) {
            System.out.println(customer.name() + "'s Meal:");
            System.out.println("Carb: " + factory.createCarb(customer.dietPlan()));
            System.out.println("Protein: " + factory.createProtein(customer.dietPlan()));
            System.out.println("Fat: " + factory.createFat(customer.dietPlan()));
            System.out.println();
        }
    }
}
