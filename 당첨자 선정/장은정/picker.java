import java.util.ArrayList;
import java.util.Arrays;

public class picker {

	public static void main(String[] args) {

		ArrayList<String> studymates = new ArrayList<String>(
				Arrays.asList("김기환", "김다은", "김미지", "김수연", "김승태", "김진혁", "나재성", "신승혁", "장은정", "최소영"));
		ArrayList<String> previousSelectors = new ArrayList<String>(Arrays.asList("김다은", "김승태", "김수연", "김진혁", "최소영"));
		ArrayList<String> newSelectors = new ArrayList<String>();
		int selectCount = 3, counter=0;
        
        //  세 명 뽑기
		while(counter!=selectCount) {
			String student = getRandomStudymate(studymates);
			if(selectorValidation(previousSelectors, newSelectors, student)) {
				newSelectors.add(student);
				counter++;
			}
		}

		for(String selector : newSelectors) {
			System.out.println(selector);
		}

	}
	
	//	전체 스터디원 중에서 랜덤한 스터디원을 뽑는 함수
	public static String getRandomStudymate(ArrayList<String> studymates) {
		return studymates.get((int) (Math.random()*studymates.size()));
	}
	
	//	현재 문제 선정자 리스트에 들어갈 수 있는 지 가능 여부 체크하는 함수
	public static boolean selectorValidation(ArrayList<String> prev, ArrayList<String> cur, String student) {
		//	이전 문제 선정자 리스트와 현재 문제 선정자 리스트에 해당 학생이 없다면 true
		if((!prev.contains(student))&& (!cur.contains(student)))
			return true; 
		else
			return false;
	}

}