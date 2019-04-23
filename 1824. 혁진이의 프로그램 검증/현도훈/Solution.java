import java.util.Random;
import java.util.Scanner;

public class Solution {
    static String direction = ">";
    static String[][] programInput;
    static String temp;
    static int x = 0;
    static int y = 0;

    public static void main(String[] args) {
        int caseNumber;
        String input;
        String[] programSize;

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        caseNumber = sc.nextInt();

        for(int cycletime=0; cycletime<caseNumber; cycletime++) {
            sc.nextLine();
            input = sc.nextLine();
            programSize = input.split(" ");

            programInput = new String[Integer.valueOf(programSize[0])][Integer.valueOf(programSize[1])];
            input = sc.next();
            programInput[0] = input.split("");
            input = sc.next();
            programInput[1] = input.split("");

            x=0;
            y=0;
            temp = programInput[x][y];
            int memory=0;

            int cycle = 0;
            boolean endpoint = false;
            while(!endpoint) {
                switch(temp) {
                    case "<":
                        direction = "<";
                        move();
                        break;
                    case ">":
                        direction = ">";
                        move();
                        break;
                    case "^":
                        direction = "^";
                        move();
                        break;
                    case "v":
                        direction = "v";
                        move();
                        break;
                    case "_":
                        if(memory==0) direction = ">";
                        else direction = "<";
                        move();
                        break;
                    case "|":
                        if(memory==0) direction = "v";
                        else direction = "^";
                        move();
                        break;
                    case "?": //배열 상황에 맞춰서 움직여야한다.
                        //programsize[0], programsize[1], x, y

                        boolean canGo = false;
                        int randomValue = 0;// 1~4 까지의 숫자로 무작위 설정
                        while(!canGo) {
                            randomValue = random.nextInt(4) +1;
                            if(x==0 && randomValue==3) {

                            } else if(x==Integer.valueOf(programSize[0])-1 && randomValue==4) {

                            } else if(y==0 && randomValue==1) {

                            } else if(y==Integer.valueOf(programSize[1])-1 && randomValue==2) {

                            } else {
                                canGo = true;
                            }
                        }
                        if(randomValue == 1) direction = "<";
                        else if(randomValue == 2) direction = ">";
                        else if(randomValue == 3) direction = "^";
                        else if(randomValue == 4) direction = "v";
                        move();
                        break;
                    case ".":
                        move();
                        break;
                    case "@":
                        System.out.println("#" + (cycletime+1) + " YES");
                        endpoint = true;
                        break;
                    case "+":
                        if(memory == 15) memory = 0;
                        else memory++;
                        move();
                        break;
                    case "-":
                        if(memory == 0) memory = 15;
                        else memory--;
                        move();
                        break;
                    default:
                        memory = Integer.valueOf(temp);
                        move();
                        break;
                }

                cycle++;
                if(cycle > 300) {
                    System.out.println("#" + (cycletime+1) + " NO");
                    break;
                }
            }
        }
    }

    private static void move() {
        if(direction.equals(">")) {
            temp = programInput[x][++y];
        } else if(direction.equals("<")) {
            temp = programInput[x][--y];
        } else if(direction.equals("^")) {
            temp = programInput[--x][y];
        } else if(direction.equals("v")) {
            temp = programInput[++x][y];
        }
    }
}
