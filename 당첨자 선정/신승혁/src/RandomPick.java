import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
/*스터디원들의 정보와, 이전 당첨자의 정보, 당첨 인원을 통해 새로운 당첨자를 추첨하는 코드를 github에 올려주세요.
(필수는 아니지만, 간단한 내용을 통해 다양한 코드를 접해보는 것이 목적입니다.)*/

/*
 * 총 인원은 12명
 * 선정할 인원은 주차별 5명
 * 지난주에 5명한 사람을 제외한 7명 중 5명에서 선정
 * */

public class RandomPick {
    public static void main(String[] args) {
        String[] members = {"신승혁", "김기환", "김다은", "김미지", "김수연",
                "김승태", "김진혁", "이충완", "장은정", "정진휘", "최소영", "현도훈"};
        List list_member = new ArrayList(Arrays.asList(members));
        int member_size = members.length; // 12

        String[] picked_member = {"김승태", "김다은", "김진혁", "신승혁", "최소영"}; // 2주차

        int pick_size = 5;
        String[] next_member = new String[pick_size]; // 다음주 5명

        // 이미 했던 사람 제외시키기
        for (int i = 0; i < pick_size; i++) {
            list_member.remove(picked_member[i]);
        }
        int rest_member = list_member.size();// 제외한 나머지 7명

        // 나머지 중에서 랜덤으로 5명 뽑기
        Random random = new Random();
        ArrayList<Integer> next_number = new ArrayList<Integer>();       // 중복된 숫자 거르기 위해

        while (true) {
            int random_number = random.nextInt(rest_member);
            if (next_number.size() == pick_size) {
                break;
            }
            if (!next_number.contains(random_number)) {
                next_number.add(random_number);
            }
        }

        // 당첨자 출력
        System.out.println("당첨자 명단");
        System.out.println("---------");
        for (int i =0 ; i<pick_size;i++){
            System.out.println("  "+list_member.get(next_number.get(i)));
        }

    }

}
