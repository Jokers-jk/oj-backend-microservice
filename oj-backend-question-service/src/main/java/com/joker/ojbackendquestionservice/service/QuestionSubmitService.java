package com.joker.ojbackendquestionservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.joker.ojbackendmodel.dto.questionsubmit.QuestionSubmitAddRequest;
import com.joker.ojbackendmodel.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.joker.ojbackendmodel.entity.QuestionSubmit;
import com.joker.ojbackendmodel.entity.User;
import com.joker.ojbackendmodel.vo.QuestionSubmitVO;


/**
* @author 10621
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-03-01 12:35:12
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 题目提交
     *
     * @param
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);



    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);




}
