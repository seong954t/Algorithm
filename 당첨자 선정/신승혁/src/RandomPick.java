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
        String[] members = {"신승혁", "김기환", "김다은", "김승태", "김진혁"};
        List listMember = new ArrayList(Arrays.asList(members));
        int memberSize = members.length; // 5

        String[] pickedMember = {"김다은", "신승혁"}; // 이전에 뽑은 사람

        // 이미 했던 사람 제외시키기
        for (int i = 0; i < pickedMember.length; i++) {
            listMember.remove(pickedMember[i]);
        }
        int restMember = listMember.size();// 제외한 나머지: 3명


        int pickSize = 1; // 몇명 뽑을 건지
        // 나머지 중에서 랜덤으로 1명 뽑기
        Random random = new Random();
        ArrayList<Integer> nextNumber = new ArrayList<>();       // 중복된 숫자 거르기 위해

        while (true) {
            int randomNumber = random.nextInt(restMember);
            if (nextNumber.size() == pickSize) {
                break;
            }
            if (!nextNumber.contains(randomNumber)) {
                nextNumber.add(randomNumber);
            }
        }

        // 당첨자 출력
        System.out.println("당첨자 명단");
        System.out.println("---------");
        for (int i = 0; i < pickSize; i++) {
            System.out.println("  " + listMember.get(nextNumber.get(i)));
        }

    }

}
