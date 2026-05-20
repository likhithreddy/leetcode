class Car {
    private int position;
    private int speed;

    public Car(int position, int speed) {
        setPosition(position);
        setSpeed(speed);
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int pos) {
        this.position = pos;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public float calculateTimeRequired(int target) {
        return (float) (target - this.position) / this.speed;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        Stack<Float> stack = new Stack<>();
        for (int i = 0; i < position.length; i++) {
            cars.add(new Car(position[i], speed[i]));
        }
        cars.sort((a, b) -> Integer.compare(b.getPosition(), a.getPosition()));
        for (Car car : cars) {
            float ctr = car.calculateTimeRequired(target);
            if (stack.isEmpty() || stack.peek() < ctr) {
                stack.push(ctr);
            }

        }
        return stack.size();
    }
}