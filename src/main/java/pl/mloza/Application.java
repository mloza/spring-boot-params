package pl.mloza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/querystring")
    @ResponseBody
    public String queryStringMapping(
            @RequestParam("param1") String p1,
            @RequestParam(required = false, name = "param2") String p2,
            @RequestParam int p3) {
        return String.format("Otrzymane wartości: param1=%s, param2=%s, p3=%d", p1, p2, p3);
    }

    @RequestMapping({"/path/{id:[0-9]{2,5}}", "/path"})
    @ResponseBody
    public String pathVariable(
            @PathVariable(required = false) Integer id) {
        return String.format("Wartość zmiennej id = %s", id);
    }
}
