package com.example.signify;

public class Question {
    private int answerResId;
    private boolean answerTrue;

    public Question(int answerResId, boolean answerTrue) {
        this.answerResId = answerResId;
        this.answerTrue = answerTrue;
    }

    public int getAnswerResId() {
        return answerResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }
}

