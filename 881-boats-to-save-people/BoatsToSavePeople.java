class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int first = 0;
        int last = people.length - 1;
        int boats = 0;
        while (first < last) {
            if (people[first] + people[last] <= limit) {
                first += 1;
            }
            last -= 1;
            boats += 1;
        }
        return (first == last) ? boats + 1 : boats;
    }
}