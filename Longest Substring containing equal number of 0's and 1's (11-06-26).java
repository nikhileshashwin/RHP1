import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        String str = obj.next();

        int n = str.length();

        int[] first = new int[2 * n + 1];
        Arrays.fill(first, -2);

        int offset = n;

        first[offset] = -1;

        int curr = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {

            if (str.charAt(i) == '1')
                curr++;
            else
                curr--;

            int idx = curr + offset;

            if (first[idx] != -2) {
                max = Math.max(max, i - first[idx]);
            } else {
                first[idx] = i;
            }
        }

        System.out.println(max);
    }
}