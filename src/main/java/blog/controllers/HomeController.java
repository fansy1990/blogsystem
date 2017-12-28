package blog.controllers;

import blog.models.Post;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;
import  static  blog.util.BlogUtils.*;
/**
 * Created by fanzhe on 2017/12/26.
 */
@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @Autowired
    private HttpSession session;
    @RequestMapping("/")
    public String index(Model model){
//        if(session.getAttribute(USERS) == null ||
//                (HashS)session.getAttribute(USERS))
        List<Post> latest5Posts = postService.findLatest5();
        model.addAttribute("latest5posts", latest5Posts);

        List<Post> latest3Posts = latest5Posts.stream()
                .limit(3).collect(Collectors.toList());
        model.addAttribute("latest3posts", latest3Posts);
        return "index";
    }
}
