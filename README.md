# Android_I_mean_Kotlin
<span>
1. RecyclerView_Practice 101 // 리사이클러뷰 수정 문제 (2021.07.29) <br/>
   <br/>
   <ul>
      <li>수정 버튼으로 아이템 내용의 일부 수정 시, 일부 아이템에서 반영 안되는 문제점 (보통 최초로 생성된 3개의 아이템 중 마지막 아이템)</li>
      <li>정렬 시, 다른 아이템이 안보이게 되는 문제점(같은 자리에서 문제 발생)</li>
      <li> 2021.08.01 -> 아마 수정 후 바로 반영하지 않아서 그런 듯 </li>  
   </ul>
</span>
<span>  
   <br/>
2. Thread_Practice // 이미 만든 뷰에 rect에서 사용하는 속성들을 사용하고 싶다면 어떻게 해야할까 (2021.08.02) <br/>
   Thread_Practice // 미사일 발사 시, 스레드를 여러번 호출하니 A스레드의 내용이 B스레드 중간에 적용되는 문제점 발생 (2021.08.07)<br/>
     <br/>
     <ul>
        <li> 커스텀 뷰로 이미 만든 뷰도 상속할 수 있다고 하니 시도해보기 </li>
        <li> 2021.08.03 -> 이미지뷰에 view.x , view.y , view.width , view.height 를 활용해서 collision 함수를 만들었다.</li>
        <li> 2021.08.03 -> 기존의 뷰의 전체 레이아웃을 merge 로 바꾸고, 커스텀뷰를 만든 뒤 init 으로 해당 레이아웃을 불러오면 기존의 레이아웃에 내가 만든 커스텀뷰를 사용할 수 있다. </li>
     </ul>
</span>  
  
3. 프래그먼트에 람다식으로 인텐트를 넘기고, 프래그먼트 매니저를 이용해서 열면 생성자 관련 오류때문에 말썽  
   -> 람다식보다 인터페이스르 활용해보기    
   
4. 탭 레이아웃 - 뷰페이저 사용 시 탭 레이아웃 아이콘 커스텀 불가능, 방법 찾기
</span>  
    
5. 뷰페이저 무한스크롤 시(인트 MAX 로 구현) 인디케이터 설정 문제


# Jetpack compose MVVP 모델로 To-do List 만들기  
1. Jetpack compose Side effect의 사용방법이 아직 감에 안옴  
2. Jetpack compose ROOM 은 적용하고, 이해했는데 Dagger-hilt 는 아예 감이 안옴. 왜 쓰는걸까 ..? 😕
3. Jetbrain academy - Kotlin basic 강좌 시작  
