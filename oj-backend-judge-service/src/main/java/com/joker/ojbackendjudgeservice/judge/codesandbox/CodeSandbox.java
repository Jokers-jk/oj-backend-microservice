package com.joker.ojbackendjudgeservice.judge.codesandbox;


import com.joker.ojbackendmodel.codesandbox.ExecuteCodeRequest;
import com.joker.ojbackendmodel.codesandbox.ExecuteCodeResponse;

public interface CodeSandbox {

    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
