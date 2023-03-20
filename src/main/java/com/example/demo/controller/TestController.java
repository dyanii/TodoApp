package com.example.demo.controller;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("/testGetMapping")
    public String testController(){
        return "Hello World, 김다은";
    }
    @GetMapping("/{id}")
    public  String testControllerWithPathVariable(@PathVariable(required=false)int id)
    {
        return "Hello World! 김다은 "+ id;
    }

    @GetMapping("/testRequestParam")
    public  String testControllerRequestParam(@RequestParam(required=false)int id)
    {
        return "Hello World! 김다은 "+ id;
    }

    @GetMapping("/testRequestBody")
    public  String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO)
    {
        return "Hello World! 김다은. id: "+ testRequestBodyDTO.getId() + ", message: "
                + testRequestBodyDTO.getMessage();
    }

    @GetMapping("/testResponseBody")
    public ResponseDTO<String> testControllerResponseBody()
    {
        List<String> list= new ArrayList<>();
        list.add("kde");
        list.add("kde2");
        list.add("kde33");

        ResponseDTO<String> response=ResponseDTO.<String>builder().data(list).build();

        return response;
    }

    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponsEnity()
    {
        List<String> list= new ArrayList<>();
        list.add("kde");
        list.add("kde2");
        list.add("kde33");

        ResponseDTO<String> response=ResponseDTO.<String>builder().data(list).build();

        return ResponseEntity.ok().body(response);
        //return ResponseEntity.badRequest().body(response);
    }
}
