package demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/appointments")
class FirstController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        return "OK";
    }
}
