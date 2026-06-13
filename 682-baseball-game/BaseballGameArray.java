class Solution {
    public int calPoints(String[] operations) {
        int[] points = new int[operations.length];
        int idx = 0;
        for (String op : operations) {
            if (op.equals("+")) {
                points[idx] = points[idx - 1] + points[idx - 2];
            } else if (op.equals("D")) {
                points[idx] = 2 * points[idx - 1];
            } else if (op.equals("C")) {
                points[idx - 1] = 0;
                idx -= 2;
            } else {
                points[idx] = Integer.parseInt(op);
            }
            idx += 1;
        }
        int result = 0;
        for (int point : points) {
            result += point;
        }
        return result;
    }
}