// package boj1094;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 파일에서 데이터 읽기 (테스트용)
        // System.setIn(new FileInputStream("src/input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 만들어야 할 막대의 길이 X 입력받기
        int X = Integer.parseInt(br.readLine());
        
        br.close();
        
        // 초기 막대의 길이 (64cm)
        int bar = 64;
        
        // 막대의 개수를 저장할 변수
        int count = 0;
        
        // 막대를 자르면서 X와 같은 길이를 만들 때까지 반복
        while (X > 0) {
            // 현재 막대의 길이가 X보다 작거나 같으면 막대를 사용하고 count 증가
            if (bar <= X) {
                X -= bar;
                count++;
            }
            
            // 막대의 길이를 반으로 줄임 (비트 연산자 사용)
            bar >>= 1;
        }
        
        // 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}