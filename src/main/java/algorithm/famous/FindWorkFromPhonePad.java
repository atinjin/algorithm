package com.github.atinjin.algorithm.famous;

/**
 * Created by ryanjin on 10/12/2016.
 */
public class FindWorkFromPhonePad {

    /**
     * 전화기 버튼을 보면 알파벳과 숫자가 매칭되어 있다
     * 누군가가 전화기 숫자 버튼을 눌렀을 때, 매칭되는 알파벳을 보고
     * 사전에 등록된 올바른 단어를 모두 찾을 수 있을까?
     *
     * Think 1.
     *   일련의 숫자를 입력으로 받을 수 있다. 그런데 이 때 문제되는 점은 각 숫자가 매칭되는 char가 여러개라는 것이다
     *
     *   Brute force 방식으로 생각해보면 하나의 char를 선택하고 다음 숫자에서 하나의 char를 선택하면서
     *   모든 문자 조합을 찾는 것이다. 이는 Tree로 표현될 수 있을 것처럼 보인다.
     *
     *                  root
     *       A           B            C
     *   D   E   F   D   E   F    D   E   F
     *  GHI GHI GHI GHI GHI GHI  GHI GHI GHI
     *
     *  이 경우 Tree의 Traversal 방식 중에서 ROOT를 먼저 방문하는 방식을 사용하면
     *  leaf node로 가는 경로가 단어가 될 수 있다.
     *
     *    Step 1. Tree 만들기
     *      a. input 242384890
     *      b. adjLinkedList
     *          root : {2}
     *    Step 2. Tree Traversal
     *
     *  Think 2.
     *    Queue를 만들어서 단어를 계속 늘려나가는 방식을 쓰면 된다. 숫자를 하나씩 선택하면서
     *    Queue에 들어있는 문자를 꺼내서 3개로 또는 2개로 늘려서 다시 집어넣으면 된다.
     *    이 때, prefix를 확인할 수 있다면, 문자를 붙이는 과정에서 더이상 단어가 될 수 없는 문자열은 삭제할 수 있을 것이다.
     *
     *
     *    Stack = {2,3,4,5,9,0,1,3}
     *    Queue = {
     *        (ad)
     *        (ae)
     *        (af)
     *        ,(b)
     *        ,(c)
     *    }
     *
     */



}
