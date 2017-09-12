package com.github.atinjin.algorithm;//L	커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
//D	커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
//B	커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
//삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
//P $	$라는 문자를 커서 왼쪽에 추가함

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class Pr_1406_Editor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int commands = in.nextInt();
        Stack left = new Stack();
        Stack right = new Stack();
        IntStream.range(0, str.length()).forEach(i -> left.push(str.charAt(i)));
        IntStream.range(0, commands).forEach(i ->
                {
                    char c = in.next().charAt(0);
                    char n = 0;
                    if (c == 'P')
                        n = in.next().charAt(0);
                    switch(c) {
                        case 'P':
                            left.push(n);
                            break;
                        case 'L':
                            if(!left.empty()) {
                                char pop = (char) left.pop();
                                right.push(pop);
                            }
                            break;
                        case 'D':
                            if(!right.empty()) {
                                char popq = (char) right.pop();
                                left.push(popq);
                            }
                            break;
                        case 'B':
                            if(!left.empty())
                                left.pop();
                            break;
                    }
                }
        );
        IntStream.range(0, left.size()).forEach(i -> { char pop = (char)left.pop(); right.push(pop);});
        IntStream.range(0, right.size()).forEach(i -> System.out.print(right.pop()));
    }
}