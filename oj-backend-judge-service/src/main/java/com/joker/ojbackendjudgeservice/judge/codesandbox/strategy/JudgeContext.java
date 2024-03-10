package com.joker.ojbackendjudgeservice.judge.codesandbox.strategy;



import com.joker.ojbackendmodel.codesandbox.JudgeInfo;
import com.joker.ojbackendmodel.dto.question.JudgeCase;
import com.joker.ojbackendmodel.entity.Question;
import com.joker.ojbackendmodel.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文（用于定义在策略中传递的参数）
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;

}
