public class CalorieCalculator2 {
    public static void main(String[] args) {
        int age = 25;
        int height = 188;
        int weight = 80;

        // Gender: 1 - Male, 2 - Female, 3 - Other
        int gender = 2;
        double bmr = 0;

        // Activity level: 1 - Sedentary, 2 - Lightly Active, 3 - Moderately Active, 4 - Very Active
        int active = 3;

        if (gender == 2) {
            // Calculation BMR for female
            bmr = (10 * weight) + (6.25 * height) - (5 * age) + 5;
        } else {
            // Calculation BMR for male
            bmr = (10 * weight) + (6.25 * height) - (5 * age) + 161;
        }

        double tdee = 0;
        if (active == 1) {
            // Calculation TDEE for Sedentary
            tdee = bmr * 1.2;
        } else if (active == 2) {
            // Calculation TDEE for Lightly Active
            tdee = bmr * 1.375;
        } else if (active == 3) {
            // Calculation TDEE for Moderately Active
            tdee = bmr * 1.55;
        } else if (active == 4) {
            // Calculation TDEE for Very Active
            tdee = bmr * 1.725;
        }

        double targetCaloric = 0;

        // User goal: 1 - Lose Fat, 2 - Gain Weight, 3 - Be Healthier
        int userGoal = 1;
        double caloricFromHealthApp = 500;

        if (userGoal == 1) {
            targetCaloric = tdee - caloricFromHealthApp;
        } else if (userGoal == 2 || userGoal == 3) {
            targetCaloric = tdee + caloricFromHealthApp;
        }

        System.out.println("BMR: " + bmr);
        System.out.println("TDEE: " + tdee);
        System.out.println("Target Caloric: " + targetCaloric);
    }
}
