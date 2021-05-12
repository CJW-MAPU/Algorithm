package summercoding2021;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Second {
    public static void main(String[] args) {
        int[] t  = {
//                0,1,3,0
                7,6,8,1
        };

        int[] r = {
                0,1,2,3
        };

        int[] a = solution(t, r);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static int[] solution(int[] t, int[] r) {
        int[] answer = new int[t.length];

        List<Human> list = new ArrayList<>();

        for (int i = 0; i < t.length; i++) {
            list.add(new Human(i, t[i], r[i]));
        }

        list.sort(Comparator.comparingInt(Human::getT));

        PriorityQueue<Human> queue = new PriorityQueue<>();

        int count = list.get(0).t;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(0).t == count) {
                queue.add(list.get(0));
                list.remove(0);
            } else {
                break;
            }
        }

        int i = 0;

        while (true) {
//            System.out.println(queue);

            while (!queue.isEmpty()) {
//                System.out.println(queue);
                Human human = queue.poll();
                answer[i++] = human.num;

                for (int j = 0; j < list.size(); j++) {
                    if (list.get(0).t == count) {
                        queue.add(list.get(0));
                        list.remove(0);
                    } else {
                        break;
                    }
                }

                count++;

                if (!list.isEmpty()) {
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(0).t == count) {
                            queue.add(list.get(0));
                            list.remove(0);
                        } else {
                            break;
                        }
                    }
                }
            }

            if (!list.isEmpty()) {
                while (queue.isEmpty()) {
                    count++;

                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(0).t == count) {
                            queue.add(list.get(0));
                            list.remove(0);
                        } else {
                            break;
                        }
                    }
                }
            } else {
                break;
            }
        }

        return answer;
    }

    public static class Human implements Comparable<Human> {
        int num;
        int t;
        int r;

        Human(int num, int t, int r) {
            this.num = num;
            this.t = t;
            this.r = r;
        }

        @Override
        public int compareTo(Human o) {
            return this.r - o.r;
        }

        @Override
        public String toString() {
            return "[ " + t + " " + r + " ]";
        }

        public int getT() {
            return t;
        }
    }
}
