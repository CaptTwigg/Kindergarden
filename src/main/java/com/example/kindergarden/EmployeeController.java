package com.example.kindergarden;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;

@Controller
public class EmployeeController {

      @GetMapping("/employee")
      public String employee() throws Exception{
          return "employee";
      }
}
