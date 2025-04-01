Car Array Problem

There is a one lane road going West to East.
On this road are cars (represented by an array). Each cars speed can be different (represented by the absolute int value) and can be going in different directions (represented by + or -), for example:
If the array element is 5, the car is going East at a speed of 5.
If the array elemtn is -3, the car is going West at a speed of 3.

With the road only being 1 lane, these cars will crash. Write a function that will determine how many cars will remain.

Rules:
1. The slower of two cars (elements) is removed from the lane (array)
2. If the cars are moving the same speed in the opposite direction, both are removed.
3. Cars moving the same direction do not interact with one another, regardless of speed.
4. Cars with a value of 0 do not interact with any other car.