import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] cars1 = {3, -3, 2, -1, 1, 5, -5};
        int[] cars2 = {3, -5, 4, -2, -1};
        int[] result1 = CarCrash(cars1);
        int[] result2 = CarCrash(cars2);
        System.out.print(Arrays.toString(result1));
        System.out.print(Arrays.toString(result2));
    }

    public static int[] CarCrash(int[] cars) {
        ArrayList<Integer> remaining = new ArrayList<>(cars.length);
        
        // Always add the first car
        remaining.add(cars[0]); 

        for (int i = 1; i < cars.length; i++) {
            int current = cars[i];
            
            // Prevents out of bounds exception
            if (remaining.isEmpty()) {
                remaining.add(current);
                continue;
            }

            int previous = remaining.get(remaining.size() - 1);

            // If they are moving in the same direction, add the car
            if (Math.signum(current) == Math.signum(previous)) {
                remaining.add(current);
            } else { 
                // Different direction leads to collision
                if (Math.abs(current) > Math.abs(previous)) {
                    remaining.remove(remaining.size() - 1); // Remove the previous slower car
                    remaining.add(current); // Keep the faster car
                } else if (Math.abs(current) == Math.abs(previous)) {
                    remaining.remove(remaining.size() - 1); // Both are destroyed if same speed
                }
                // Else: if the previous car is stronger, do nothing (it stays)
            }
        }

        // Convert to array for correct return type
        return remaining.stream().mapToInt(Integer::intValue).toArray();
    }
}