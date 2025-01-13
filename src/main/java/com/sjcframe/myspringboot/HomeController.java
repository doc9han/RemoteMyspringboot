package com.sjcframe.myspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/******************************************************************
 * Springboot 컨트롤러 테스트용
 * @Controller이 경우 사용
 * @GetMapping인 , 해당 url로 접근하는 경우 해당 메소드 호출
 * @ResponseBody, 해당 메소드 처리결과를 response에 반환
 *****************************************************************/

@Controller
public class HomeController {

    @GetMapping("/myhome/main")
    @ResponseBody
    public String showMyhome(){
        return "hi 방가방가";
    }

}
