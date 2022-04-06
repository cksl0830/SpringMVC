### 타입 변환

- **컨버전 서비스는 @RequestParam , @ModelAttribute , @PathVariable , 뷰 템플릿 등에서 사용할 수 있다.** 

1. 컨버터   
> 컨버전서비스 사용  
2. 포맷터  
> 포맷터 컨버전서비스 사용   
3. 스프링 지원 기본 포맷터  
> @numberformat & @DateTimeFormat    
 
 ✅ 주의   
 ```
 메시지 컨버터( HttpMessageConverter )에는 컨버전 서비스가 적용되지 않는다.
 ex)객체를 JSON으로 변환
 ```
