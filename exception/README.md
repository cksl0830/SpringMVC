### 예외처리와 오류페이지 
> 1. 서블릿 - 필터, 인터셉터   
> 2. 스프링부트가 제공하는 오류 페이지 설정 (이거 사용하면 됨)

-----------------

### API 예외처리 
> 1. HandlerExceptionResolver - ModelAndView 를 반환하기 때문에 직전 json으로 다 데이터를 넣어줘야함   
> 2. 스프링부트가 제공하는 **@ExceptionHandler & @ControllerAdvice** 사용  
> -> 예외를 공통으로 처리할 수 있음 
