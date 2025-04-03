import java.util.ArrayList;
import java.util.Arrays;

/*Car Array Problem

There is a one lane road going West to East.
On this road are cars (represented by an array). Each cars speed can be different (represented by the absolute int value) and can be going in different directions (represented by + or -), for example:
If the array element is 5, the car is going East at a speed of 5.
If the array element is -3, the car is going West at a speed of 3.

With the road only being 1 lane, these cars will crash. Write a function that will output the remaining cars.

Rules:
1. The slower of two cars (elements) is removed from the lane (array).
2. If the cars are moving the same speed in the opposite direction, both are removed.
3. Cars moving the same direction do not interact with one another, regardless of speed.
4. Cars with a value of 0 do not interact with any other car.
5. Do not change return types of functions or classes.

Example Input:
cars [3, -3, 2, -1, 1, 5, -5]
Example Output:
[2, 1]
 */

public class CarCrashArray {
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