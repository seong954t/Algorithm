package _1218;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int t = 1; t <= 10; t++) {
			int length = Integer.parseInt(br.readLine());

			char[] sentence = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<Character>();
			boolean check = true;

			for (char a : sentence) {
				if (stack.isEmpty()) {
					stack.add(a);
				} else {
					char peek = stack.peek();
					switch (a) {
					case ')':
						if (peek == '(') {
							stack.pop();
						}else {
							check = false;
						}
						break;
					case '>':
						if (peek == '<') {
							stack.pop();
						}else {
							check = false;
						}
						break;
					case ']':
						if (peek == '[') {
							stack.pop();
						}else {
							check = false;
						}
						break;
					case '}':
						if (peek == '{') {
							stack.pop();
						}else {
							check = false;
						}
						break;
					default:
						stack.add(a);
					}
				}
			}
			
			int answer = 0;

			if (stack.isEmpty() && check) {
				answer = 1;
			}
		
			
			bw.write("#" + t + " " + answer + "\n");

		}

		bw.flush();
		bw.close();

	}

}
