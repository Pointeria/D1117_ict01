package net.ict.d1117_ict01.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Log4j2
public class SampleController {

        class SampleDTO {
            private String p1;
            private String p2;
            private String p3;
            public String getP1(){
                return p1;
            }
            public String getP2() {
                return p2;
            }
            public String getP3() {
                return p3;
            }
        }

        @GetMapping("/hello")
        public void hello(Model model) {
            log.info("----------------hello-------------------");
            model.addAttribute("msg", "Hello! Spring Boot!!!!!!!!!!!");
        }

        @GetMapping("/ex/ex1")
        public void ex1(Model model) {
            List<String> list = Arrays.asList("AAA", "BBB", "CCC");
            model.addAttribute("List", list);
        }

        @GetMapping("/ex/ex2")
        public void ex2(Model model) {
            log.info("--------------ex/ex2----------------");
            List<String> strList = IntStream.range(1,11).  //range(1,11)=11-1=10개 생성
                    mapToObj(i->"Data" + i). //Data1, Data2... Data10
                    collect(Collectors.toList());
            model.addAttribute("list", strList);
            Map<String, String> map = new HashMap<>();
            map.put("A","aaa");
            map.put("B","bbb");
            map.put("Z","zzz");
            model.addAttribute("map", map);
            SampleDTO sampleDTO = new SampleDTO();
            sampleDTO.p1 = "value --- p1!";
            sampleDTO.p2 = "value --- p2!";
            sampleDTO.p3 = "value --- p3!";
            model.addAttribute("sampleDTO", sampleDTO);
        }

        @GetMapping("ex/ex3")
        public void ex3(Model model) {
            model.addAttribute("arr", new String[]{"kkk","eee","yyy"});
        }

}
