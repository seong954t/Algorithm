package al03;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class hole {

	static int hole[][];
	static int visit[][];
	static int count_pipe = 1;

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testnumber = Integer.parseInt(br.readLine());

		for (int i = 0; i < testnumber; i++) {
			int location = 1; // 위치
			// 5 6 2 1 3 [5는 가로 6은 세로 1시간뒤 도달가능 지역(2,1)]
			// 3시간뒤 5개의 지점에 있을 수 있음 정답 : 5
			int[] condition = new int[5];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < condition.length; j++) {
				condition[j] = Integer.parseInt(st.nextToken());
			}

			hole = new int[condition[0]][condition[1]];
			visit = new int[condition[0]][condition[1]];

			for (int j = 0; j < condition[0]; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < condition[1]; k++) {
					hole[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			// 상에는 1,2,5,6
			// 하에는 1,2,4,7
			// 좌에는 1,3,4,5
			// 우에는 1,3,6,7

			/*for (int j = 1; j < condition[4]; j++) {
				set_pipe(hole, condition[2], condition[3]);
				location = location + count_pipe;
			}*/
			if(hole[condition[2]][condition[3]] == 7){
				for(int j = 0; j<4; j++){
					set_pipe(hole, condition[2], condition[3]);
					
				}
			}else{
				for(int j = 0; j<2; j++){
					set_pipe(hole, condition[2], condition[3]);
					
				}
			}
			// hole[condition[2]][condition[3]];

			StringBuilder s = new StringBuilder();
			s.append("#").append(i + 1).append(" ").append(count_pipe);
			System.out.println(s);
		}
	}

	public static void set_pipe(int hole[][], int row, int column) { // 하...이방법이
																		// 맞나...
		if (row > 0 && column > 0) {

			if (hole[row][column] == 1) { // 1번 모양일때
				if (((hole[row - 1][column] == 1) || (hole[row - 1][column] == 2) || (hole[row - 1][column] == 5)
						|| (hole[row - 1][column] == 6)) && visit[row][column] == 0) { // 상
					visit[row][column]++;
					count_pipe++;
					set_pipe(hole, row - 1, column);
				} else if (((hole[row + 1][column] == 1) || (hole[row + 1][column] == 2) || (hole[row + 1][column] == 4)
						|| (hole[row + 1][column] == 7)) && visit[row][column] == 1) { // 하
					visit[row][column]++;
					count_pipe++;
					set_pipe(hole, row + 1, column);
				} else if (((hole[row][column - 1] == 1) || (hole[row][column - 1] == 3) || (hole[row][column - 1] == 4)
						|| (hole[row][column - 1] == 5)) && visit[row][column - 1] == 2) { // 좌
					visit[row][column]++;
					count_pipe++;
					set_pipe(hole, row, column - 1);
				} else if (((hole[row][column + 1] == 1) || (hole[row][column + 1] == 3) || (hole[row][column + 1] == 6)
						|| (hole[row][column + 1] == 7)) && visit[row][column] == 3) { // 우
					visit[row][column]++;
					count_pipe++;
					set_pipe(hole, row, column + 1);
				}
			} else if (hole[row][column] == 2) { // 2번 모양일때
				if (((hole[row - 1][column] == 1) || (hole[row - 1][column] == 2) || (hole[row - 1][column] == 5)
						|| (hole[row - 1][column] == 6)) && visit[row][column] == 0) { // 상
					visit[row][column]++;
					count_pipe++;
					set_pipe(hole, row - 1, column);
				} else if (((hole[row + 1][column] == 1) || (hole[row + 1][column] == 2) || (hole[row + 1][column] == 4)
						|| (hole[row + 1][column] == 7)) && visit[row][column] == 1) { // 하
					visit[row][column]++;
					count_pipe++;
					set_pipe(hole, row + 1, column);
				}
			} else if (hole[row][column] == 3) { // 3번 모양일때
				if (((hole[row][column - 1] == 1) || (hole[row][column - 1] == 3) || (hole[row][column - 1] == 4)
						|| (hole[row][column - 1] == 5)) && visit[row][column] == 0) { // 좌
					visit[row][column]++;
					count_pipe++;
					set_pipe(hole, row, column - 1);
				} else if (((hole[row][column + 1] == 1) || (hole[row][column + 1] == 3) || (hole[row][column + 1] == 6)
						|| (hole[row][column + 1] == 7)) && visit[row][column] == 1) { // 우
					visit[row][column]++;
					count_pipe++;
					set_pipe(hole, row, column + 1);
				}
			} else if (hole[row][column] == 4) { // 4번 모양일때
				if (((hole[row - 1][column] == 1) || (hole[row - 1][column] == 2) || (hole[row - 1][column] == 5)
						|| (hole[row - 1][column] == 6)) && visit[row][column] == 0) { // 상
					visit[row][column]++;
					count_pipe++;
					set_pipe(hole, row - 1, column);
				} else if (((hole[row][column + 1] == 1) || (hole[row][column + 1] == 3) || (hole[row][column + 1] == 6)
						|| (hole[row][column + 1] == 7)) && visit[row][column] == 1) { // 우
					visit[row][column]++;
					count_pipe++;
					set_pipe(hole, row, column + 1);
				}
			} else if (hole[row][column] == 5) { // 5번 모양일때
				if (((hole[row + 1][column] == 1) || (hole[row + 1][column] == 2) || (hole[row + 1][column] == 4)
						|| (hole[row + 1][column] == 7)) && visit[row][column] == 0) { // 하
					visit[row][column]++;
					count_pipe++;
					set_pipe(hole, row + 1, column);
				} else if (((hole[row][column + 1] == 1) || (hole[row][column + 1] == 3) || (hole[row][column + 1] == 6)
						|| (hole[row][column + 1] == 7)) && visit[row][column] == 1) { // 우
					visit[row][column]++;
					count_pipe++;
					set_pipe(hole, row, column + 1);
				}
			} else if (hole[row][column] == 6) { // 6번 모양일때
				if (((hole[row + 1][column] == 1) || (hole[row + 1][column] == 2) || (hole[row + 1][column] == 4)
						|| (hole[row + 1][column] == 7)) && visit[row][column] == 0) { // 하
					visit[row][column]++;
					count_pipe++;
					set_pipe(hole, row + 1, column);
				} else if (((hole[row][column - 1] == 1) || (hole[row][column - 1] == 3) || (hole[row][column - 1] == 4)
						|| (hole[row][column - 1] == 5)) && visit[row][column] == 1) { // 좌
					visit[row][column]++;
					count_pipe++;
					set_pipe(hole, row, column - 1);
				}
			} else if (hole[row][column] == 7) { // 7번 모양일때
				if (((hole[row - 1][column] == 1) || (hole[row - 1][column] == 2) || (hole[row - 1][column] == 5)
						|| (hole[row - 1][column] == 6)) && visit[row][column] == 0) { // 상
					visit[row][column]++;
					count_pipe++;
					set_pipe(hole, row - 1, column);
				} else if (((hole[row][column - 1] == 1) || (hole[row][column - 1] == 3) || (hole[row][column - 1] == 4)
						|| (hole[row][column - 1] == 5)) && visit[row][column] == 1) { // 좌
					visit[row][column]++;
					count_pipe++;
					set_pipe(hole, row, column - 1);
				}
			}
		}/*else{
			set_pipe(hole,row,column);
		}*/
	}

}
