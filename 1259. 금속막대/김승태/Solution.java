import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T, n, front = 0, end = 0;
        Spiral spiral;
        T = sc.nextInt();
        long ss = System.currentTimeMillis();
        for(int testcase = 1; testcase<=T; testcase++){
            n = sc.nextInt();
            spiral = new Spiral(0, 0);
            for(int i = 0; i<2*n; i++){
                if(i%2 == 0){
                    front = sc.nextInt();
                }else{
                    end = sc.nextInt();
                    spiral.append(new Spiral(front, end));
                }
            }
            System.out.println(String.format("#%d %s", testcase, new SpiralComponent().combination(spiral)));
        }
        System.out.println(System.currentTimeMillis() - ss);

    }

    static class Spiral{
        int front, end;
        Spiral next;
        Spiral(int front, int end){
            this.front = front;
            this.end = end;
        }

        void append(Spiral spiral){
            Spiral temp = this.next;
            this.next = spiral;
            spiral.next = temp;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            Spiral tempSpiral = this;
            while (Objects.nonNull(tempSpiral)){
                stringBuilder.append(tempSpiral.front).append(" ").append(tempSpiral.end).append(" ");
                tempSpiral = tempSpiral.next;
            }
            return stringBuilder.toString();
        }
    }

    static class SpiralComponent{
        Spiral head;
        Spiral tail;

        Spiral combination(Spiral start){
            Spiral tempSpiral, tempHead;
            head = new Spiral(start.next.front, start.next.end);
            tail = head;
            start.next = start.next.next;
            while(Objects.nonNull(start.next)){
                tempSpiral = start;
                while(Objects.nonNull(tempSpiral.next)){
                    if(head.front == tempSpiral.next.end){
                        tempHead = new Spiral(tempSpiral.next.front, tempSpiral.next.end);
                        tempHead.next = head;
                        head = tempHead;
                        tempSpiral.next = tempSpiral.next.next;
                    } else if(tail.end == tempSpiral.next.front){
                        tail.next = new Spiral(tempSpiral.next.front, tempSpiral.next.end);
                        tail = tail.next;
                        tempSpiral.next = tempSpiral.next.next;
                    }
                    if(Objects.nonNull(tempSpiral.next)){
                        tempSpiral = tempSpiral.next;
                    }

                }
            }
            return head;
        }
    }
}
