// package boj11723;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 파일에서 데이터 읽기 (테스트용)
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 수행해야 하는 연산의 수 M 입력받기
        int M = Integer.parseInt(br.readLine());
        
        // 비트마스킹을 활용한 집합 상태 저장 변수
        int set = 0;
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // M개의 연산 수행
        for (int i = 0; i < M; i++) {
            String[] tmp = br.readLine().split(" ");
            String cmd = tmp[0];
            int val;
            
            switch (cmd) {
                case "all":
                    // 집합을 {1, 2, ..., 20}으로 변경
                    set = (1 << 21) - 1;
                    break;
                case "empty":
                    // 집합을 공집합으로 변경
                    set = 0;
                    break;
                case "add":
                    // 집합에 x를 추가
                    set |= 1 << Integer.parseInt(tmp[1]);
                    break;
                case "check":
                    // 집합에 x가 있는지 확인하여 결과 출력
                    val = 1 << Integer.parseInt(tmp[1]);
                    if ((set & val) != 0) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "remove":
                    // 집합에서 x를 제거
                    val = 1 << Integer.parseInt(tmp[1]);
                    set &= ~val;
                    break;
                case "toggle":
                    // 집합에서 x가 있으면 제거, 없으면 추가
                    set ^= 1 << Integer.parseInt(tmp[1]);
                default:
                    break;
            }
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}
