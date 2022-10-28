package com.bitcamp.onemoaproject;

import java.util.Random;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class App {

  public static void main(String[] args) {
    System.out.println("비트캠프 프로젝트!");
    SpringApplication.run(App.class, args);
  }

  @GetMapping("/")
  public String welcome() {
    return "index";
  }
  
  @GetMapping("index")
  public String welcome2(@CookieValue(name = "email", defaultValue = "") String email, Model model) {
    System.out.println("email = " + email);
    model.addAttribute("email", email);
    System.out.println("model = " + model);
    return "index";
  }
  
  @GetMapping("/contestTeam")
  public String welcome2() {
    return "contestTeam";
  }
  
  @GetMapping("joinform")
  public String joinForm() {
    return "joinForm";
  }
  
  @GetMapping("/productForm")
  public String productForm() {
    return "product/productForm";
  }
}


