class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid < 0) {
                while (!stack.isEmpty() && stack.peek() > 0 && asteroid + stack.peek() < 0) {
                    stack.pop();
                }
                if (!stack.isEmpty() && asteroid + stack.peek() == 0) {
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
            } else {
                stack.push(asteroid);
            }
        }
        int size = stack.size();
        int[] survivedAsteroids = new int[size];
        while (size > 0) {
            survivedAsteroids[--size] = stack.pop();
        }
        return survivedAsteroids;
    }
}