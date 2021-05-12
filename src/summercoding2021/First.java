package summercoding2021;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class First {
    public static void main(String[] args) {

        String[] a = {
                "price=80 code=987654 time=2019062113","price=90 code=012345 time=2019062014","price=120 code=987654 time=2019062010","price=110 code=012345 time=2019062009","price=95 code=012345 time=2019062111"
        };
        int[] temp = solution("012345", "20190620", a);

        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i] + " ");
        }
    }
    public static int[] solution(String code, String day, String[] data) {

        int[] result = new int[data.length];

        List<Data> list = new ArrayList<>();

        for (String item : data) {
            String[] array = item.split(" ");

            List<String> tempArray = new ArrayList<>();
            for (String arrayData : array) {
                String[] temp = arrayData.split("=");

                tempArray.add(temp[1]);
            }


            list.add(new Data(Integer.parseInt(tempArray.get(0)), tempArray.get(1), Integer.parseInt(tempArray.get(2))));
        }

        list.sort(Comparator.comparingInt(Data::getTime));
        int i = 0;
        for (Data item : list) {
            if (code.equals(item.code) && String.valueOf(item.time).contains(day)) {
                result[i++] = item.price;
            }
        }
        int[] answer = new int[i];

        for (int j = 0; j < answer.length; j++) {
            answer[j] = result[j];
        }

        return answer;
    }

    public static class Data {
        int price;
        String code;
        int time;

        Data(int price, String code, int time) {
            this.price = price;
            this.code = code;
            this.time = time;
        }

        @Override
        public String toString() {
            return "[ " + this.price + " " + this.code + " " + this.time + " ]";
        }

        public int getTime() {
            return time;
        }
    }
}
