package sw5550;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testcase; tc++) {
			String temp = br.readLine();
			char[] comp = temp.toCharArray();
			ArrayList<LinkedList<Character>> array = new ArrayList<LinkedList<Character>>();
			boolean realCheck = false;
			boolean kinput = false;
			for (char c : comp) {
				if (c == 'c') {
					boolean check = false;
					LinkedList<Character> t = new LinkedList<Character>();
					for (int i = 0; i < array.size(); i++) {
						if (array.get(i).getLast().equals('k')) {
							array.get(i).add('c');
							check = true;
							break;
						}
					}
					if (!check) {
						t.add(c);
						array.add(t);
					}
				} else if (c == 'r') {
					for (int i = 0; i < array.size(); i++) {
						if (array.get(i).getLast().equals('c')) {
							array.get(i).add('r');
							break;
						}

					}
				} else if (c == 'o') {
					for (int i = 0; i < array.size(); i++) {
						if (array.get(i).getLast().equals('r')) {
							array.get(i).add('o');
							break;
						}
					}
				} else if (c == 'a') {
					for (int i = 0; i < array.size(); i++) {
						if (array.get(i).getLast().equals('o')) {
							array.get(i).add('a');
							break;
						}

					}
				} else if (c == 'k') {
					kinput= false;
					for (int i = 0; i < array.size(); i++) {
						if (array.get(i).getLast().equals('a')) {
							array.get(i).add('k');
							kinput = true;
							break;
						}
					}
					if(!kinput) {
						break;
					}
				}
			}
			int count = 0;
			int size = 0;
			for (LinkedList l : array) {
				if (l.size() % 5 == 0) {
					count++;
					size += l.size();
				} else {
					count = -1;
					break;
				}
			}
			if(size != comp.length) {
				count = -1;
			}
			if(!kinput)count = -1;
			System.out.println("#" + tc + " " + (count));
		}
	}
}
