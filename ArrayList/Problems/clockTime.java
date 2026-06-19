public double angleClock(int hour, int minutes) {
    double ans = Math.abs((hour*30) - (minutes*5.5));

    return ans>360 ? 360-ans : ans;
}

void main() {
    System.out.println(angleClock(3,30));
}