package sw6485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase<=TC; testcase++) {
			int N = Integer.parseInt(br.readLine());
			String temp[] = new String[N];
			
			for(int i = 0; i < N; i++) {
				temp[i] = br.readLine();
			}
			HashMap<Integer, Integer> busStop = new HashMap<Integer, Integer>();
			int[]bus = new int[Integer.parseInt(br.readLine())];
			
			for(int i = 0; i < bus.length;i++) {
				bus[i]= Integer.parseInt(br.readLine());
				busStop.put(bus[i], 0);
			}
			for(int i = 0; i < temp.length; i++) {
				String t = temp[i];
				int a = Integer.parseInt(t.split(" ")[0]);
				int b = Integer.parseInt(t.split(" ")[1]);
				for(int j = a; j<=b; j++) {
					if(busStop.containsKey(j)) {
						int v = busStop.get(j);
						v++;
						busStop.replace(j, v);
					}
				}
			}
			
			System.out.print("#"+testcase+" ");
			for(int i = 0; i < bus.length-1; i++) {
				System.out.print(busStop.get(bus[i])+" ");
			}
			System.out.println(busStop.get(bus[bus.length-1]));
		}
	}
}
