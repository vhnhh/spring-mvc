package ra.demo_spring_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.demo_spring_mvc.model.Post;
import ra.demo_spring_mvc.service.IPostService;

@Controller
//@RequestMapping("/postController")
public class PostController {
    @Autowired
    private IPostService postService;

    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("list", postService.findAllPosts());
        return "homepage";
    }

    @GetMapping("/initCreate")
    public String initCreatePost(Model model) {
        Post post = new Post();
        model.addAttribute("post");
        return "addNewPost";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Post post) {
        postService.createPost(post);
        return "redirect:/homepage";
    }

    @GetMapping("/initUpdate")
    public String initUpdatePost(Model model, int id) {
        Post post = postService.findById(id);
        model.addAttribute(post);
//        post.setId(id);
        System.out.println(post.getId());
        return "updatePost";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute Post post, int id) {
        post.setId(id);
        postService.editPost(post);
        System.out.println(post.getId());
        return "redirect:/homepage";
    }

    @GetMapping("/delete")
    public String deletePost(Model model, int id) {
        postService.deletePost(id);
        return "homepage";
    }

    @GetMapping("/findByTitleOrContent")
    public String search(@RequestParam String search, Model model){
        model.addAttribute("list",postService.findAllPostByTitleOrContent(search));
        model.addAttribute("search",search);
        return "homepage";
    }
}
