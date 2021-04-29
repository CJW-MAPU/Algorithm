package TICT;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class page180 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());

        List<Student> list = new ArrayList<>();

        for (int i = 0; i < input; i++) {
            Student student = new Student(br.readLine().split(" "));
            list.add(student);
        }

        list.sort(Comparator.comparingInt(Student::getScore));

        for (Student item :
                list) {
            bw.write(item.getName() + " ");
        }

        bw.flush();
        bw.close();
    }
}

class Student {
    private String name;
    private Integer score;

    Student(String[] input) {
        this.name = input[0];
        this.score = Integer.parseInt(input[1]);
    }

    public Integer getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name + " " + this.score;
    }
}
