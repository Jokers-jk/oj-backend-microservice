package com.joker.ojbackendjudgeservice.judge;


import com.joker.ojbackendjudgeservice.judge.codesandbox.strategy.DefaultJudgeStrategy;
import com.joker.ojbackendjudgeservice.judge.codesandbox.strategy.JavaLanguageJudgeStrategy;
import com.joker.ojbackendjudgeservice.judge.codesandbox.strategy.JudgeContext;
import com.joker.ojbackendjudgeservice.judge.codesandbox.strategy.JudgeStrategy;
import com.joker.ojbackendmodel.codesandbox.JudgeInfo;
import com.joker.ojbackendmodel.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
