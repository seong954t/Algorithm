import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	static int V, E; // V는 트리의 정점의 총 수, E는 트리의 간선의 총 수
	static int find_1, find_2; // 공통의 조상을 찾는 정점 2개
	static int result;
	static HashMap<Integer, Integer> map;// key는 자식, value는 부모
	static HashMap<Integer, Integer> map_temp1;
	static HashMap<Integer, Integer> map_temp2;
	
	static int parent;
	static int child;
	static int find_par1;
	static int find_par2;
	static int count_1; // 가까운 자식을 찾기 위한 count
	static int count_2;
	static boolean escape;
	static int result_count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testnumber = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < testnumber; i++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			find_1 = Integer.parseInt(st.nextToken());
			find_2 = Integer.parseInt(st.nextToken());
			map = new HashMap<>(); // key는 자식, value는 부모
			map_temp1 = new HashMap<>(); 
			map_temp2 = new HashMap<>(); 

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < E; j++) {
				SetTree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			final int temp_par1 = map.get(find_1);
			final int temp_par2 = map.get(find_2);
			find_par1 = 0;
			find_par2 = 0;
			escape = false;
			count_1 = 1;
			count_2 = 1;
			result_count = 1;
			getParents(find_1, find_2, temp_par1, temp_par2);
			
			Set set = map.keySet();

			find_second_result(result, set);
			
			StringBuilder s = new StringBuilder();
			s.append("#").append(i + 1).append(" ");
			
			s.append(result).append(" ").append(result_count);	//뒤에 나오는 숫자는 그것을 루트로 하는 서브 트리의 크기를 뜻하는 2개의 정수
			System.out.println(s);
		}
	}

	public static void SetTree(int parent, int child) {
		map.put(child, parent);
	}

	public static int getParents(int find_1, int find_2, int temp_par1, int temp_par2) {	//공통 부모 찾기
		// 반복문 돌려서 find1을 key로 가지는 value찾기
		if(find_par1 != 1){
			find_par1 = map.get(find_1);
			map_temp1.put(find_par1, find_par1);
		}else{
			map_temp1.put(find_par1, find_par1);
		}
		
		if(find_par2 != 1){
			find_par2 = map.get(find_2);
			map_temp2.put(find_par2, find_par2);
		}else{
			map_temp2.put(find_par2, find_par2);
		}
		
		if(map_temp1.containsKey(find_par2) == true){
			result = find_par2;
			escape = true;
			return result;
		}else if(map_temp2.containsKey(find_par1) == true){
			result = find_par1;
			escape = true;
			return result;
		}
		
		if (temp_par1 != find_par1) {
			count_1++;
		}
		if (temp_par2 != find_par2) {
			count_2++;
		}

		while (find_par1 != find_par2 && escape != true) {
			getParents(find_par1, find_par2, temp_par1, temp_par2);
		}
		return result;

	}
	public static int find_second_result(int result, Set set){	//자식으로 계속 찾아감
		Iterator it = set.iterator();
		int value = 0;
		while(it.hasNext()){
			int key = (int) it.next();
			if(map.get(key) == result){
				value = key;
				result_count++;
				find_second_result(value, set);
			}
		}
		
		return result_count;
		
	}
}
