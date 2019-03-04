import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Solution {

    public static void main(String[] args) {
        List<String> 스터디원 = asList("김기환", "김다은", "김미지", "김수연", "김승태", "김진혁", "나재성", "신승혁", "장은정", "최소영");
        Set<String> 이전당첨자 = new HashSet<>(asList("김다은", "김승태", "김수연", "김진혁", "최소영"));
        List<String> 당첨자 = new ArrayList<>();
        int 당첨인원 = 2;
        List<String> 당첨될스터디원 = 스터디원.stream()
                .filter(n -> !이전당첨자.contains(n))
                .collect(toList());
        ThreadLocalRandom.current().ints(0, 당첨될스터디원.size()).distinct().limit(당첨인원).forEach(n -> {
            당첨자.add(당첨될스터디원.get(n));
        });
        System.out.println(당첨자);
    }
}
