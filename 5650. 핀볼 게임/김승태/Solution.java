import java.util.Scanner;

class Solution
{
	static final int UP = 1;
    static final int DOWN = 2;
    static final int RIGHT = 3;
    static final int LEFT = 4;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, N, block, answer, currentPoint;
        int ping[][];
        Wormhole wormhole[];
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            ping = new int[N][N];
            answer = 0;
            wormhole = new Wormhole[5];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    block = sc.nextInt();
                    ping[i][j] = block;
                    if (block > 5) {
                        if (wormhole[block - 6] == null) {
                            wormhole[block - 6] = new Wormhole(i, j);
                        } else {
                            wormhole[block - 6].wormhole = new Wormhole(i, j);
                            wormhole[block - 6].wormhole.wormhole = wormhole[block - 6];
                        }
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (ping[i][j] == 0) {
                        for (int k = 1; k < 5; k++) {
                            currentPoint = getPoint(i, j, k, ping, wormhole, N);
                            answer = answer < currentPoint ? currentPoint : answer;
                        }
                    }
                }
            }
            System.out.println(String.format("#%d %d", test_case, answer));
        }
    }

    static int getPoint(int x, int y, int direction, int[][] ping, Wormhole wormhole[], int N) {
        int nextX = x;
        int nextY = y;
        int point = 0;
        int pingValue;
        Wormhole currentWormhole;
        do {
            pingValue = ping[nextX][nextY];
            direction = getNextDirection(pingValue, direction);

            if (pingValue > 0 && pingValue < 6) {
                point++;
            }

            if (pingValue > 5) {
                currentWormhole = wormhole[pingValue - 6];
                if (currentWormhole.x == nextX && currentWormhole.y == nextY) {
                    currentWormhole = currentWormhole.wormhole;
                }
                nextX = currentWormhole.x;
                nextY = currentWormhole.y;
            }

            switch (direction) {
                case 1: // UP
                    nextX -= 1;
                    break;
                case 2: // DOWN
                    nextX += 1;
                    break;
                case 3: // RIGHT
                    nextY += 1;
                    break;
                case 4: // LEFT
                    nextY -= 1;
                    break;
            }

            if (nextX == N) {
                nextX--;
                direction = convertDirection(direction);
                point++;
            } else if (nextX == -1) {
                nextX++;
                direction = convertDirection(direction);
                point++;
            } else if (nextY == N) {
                nextY--;
                direction = convertDirection(direction);
                point++;
            } else if (nextY == -1) {
                nextY++;
                direction = convertDirection(direction);
                point++;
            }
        } while (!(nextX == x && nextY == y) && ping[nextX][nextY] != -1);
        return point;
    }

    static int getNextDirection(int block, int direction) {
        switch (block) {
            case 1:
                if (direction == UP) {
                    return DOWN;
                } else if (direction == DOWN) {
                    return RIGHT;
                } else if (direction == RIGHT) {
                    return LEFT;
                } else {
                    return UP;
                }
            case 2:
                if (direction == UP) {
                    return RIGHT;
                } else if (direction == DOWN) {
                    return UP;
                } else if (direction == RIGHT) {
                    return LEFT;
                } else {
                    return DOWN;
                }
            case 3:
                if (direction == UP) {
                    return LEFT;
                } else if (direction == DOWN) {
                    return UP;
                } else if (direction == RIGHT) {
                    return DOWN;
                } else {
                    return RIGHT;
                }
            case 4:
                if (direction == UP) {
                    return DOWN;
                } else if (direction == DOWN) {
                    return LEFT;
                } else if (direction == RIGHT) {
                    return UP;
                } else {
                    return RIGHT;
                }
            case 5:
                return convertDirection(direction);
            default:
                return direction;
        }
    }

    static int convertDirection(int direction) {
        switch (direction) {
            case 1:
                return DOWN;
            case 2:
                return UP;
            case 3:
                return LEFT;
            case 4:
                return RIGHT;
        }
        return 0;
    }

    static class Wormhole {
        int x;
        int y;
        Wormhole wormhole;

        Wormhole(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Wormhole getWormhole(int x, int y) {
            if (this.x == x && this.y == y) {
                return wormhole;
            }
            return this;
        }
    }
}
