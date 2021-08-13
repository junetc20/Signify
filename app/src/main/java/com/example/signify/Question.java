package com.example.signify;

/**
 * A class used to store methods for Quiz2, Quiz3 and Quiz4.
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

public class Question {

    private int answerResId;
    private boolean answerTrue;

    /**
     * Constructor for objects of class Question.
     */
    public Question(int answerResId, boolean answerTrue) {
        this.answerResId = answerResId;
        this.answerTrue = answerTrue;
    }

    /**
     * Get the int value of answerResId.
     * @return int answerResId.
     */
    public int getAnswerResId() {
        return answerResId;
    }

    /**
     * Get the boolean value of isAnswerTrue.
     * @return boolean isAnswerTrue.
     */
    public boolean isAnswerTrue() {
        return answerTrue;
    }
}

