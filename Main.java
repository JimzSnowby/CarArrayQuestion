import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {    // Entry point
        int[] cars = {3, -3, 2, -1, 1, 5, -5};
        int[] result = CarCrash(cars);
        System.out.print(Arrays.toString(result));
    }

    public static int[] CarCrash(int[] cars)
    {
        ArrayList<Integer> remaining = new ArrayList<>(cars.length);

        for (int i = 1; i < cars.length; i++)
        {
            // Cars of 0 speed don't interact with other cars, so added by default
            if (cars[i] != 0)
            {
                // Check if the cars are driving in opposite directions
                if (Math.signum(cars[i]) != Math.signum(cars[i - 1])) 
                {
                    // Check if the cars are of equal speed, in which case both are destroyed
                    if (Math.abs(cars[i]) != Math.abs(cars[i - 1]))
                    {
                        if (Math.abs(cars[i]) > Math.abs(cars[i - 1])) 
                        {
                            remaining.add(cars[i]);
                        }
                    } else 
                    {
                        // Both cars are destroyed, so we don't add either to the remaining list
                    }
                }
            } else {
                remaining.add(cars[i]);
            }
        }

        // Convert the ArrayList back into an int array, which is the correct return type for this function
        int[] result = remaining.stream().mapToInt(Integer::intValue).toArray();

        return result;
    }
}