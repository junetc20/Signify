package com.example.signify;

public class MultipleChoiceQ {

    private static final String[] questions =  {
            "How long has sign language been used as a method of communication?",
            "When did the UK government recognise sign language as a minority language?",
            "How many people are estimated to use BSL within the UK?",
            "What is audist behaviour?",
            "Why should you not switch your primary hand when signing?"
    };

    private static final String[][] answers = {
            {"Hundreds of years", "Decades", "Since 1968"},
            {"2001", "2002", "2003"},
            {"146,000", "280,000", "151,000"},
            {"How deaf people behave", "An attitude against those unable to hear", "Helping others when asked to"},
            {"It can be difficult to understand", "You will sign incorrectly", "Trick question: you should do this"}

    };

    private static final String[] correctAnswers = {
            "Hundreds of years", "2003", "151,000", "An attitude against those unable to hear", "It can be difficult to understand"};

    public static String getQuestion(int x) {
        String question = questions[x];
        return question;
    }

    public static String getChoice1(int x) {
        String choice0 = answers [x] [0];
        return choice0;
    }

    public static String getChoice2(int x) {
        String choice1 = answers [x] [1];
        return choice1;
    }

    public static String getChoice3(int x) {
        String choice2 = answers [x] [2];
        return choice2;
    }

    public static String getCorrectAns(int x) {
        String answers = correctAnswers[x];
        return answers;
    }

}
