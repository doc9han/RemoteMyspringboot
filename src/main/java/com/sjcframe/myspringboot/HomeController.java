package com.sjcframe.myspringboot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;


/******************************************************************
 * Springboot 컨트롤러 테스트용
 * @Controller이 경우 사용
 * @GetMapping인 , 해당 url로 접근하는 경우 해당 메소드 호출
 * @ResponseBody, 해당 메소드 처리결과를 response에 반환
 *****************************************************************/

@Controller
public class HomeController {
    private int gIncreaetValue;

    HomeController(){
        gIncreaetValue = -1;
    }

    @GetMapping("/myhome/main")
    @ResponseBody
    public String showMain(){
        return "hi 방가방가";
    }

    @GetMapping("/myhome/increase")
    @ResponseBody
    public int showIncrease(){
        return gIncreaetValue++;
    }

    /**
     * 화면 입력값 -> springboot -> parameter로 받기
     * @RequestParam annotaion 생략가능
     * input : /myhome/getparam1?a=10&b=4
     * @return a+b
     */
    @GetMapping("/myhome/getparam1")
    @ResponseBody
    public int showGetParam1(int a, int b){

        return a + b;
    }

    /**
     * 화면 입력값 -> springboot -> @RequestParam annotaion 받기
     * @RequestParam은 생략가능
     * @RequestParam 값이 null인 경우 default값 설정가능
     * @RequestParam에서 value="a"는 생략가능, 단, setting > build, Execution.. > compiler > java compile 옵션으로 -parameters 가 입력되 경우 생략가능
     * input : /myhome/getparam2?a=10
     * @return a+b
     */
    @GetMapping("/myhome/getparam2")
    @ResponseBody
    public int showGetParam2(@RequestParam(value="a" ,defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b){
        return a + b;
    }

    /**
     * boolean type의 return결과 처리
     * input : /myhome/boolean?a=10
     * @return boolean
     */
    @GetMapping("/myhome/boolean")
    @ResponseBody
    public boolean showBooelan(@RequestParam(value="a" ,defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b){
        boolean lresult = false;
        if((a+b) > 10){
            lresult = true;
        }
        return lresult;
    }

    /**
     * double type의 return결과 처리
     * input : /myhome/double?a=10
     * @return double
     */
    @GetMapping("/myhome/double")
    @ResponseBody
    public double showDouble(@RequestParam(value="a" ,defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b){
        double ld = Math.random();

        return ld;
    }

    /**
     * List<Integer> type의 return결과 처리
     * input : /myhome/array
     * @return List<Integer>
     */
    @GetMapping("/myhome/array")
    @ResponseBody
    public List<Integer> showArray(@RequestParam(value="a" ,defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b){
        /*
          생성시점에 파라미터로 처리하는 방식
         */
        List<Integer> list = new ArrayList<>(){{
         add(10);
         add(20);
         add(30);
        }};

        /*
         다른 방식으로 처리
         List<Integer> list = new ArrayList<>();
         list.add(10);
         list.add(20);
         list.add(30);
         */
        return list;

    }

    /**
     * map type의 return결과 처리
     * input : /myhome/map
     * @return double
     */
    @GetMapping("/myhome/map")
    @ResponseBody
    public Map<String, Object> showMap(@RequestParam(value="a" ,defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b){
        /*  순서를 보장하지 않는 map */
//        Map<String, Object> lmap = new HashMap<>();

        /* 순서를 보장하는 map */
        Map<String, Object> lmap = new LinkedHashMap<>(){{
            put("id", 1);
            put("carName", "K7");
            put("speed",80);
            put("relatedIds", new ArrayList<>(){{
                add(1);
                add(2);
                add(3);
            }});
        }};

        return lmap;

    }


    // map에서 사용할 Object
    class Car{
        // getter 생성자 리스트 조회 시 Alt + 7 번으로 확인 가능
        private final int id;
        private final String carName;
        private final int speed;
        private final List<Integer> relatedIds;

        /* Alt + Ins 생성자 자동생성 */
        public Car(int id, String carName, int speed, List<Integer> relatedIds) {
            this.id = id;
            this.carName = carName;
            this.speed = speed;
            this.relatedIds = relatedIds;
        }
    }

    /* lombok 적용 후 */

    @AllArgsConstructor
    @Getter
    class Car2{
        private final int id;
        private final String carName;
        private final int speed;
        private final List<Integer> relatedIds;

//        public Car2(int id, String carName, int speed, List<Integer> relatedIds) {
//            this.id = id;
//            this.carName = carName;
//            this.speed = speed;
//            this.relatedIds = relatedIds;
//        }
    }
}
