package com.joker.ojbackendjudgeservice.judge;


import com.joker.ojbackendmodel.entity.QuestionSubmit;

public interface JudgeService {

    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
