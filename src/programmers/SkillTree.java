package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(solution(skill, skill_trees));
    }

    public static int solution(String skill, String[] skill_trees) {
        List<String> skillTrees = new ArrayList<>(Arrays.asList(skill_trees));

        skillTrees.removeIf(s -> skill.indexOf(s.replaceAll("[^" + skill + "]", "")) != 0);

        return skillTrees.size();
    }
}
