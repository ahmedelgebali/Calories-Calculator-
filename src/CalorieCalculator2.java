public class CalorieCalculator2 {
    public static void main(String[] args) {
        int age = 26;
        int height = 188;
        int weight = 80;
        int gender = 1;             //  1- Male, 2 - Female, 3 - Other
        int activityChoice = 4;     //  1- Sedentary, 2 - Lightly Active, 3 - Moderately Active, 4 - Very Active
        int approachChoice = 3;     //  1- Moderate, 2- Intensive, 3- Balanced
        int goalChoice = 1;         //  1- Lose Fat, 2- Gain Weight, 3- Be Healthier



        double bmr;
        if (gender == 2) {
            // Calculation BMR for female
            bmr = (10 * weight) + (6.25 * height) - (5 * age) - 161;
        } else {
            // Calculation BMR for male
            bmr = (10 * weight) + (6.25 * height) - (5 * age) + 5;

        }



        // Adjust for Activity Level
        double activityFactor = switch (activityChoice) {
            case 1 -> 1.2; // Sedentary
            case 2 -> 1.375; // Lightly Active
            case 3 -> 1.55; // Moderately Active
            case 4 -> 1.725; // Very Active
            default -> 1.2; // Default to Sedentary
        };
        double tdee = bmr * activityFactor;



        // Set Caloric Target Based on Goal
        double targetCalories = tdee;
        switch (goalChoice) {
            case 1: // Lose Fat
                targetCalories = tdee - 500;
                break;
            case 2: // Gain Weight
                targetCalories = tdee + 300; // Starting with +300
                break;
            case 3: // Be Healthier
                targetCalories = tdee; // Maintenance
                break;
        }

        // Modify Based on Approach
        switch (approachChoice) {
            case 1: // Moderate
                break; // No change
            case 2: // Intensive
                targetCalories += (goalChoice == 1) ? -200 : 200;
                break;
            case 3: // Balanced
                targetCalories += (goalChoice == 1) ? -300 : 300;
                break;
        }



        // Display Calories Needed
        System.out.println("BMR: " + bmr);
        System.out.println("TDEE: " + tdee);
        System.out.printf("\n your daily calorie target is %.0f calories/day.%n", targetCalories);

    }
}
