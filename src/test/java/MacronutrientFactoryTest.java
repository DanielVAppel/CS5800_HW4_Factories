import static org.junit.jupiter.api.Assertions.*;

import org.CS5800.enmus.DietPlan;
import org.CS5800.factories.MacronutrientFactory;
import org.junit.jupiter.api.Test;
import java.util.List;

class MacronutrientFactoryTest {

    private final MacronutrientFactory factory = MacronutrientFactory.getInstance();

    @Test
    void testCreateCarbForPaleo() {
        String carb = factory.createCarb(DietPlan.PALEO);
        assertEquals("Pistachio", carb, "For Paleo, the carb option should be 'Pistachio'.");
    }

    @Test
    void testCreateCarbForVegan() {
        String carb = factory.createCarb(DietPlan.VEGAN);
        assertTrue(List.of("Bread", "Lentils", "Pistachio").contains(carb),
                "For Vegan, the carb should be 'Bread', 'Lentils', or 'Pistachio'.");
    }

    @Test
    void testCreateCarbForNutAllergy() {
        String carb = factory.createCarb(DietPlan.NUT_ALLERGY);
        assertTrue(List.of("Cheese", "Bread", "Lentils").contains(carb),
                "For Nut Allergy, the carb should be 'Cheese', 'Bread', or 'Lentils'.");
    }

    @Test
    void testCreateCarbForNoRestriction() {
        String carb = factory.createCarb(DietPlan.NO_RESTRICTION);
        assertTrue(List.of("Cheese", "Bread", "Lentils", "Pistachio").contains(carb),
                "For No Restriction, the carb should be 'Cheese', 'Bread', 'Lentils', or 'Pistachio'.");
    }

    @Test
    void testCreateProteinForPaleo() {
        String protein = factory.createProtein(DietPlan.PALEO);
        assertTrue(List.of("Fish", "Chicken", "Beef").contains(protein),
                "For Paleo, the protein should be 'Fish', 'Chicken', or 'Beef'.");
    }

    @Test
    void testCreateProteinForVegan() {
        String protein = factory.createProtein(DietPlan.VEGAN);
        assertTrue(List.of("Beef", "Tofu").contains(protein),
                "For Vegan, the protein should be 'Beef' or 'Tofu'.");
    }

    @Test
    void testCreateProteinForNutAllergy() {
        String protein = factory.createProtein(DietPlan.NUT_ALLERGY);
        assertTrue(List.of("Fish", "Chicken", "Beef", "Tofu").contains(protein),
                "For Nut Allergy, the protein should be 'Fish', 'Chicken', 'Beef', or 'Tofu'.");
    }

    @Test
    void testCreateProteinForNoRestriction() {
        String protein = factory.createProtein(DietPlan.NO_RESTRICTION);
        assertTrue(List.of("Fish", "Chicken", "Beef", "Tofu").contains(protein),
                "For No Restriction, the protein should be 'Fish', 'Chicken', 'Beef', or 'Tofu'.");
    }

    @Test
    void testCreateFatForPaleo() {
        String fat = factory.createFat(DietPlan.PALEO);
        assertTrue(List.of("Avocado", "Tuna", "Peanuts").contains(fat),
                "For Paleo, the fat should be 'Avocado', 'Tuna', or 'Peanuts'.");
    }

    @Test
    void testCreateFatForVegan() {
        String fat = factory.createFat(DietPlan.VEGAN);
        assertTrue(List.of("Avocado", "Peanuts").contains(fat),
                "For Vegan, the fat should be 'Avocado' or 'Peanuts'.");
    }

    @Test
    void testCreateFatForNutAllergy() {
        String fat = factory.createFat(DietPlan.NUT_ALLERGY);
        assertTrue(List.of("Avocado", "Sour cream", "Tuna").contains(fat),
                "For Nut Allergy, the fat should be 'Avocado', 'Sour cream', or 'Tuna'.");
    }

    @Test
    void testCreateFatForNoRestriction() {
        String fat = factory.createFat(DietPlan.NO_RESTRICTION);
        assertTrue(List.of("Avocado", "Sour cream", "Tuna", "Peanuts").contains(fat),
                "For No Restriction, the fat should be 'Avocado', 'Sour cream', 'Tuna', or 'Peanuts'.");
    }

    @Test
    void testSingletonInstance() {
        MacronutrientFactory factory1 = MacronutrientFactory.getInstance();
        MacronutrientFactory factory2 = MacronutrientFactory.getInstance();
        assertSame(factory1, factory2, "Both instances should be the same due to the Singleton pattern.");
    }
}

