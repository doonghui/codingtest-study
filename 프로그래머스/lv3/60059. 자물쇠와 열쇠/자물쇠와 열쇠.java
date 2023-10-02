class Solution {
    public boolean solution(int[][] key, int[][] lock) {
           boolean answer = false;
        int lockLen = lock.length;
        int keyLen = key.length;
        int[][] newLock = new int[lock.length + 2 * (keyLen - 1)][lock.length + 2 * (keyLen - 1)];
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                newLock[i + keyLen - 1][j + keyLen - 1] = lock[i][j];
            }
        }

        for (int k = 0; k < 4; k++) {
            if (sol(key, newLock, lockLen, keyLen)) {
                answer = true;
                break;
            }

            key = rotate(key, keyLen);

        }


        return answer;
    }
 
    // lock 을 lock.length + 2*(keyLen-1) 으로 늘린다. (실제lock 은 중간에 위치)
    // 키를 lock 맨 오른쪽, 맨 왼쪽 부터 끝까지 하나하나씩 확인한다.
    // 만약 안맞으면 키를 돌린다.
    // 4번 돌려도 안맞으면 false

    static boolean sol(int[][] key, int[][] newLock, int lockLen, int keyLen) {
        int newLockLen = newLock.length;

        for (int i = 0; i < newLockLen-keyLen+1; i++) {
            for (int j = 0; j <newLockLen-keyLen+1; j++) {


                for(int x = 0; x < keyLen;x++) {                // 키랑 합치기
                    for(int y = 0; y < keyLen;y++) {
                        newLock[i+x][j+y] += key[x][y];
                    }
                }

                int checkNum = 0;
                for(int x = keyLen-1; x < keyLen+lockLen-1;x++) {                // 확인.. 만약 실제 lock 부분이 다 1 이라면 true
                    for(int y = keyLen-1; y < keyLen+lockLen-1;y++) {
                        if(newLock[x][y] == 1) checkNum++;
                    }
                }
                if(checkNum == lockLen*lockLen) return true;


                for(int x = 0; x < keyLen;x++) {                // 안맞다면 다시 원상복구 해주기
                    for(int y = 0; y < keyLen;y++) {
                        newLock[i+x][j+y] -= key[x][y];
                    }
                }


            }

        }

        return false;
    }


    static int[][] rotate(int[][] key,int keyLen) {
        int[][] tmpKey = new int[keyLen][keyLen];

        for(int i =0; i< keyLen;i++) {
            for(int j=0;j<keyLen;j++) {
                tmpKey[i][j] = key[keyLen-1-j][i];
            }
        }

        return tmpKey;
    }

}