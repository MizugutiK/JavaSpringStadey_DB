package com.example.db_sqp.controller;

import com.example.db_sqp.model.User;
import com.example.db_sqp.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping()
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ルートパスにアクセスした時に呼ばれるメソッド
    @GetMapping("/")
    public String test(Model model) {
        return "test";  // test.htmlテンプレートを返す
    }

    // ユーザー一覧ページの表示
    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/list";  // user/list.htmlテンプレートを返す
    }

    // 新規ユーザー登録フォームの表示
    @GetMapping("/users/new")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "user/form";  // user/form.htmlテンプレートを返す
    }

    // ユーザー追加の処理
    @PostMapping("/users")
    public String addUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/users";  // ユーザー一覧ページにリダイレクト
    }
}
