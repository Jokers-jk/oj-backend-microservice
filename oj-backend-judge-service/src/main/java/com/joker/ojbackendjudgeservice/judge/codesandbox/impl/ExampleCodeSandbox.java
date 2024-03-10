package com.joker.ojbackendjudgeservice.judge.codesandbox.impl;


import com.joker.ojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.joker.ojbackendmodel.codesandbox.ExecuteCodeRequest;
import com.joker.ojbackendmodel.codesandbox.ExecuteCodeResponse;
import com.joker.ojbackendmodel.codesandbox.JudgeInfo;
import com.joker.ojbackendmodel.enums.JudgeInfoMessageEnum;
import com.joker.ojbackendmodel.enums.QuestionSubmitStatusEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
