# 1259. 금속막대

## 문제 접근 방법
------------------------------
1. 항상 암-수 나사의 형태로 두 나사가 연결되어야 한다. (암,수의 굵기를 한 객체에 저장하자)
2. 그렇다면 한 나사를 기점으로 뒤에 다른 나사들이 짝(pair)을 이루어 연결될 수 있을 지 확인한 후, 그 결과를 출력하자. 
3. 연결될 수 있는 지 확인하기 위해 ArrayList 형태를 사용하자(+큐를 import해서 사용했다면 어땠을까..?)


## 풀이 방법
------------------------------
1. input값을 읽어 Poll 객체에 암, 수 나사 크기와 check(암수 연결을 체크하기 위한 변수, boolean)를 담아 queue(type: ArrayList)에 저장한다. 
 ```java
    //  5번 line. class Poll
    class Poll {
        int male, female;
        boolean check;
        
        public Poll(int male, int female, boolean check) {
            this.male = male;
            this.female = female;
            this.check = check;
	    }
    }

    //  26번 line
    for (int i = 0; i < pollCount; i++) {
				queue.add(new Poll(Integer.parseInt(line[i*2]), Integer.parseInt(line[i*2+1]), false));
			}	

 ```
 2. queue에 있는 전체 나사들을 대상으로 한 나사씩 맨 앞에 올 나사로 선정하고 암-수를 맞춰 가장 많이 연결할 수 있는 조합을 찾는다. 
```java
        while(true) {
					for(int j=0; j<pollCount; j++) {
						Poll temp = checkList.get(j);
                        //  아직 연결되지 않은 나사이고 암-수의 크기가 일치할 때 
						if(!(temp.check) && head.female == temp.male ) {
							head = temp;        //  연결될 나사를 head로 바꿔주고
							temp.check = true;  //  사용한 나사 표시 
							result.add(temp);   //  결과 출력을 위한 list에 추가한다. 
							break;
						}
						if(j == pollCount-1)    //  모두 연결될 수 있는 조합이 발생하면 while문을 빠져나가 결과 출력
							flag = true;
					}					
					if(flag)
						break;
				}

```
