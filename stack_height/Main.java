public class Main {
    public static void main(String[] args) {
        int stack1[] = { 1, 2, 4, 5, 3, 4 };
        int stack2[] = { 5, 6, 1, 1, 1, 3, 1, 2 };
        System.out.println(Sum(stack1, stack2));
    }

    public static int Sum(int st1[], int st2[]) {
        int height1 = 0;
        int height2 = 0;
        int loopLength = Math.max(st1.length, st2.length);

        // Calculate Height
        for (int i = 0; i < loopLength; i++) {
            if (i < st1.length) {
                height1 += st1[i];
            }
            if (i < st2.length) {
                height2 += st2[i];
            }
        }

        if (height1 == height2) {
            return height1;
        }
        int st1Index = st1.length - 1;
        int st2Index = st2.length - 1;
        //Balance Height.
        while (height1 != height2) {
            if (height1 > height2) {
                height1 -= st1[st1Index];
                st1[st1Index--] = 0;
            } else if (height2 > height1) {
                height2 -= st2[st2Index];
                st2[st2Index--] = 0;
            }
        }
        return height1;
    }
}
