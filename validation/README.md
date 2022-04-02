### 상품 처리 페이지에서 입력 조건 추가 하기

- v1: **Map<String, String> errors = new HashMap<>();** 에 에러들을 넣어주고 모델에 담아서 뷰로 넘겨서 타임리프 검증  

- v2 : BindingResult bindingResult 추가하고,   
**bindingResult.addError(new FieldError("item", "itemName", item.getItemName(), false, null, null, "상품 이름은 필수 입니다."));**  
장점 : 모델에 자동으로 포함, 바인딩 타입시 에러나면 에러메시지 출력, 오류 발생시 사용자 입력 유지    
ex) **th:field** :: 정상 상황에는 모델 객체의 값을 사용하지만, 오류가 발생하면 FieldError 에서 보관한 값을 사용해서 값을 출력한다.  
```html
<div th:if="${#fields.hasGlobalErrors()}">
            <p class="field-error" th:each="err : ${#fields.globalErrors()}" th:text="${err}">글로벌 오류 메시지</p>
        </div>

        <div>
            <label for="itemName" th:text="#{label.item.itemName}">상품명</label>
            <input type="text" id="itemName" th:field="*{itemName}"
                   th:errorclass="field-error" class="form-control" placeholder="이름을 입력하세요">
            <div class="field-error" th:errors="*{itemName}">
                상품명 오류
            </div>
        </div>
```


- v3 : 메시지 파일 생성 후 
```Java
(new FieldError("item", "price", item.getPrice(), false, new String[]{"range.item.price"}, new Object[]{1000, 1000000}, null)); 
(new FieldError("item", "itemName", item.getItemName(), false, new String[]{"required.item.itemName"}, null, null)); 
```

- v4 : **rejectValue() , reject() 사용** -> 더 세부적인 파일 우선으로 검증하고 출력   
```Java
bindingResult.rejectValue("itemName", "required");
bindingResult.rejectValue("price", "range", new Object[]{1000, 10000000}, null);
bindingResult.reject("totalPriceMin", new Object[]{10000, resultPrice}, null); // 특정 필드가 아닌 복합 검증 
```


#### ✅ validation 분리 

- v5 : **ItemValidator 클래스 만들고 implements Validator 을 통해 에러메시지 부분 분리!**   
-> 컨트롤러 부분에 생성자 만들고 컴포넌트스캔해서 처리 : 로직이 깔끔해짐 

- v6 : **@InitBinder** 통해 검증 확인하고 **@Validated** 적용 

---------------------------------

- V3 컨트롤러 추가
1. 아이템 도메인에 @NotNull 과 같은 어노테이션을 추가해주므로써 @Validated 가 알아서 검증 


 
