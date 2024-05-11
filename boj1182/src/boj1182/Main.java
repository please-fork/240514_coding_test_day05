// package boj1182;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 파일에서 데이터 읽기 (테스트용)
        // System.setIn(new FileInputStream("src/input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 정수의 개수 N과 목표 값 S 입력받기
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int S = Integer.parseInt(tmp[1]);
        
        // 정수 배열 A 입력받기
        String[] arr = br.readLine().split(" ");
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(arr[i]);
        }
        
        br.close();
        
        // 부분 집합의 합이 S와 일치하는 경우의 수를 저장할 변수
        int answer = 0;
        
        // 부분 집합의 개수 (2^N)
        int cases = 1 << N;
        
        // 모든 부분 집합에 대해 합 계산
        for (int i = 1; i < cases; i++) {
            int sum = 0;
            
            // 비트마스킹을 활용하여 정수 선택 여부 확인
            for (int j = 0; j < N; j++) {
                if ((i & 1 << j) != 0) { // j번째 정수가 선택되었다면
                    sum += A[j]; // 선택된 정수 더하기
                }
            }
            
            // 부분 집합의 합이 S와 일치하는 경우 answer 증가
            if (sum == S) {
                answer++;
            }
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}