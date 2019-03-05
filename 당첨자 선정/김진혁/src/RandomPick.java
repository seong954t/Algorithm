import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class RandomPick {
    public static void main(String[] args) {
        String[] studyPeople = new String[]{
                "김기환", "김다은", "김미지", "김수연", "김승태", "김진혁", "나재성", "신승혁", "장은정", "최소영"
        };
        String[] beforeWinner = new String[]{
                "김다은", "김승태", "김수연", "김진혁", "최소영"
        };

        int newWinner = 2;

        HashSet<String> peopleSet = makePeopleSet(studyPeople, beforeWinner);


        int[] winner = randomArray(newWinner, peopleSet);

        for(int i =0 ; i < winner.length; i++){
            int j = 0;
            for(String person : peopleSet){
                if(winner[i] == j){
                    System.out.print(person + " ");
                }
                j++;
            }
        }


    }

    private static int[] randomArray(int newWinner, HashSet<String> set) {
        int[] array = new int[newWinner];
        Random random = new Random();

        for(int i = 0; i < array.length; i++){
            array[i] = random.nextInt(set.size());
            for(int j = 0; j < i; j++){
                if(array[i] == array[j]){
                    i--;
                    break;
                }
            }
        }

        return array;
    }

    private static HashSet<String> makePeopleSet(String[] allElement, String[] exceptElement) {
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, allElement);

        for(String before: exceptElement){
            set.remove(before);
        }

        return set;
    }
}
