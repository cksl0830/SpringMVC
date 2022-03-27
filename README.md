# SpringMVC
#### < 스프링 MVC를 통해 간단한 웹 페이지 만들기 > 

##### 1. 서블릿 
- 뷰(View)화면을 위한 HTML을 만드는 작업이 자바 코드에 섞여서 지저분하고 복잡

##### 2. JSP
- 뷰를 생성하는 HTML 작업을 깔끔하게 가져가고, 중간중간 동적으로 변경이 필요한 부분에만 자바 코드를 적용
- 그러나, 비즈니스 로직과 뷰 영역이 같이 존재 -> JSP가 너무 많은 역할을 함 

##### 3. MVC 패턴 
- 모델(뷰에 출력할 데이터) / 뷰(모댈의 데이터 화면 렌더링) / 컨트롤러(비즈니스 로직) :: 3가지 영역으로 서로 역할을 나눔
- 포워드 중복 / 사용하지 않는 코드 / **공통 처리가 어려움**

##### 4. MVC 프레임워크 만들기
- v1: 프론트 컨트롤러를 도입 (입구를 하나로) 
  기존 구조를 최대한 유지하면서 프론트 컨트롤러를 도입  
- v2: View 분류  
  단순 반복 되는 뷰 로직 분리  
- ⭐️ **v3: Model 추가**   
  서블릿 종속성 제거(대신 별도의 Model 객체를 만들어서 반환)   
  뷰 이름 중복 제거(대신 컨트롤러는 뷰의 논리 이름을 반환)  
- v4: 단순하고 실용적인 컨트롤러 
  v3와 거의 비슷     
  구현 입장에서 ModelView를 직접 생성해서 반환하지 않도록 편리한 인터페이스 제공  
  -> model 객체는 파라미터로 전달되기 때문에 그냥 사용하면 되고, 결과로 뷰의 이름만 반환해주면 된다  
- v5: 유연한 컨트롤러 어댑터 도입  
  어댑터를 추가해서 프레임워크를 유연하고 확장성 있게 설계  
  
✅ 어댑터 패턴 
```
v4 프론트 컨트롤러까지는 한가지 방식의 컨트롤러 인터페이스만 사용할 수 있다   
-> 이럴 때 사용하는 것이 바로 어댑터이다. 
즉, 프론트 컨트롤러가 다양한 방식의 컨트롤러를 처리할 수 있도록 변경 -> v5
```

##### 5. 스프링 MVC

- 비교 
>FrontController -> DispatcherServlet   
handlerMappingMap -> HandlerMapping   
MyHandlerAdapter -> HandlerAdapter   
ModelView -> ModelAndView   
viewResolver -> ViewResolver  
MyView -> View    

- 구조   
![image](https://user-images.githubusercontent.com/60590737/160222701-b80df947-df42-4455-923f-c1f0af8979c1.png)


