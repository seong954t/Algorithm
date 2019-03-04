import java.util.*;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class main {

    public static void main(String[] args) {
        List<String> 스터디원 = asList("김기환", "김다은", "김미지", "김수연", "김승태", "김진혁", "나재성", "신승혁", "장은정", "최소영");
        Set<String> 이전당첨자 = new HashSet<>(asList("김다은", "김승태", "김수연", "김진혁", "최소영"));
        int 당첨인원 = 2;
        Collections.shuffle(스터디원);
        System.out.println(
                스터디원.stream()
                        .filter(n -> !이전당첨자.contains(n))
                        .limit(당첨인원)
                        .collect(toList()));
    }
}
