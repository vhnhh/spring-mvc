package ra.spring_mvc_test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.spring_mvc_test.service.IService;

@Controller
public class SongController {
    @Autowired
    private IService songService;

    @RequestMapping(value = "/homepage")
    public String home(Model model) {
        model.addAttribute("list", songService.getAllSong());
        return "homepage";
    }
}
