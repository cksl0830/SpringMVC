### - 상품 처리 페이지에 메시지 및 국제화 기능 추가 
> 1. 메시지   
> ex) **th:text="#{label.item}"** 타임리프에 적용하면   
> -> messages.properties 에 저장된 메시지가 출력, 없으면 html 그대로 출력  

> 2. 국제화   
> messages_en.properties 에 영어 메시지 저장하면   
> -> 스프링이 알아서 Locale 적용  


* application.properties 에 어떤 파일명 쓸지만 설정해주면 된다.  
**->  spring.messages.basename=messages,config.i18n.messages**
