package com.joker.ojbackendquestionservice.controller.inner;

import com.joker.ojbackendmodel.entity.Question;
import com.joker.ojbackendmodel.entity.QuestionSubmit;
import com.joker.ojbackendmodel.entity.User;

import com.joker.ojbackendquestionservice.service.QuestionService;
import com.joker.ojbackendquestionservice.service.QuestionSubmitService;
import com.joker.ojbackendserviceclient.service.QuestionFeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/inner")
public class QuestionInnerController implements QuestionFeignClient {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;


    @Override
    @GetMapping("/get/id")
    public Question getQuestionById(long questionId){
        return  questionService.getById(questionId);
    }



    @Override
    @GetMapping("/question_submit/get/id")
    public QuestionSubmit getQuestionSubmitById(long questionSubmitId){
        return questionSubmitService.getById(questionSubmitId);
    }


    @Override
    @PostMapping("/question_submit/update")
    public boolean updateQuestionSubmitById(QuestionSubmit questionSubmit){
        return questionSubmitService.updateById(questionSubmit);
    }
}
