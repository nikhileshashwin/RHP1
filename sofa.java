import java.util.*;



class Sofa {

    int fsr, fsc, ssr, ssc;

    char dir;

    int moves;



    public Sofa(int fsr, int fsc, int ssr, int ssc, char d, int m) {

        this.fsr = fsr;

        this.fsc = fsc;

        this.ssr = ssr;

        this.ssc = ssc;

        this.dir = d;

        this.moves = m;

    }

}



public class abc {

    static final String DELIM = "-";

    static int R, C;

    static char[][] grid;



    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;

        R = sc.nextInt();

        C = sc.nextInt();

        grid = new char[R][C];



        int fsr = -1, fsc = -1, ssr = -1, ssc = -1;

        int sofacount = 0;



        for (int row = 0; row < R; row++) {

            for (int col = 0; col < C; col++) {

                char ch = sc.next().charAt(0);

                grid[row][col] = ch;

                if (ch == 's') {

                    sofacount++;

                    if (sofacount == 1) {

                        fsr = row;

                        fsc = col;

                    } else if (sofacount == 2) {

                        ssr = row;

                        ssc = col;

                    }

                }

            }

        }



        Queue<Sofa> q = new LinkedList<>();

        Set<String> vis = new HashSet<>();



        if (sofacount == 2) {

            char initialDir = (fsr == ssr) ? 'H' : 'V';

            Sofa s = new Sofa(fsr, fsc, ssr, ssc, initialDir, 0);

            q.add(s);

            vis.add(fsr + DELIM + fsc + DELIM + ssr + DELIM + ssc);

        }



        while (!q.isEmpty()) {

            Sofa s = q.poll();



            if (grid[s.fsr][s.fsc] == 'S' && grid[s.ssr][s.ssc] == 'S') {

                System.out.println(s.moves);

                return;

            }



            if (s.dir == 'H') {

                if (s.ssc < C - 1 && grid[s.ssr][s.ssc + 1] != 'H') {

                    if (canAdd(s.ssr, s.ssc, s.ssr, s.ssc + 1, vis)) {

                        q.add(new Sofa(s.ssr, s.ssc, s.ssr, s.ssc + 1, 'H', s.moves + 1));

                    }

                }

                if (s.fsc > 0 && grid[s.fsr][s.fsc - 1] != 'H') {

                    if (canAdd(s.fsr, s.fsc - 1, s.fsr, s.fsc, vis)) {

                        q.add(new Sofa(s.fsr, s.fsc - 1, s.fsr, s.fsc, 'H', s.moves + 1));

                    }

                }

                if (s.fsr > 0 && grid[s.fsr - 1][s.fsc] != 'H' && grid[s.ssr - 1][s.ssc] != 'H') {

                    if (canAdd(s.fsr - 1, s.fsc, s.ssr - 1, s.ssc, vis)) {

                        q.add(new Sofa(s.fsr - 1, s.fsc, s.ssr - 1, s.ssc, 'H', s.moves + 1));

                    }

                }

                if (s.fsr < R - 1 && grid[s.fsr + 1][s.fsc] != 'H' && grid[s.ssr + 1][s.ssc] != 'H') {

                    if (canAdd(s.fsr + 1, s.fsc, s.ssr + 1, s.ssc, vis)) {

                        q.add(new Sofa(s.fsr + 1, s.fsc, s.ssr + 1, s.ssc, 'H', s.moves + 1));

                    }

                }

                if (s.fsr > 0 && grid[s.fsr - 1][s.fsc] != 'H' && grid[s.ssr - 1][s.ssc] != 'H') {

                    if (canAdd(s.fsr - 1, s.fsc, s.fsr, s.fsc, vis)) {

                        q.add(new Sofa(s.fsr - 1, s.fsc, s.fsr, s.fsc, 'V', s.moves + 1));

                    }

                    if (canAdd(s.ssr - 1, s.ssc, s.ssr, s.ssc, vis)) {

                        q.add(new Sofa(s.ssr - 1, s.ssc, s.ssr, s.ssc, 'V', s.moves + 1));

                    }

                }

                if (s.fsr < R - 1 && grid[s.fsr + 1][s.fsc] != 'H' && grid[s.ssr + 1][s.ssc] != 'H') {

                    if (canAdd(s.fsr, s.fsc, s.fsr + 1, s.fsc, vis)) {

                        q.add(new Sofa(s.fsr, s.fsc, s.fsr + 1, s.fsc, 'V', s.moves + 1));

                    }

                    if (canAdd(s.ssr, s.ssc, s.ssr + 1, s.ssc, vis)) {

                        q.add(new Sofa(s.ssr, s.ssc, s.ssr + 1, s.ssc, 'V', s.moves + 1));

                    }

                }

            } else {

                if (s.ssr < R - 1 && grid[s.ssr + 1][s.ssc] != 'H') {

                    if (canAdd(s.ssr, s.ssc, s.ssr + 1, s.ssc, vis)) {

                        q.add(new Sofa(s.ssr, s.ssc, s.ssr + 1, s.ssc, 'V', s.moves + 1));

                    }

                }

                if (s.fsr > 0 && grid[s.fsr - 1][s.fsc] != 'H') {

                    if (canAdd(s.fsr - 1, s.fsc, s.fsr, s.fsc, vis)) {

                        q.add(new Sofa(s.fsr - 1, s.fsc, s.fsr, s.fsc, 'V', s.moves + 1));

                    }

                }

                if (s.fsc > 0 && grid[s.fsr][s.fsc - 1] != 'H' && grid[s.ssr][s.ssc - 1] != 'H') {

                    if (canAdd(s.fsr, s.fsc - 1, s.ssr, s.ssc - 1, vis)) {

                        q.add(new Sofa(s.fsr, s.fsc - 1, s.ssr, s.ssc - 1, 'V', s.moves + 1));

                    }

                }

                if (s.ssc < C - 1 && grid[s.fsr][s.fsc + 1] != 'H' && grid[s.ssr][s.ssc + 1] != 'H') {

                    if (canAdd(s.fsr, s.fsc + 1, s.ssr, s.ssc + 1, vis)) {

                        q.add(new Sofa(s.fsr, s.fsc + 1, s.ssr, s.ssc + 1, 'V', s.moves + 1));

                    }

                }

                if (s.fsc > 0 && grid[s.fsr][s.fsc - 1] != 'H' && grid[s.ssr][s.ssc - 1] != 'H') {

                    if (canAdd(s.fsr, s.fsc - 1, s.fsr, s.fsc, vis)) {

                        q.add(new Sofa(s.fsr, s.fsc - 1, s.fsr, s.fsc, 'H', s.moves + 1));

                    }

                    if (canAdd(s.ssr, s.ssc - 1, s.ssr, s.ssc, vis)) {

                        q.add(new Sofa(s.ssr, s.ssc - 1, s.ssr, s.ssc, 'H', s.moves + 1));

                    }

                }

                if (s.ssc < C - 1 && grid[s.fsr][s.fsc + 1] != 'H' && grid[s.ssr][s.ssc + 1] != 'H') {

                    if (canAdd(s.fsr, s.fsc, s.fsr, s.fsc + 1, vis)) {

                        q.add(new Sofa(s.fsr, s.fsc, s.fsr, s.fsc + 1, 'H', s.moves + 1));

                    }

                    if (canAdd(s.ssr, s.ssc, s.ssr, s.ssc + 1, vis)) {

                        q.add(new Sofa(s.ssr, s.ssc, s.ssr, s.ssc + 1, 'H', s.moves + 1));

                    }

                }

            }

        }

        System.out.println("Impossible");

    }



    private static boolean canAdd(int fsr, int fsc, int ssr, int ssc, Set<String> vis) {

        String key = fsr + DELIM + fsc + DELIM + ssr + DELIM + ssc;

        if (vis.contains(key)) {

            return false;

        }

        vis.add(key);

        return true;

    }
