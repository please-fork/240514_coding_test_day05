// package boj2961;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 파일에서 데이터 읽기 (테스트용)
        // System.setIn(new FileInputStream("src/input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 재료의 개수 N 입력받기
        int N = Integer.parseInt(br.readLine());
        
        // 재료의 신맛과 쓴맛 정보를 저장할 2차원 배열
        int[][] arr = new int[N][2];
        
        // 재료의 신맛과 쓴맛 정보 입력받기
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(tmp[0]);
            arr[i][1] = Integer.parseInt(tmp[1]);
        }
        
        br.close();
        
        // 신맛과 쓴맛의 차이의 절댓값 중 최솟값을 저장할 변수
        int answer = Integer.MAX_VALUE;
        
        // 부분 집합의 개수 (2^N)
        int ways = 1 << N;
        
        // 모든 부분 집합에 대해 신맛과 쓴맛의 차이 계산
        for (int i = 1; i < ways; i++) {
            int mul = 1; // 신맛의 곱
            int sum = 0; // 쓴맛의 합
            
            // 비트마스킹을 활용하여 재료 선택 여부 확인
            for (int j = 0; j < N; j++) {
                if ((i & 1 << j) != 0) { // j번째 재료가 선택되었다면
                    mul *= arr[j][0]; // 신맛 곱하기
                    sum += arr[j][1]; // 쓴맛 더하기
                }
            }
            
            // 신맛과 쓴맛의 차이의 절댓값 중 최솟값 갱신
            answer = Math.min(answer, Math.abs(mul - sum));
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}