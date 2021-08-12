package com.example.signify;

public class DataHolder {

    private static int percentageComplete1 = 0;
    private static int percentageComplete2 = 0;
    private static int percentageComplete3 = 0;
    private static int percentageComplete4 = 0;
    private static boolean completeButton2Clicked = false;
    private static boolean completeButtonClicked = false;
    private static boolean completeButton3Clicked = false;
    private static boolean completeButton4Clicked = false;
    private static boolean level1ButtonClicked = false;
    private static boolean level2ButtonClicked = false;
    private static boolean level3ButtonClicked = false;
    private static boolean level4ButtonClicked = false;
    private static boolean level2ButtonClickable = false;
    private static boolean level3ButtonClickable = false;
    private static boolean level4ButtonClickable = false;
    private static boolean helpExitButtonClicked = false;
    private static boolean userGuideLinkClicked = false;



    public static int getPercentageComplete1() {
        return percentageComplete1;
    }

    public static void setPercentageComplete1(int newPercentage) {
         percentageComplete1 = newPercentage;
    }

    public static boolean isCompleteButton2Clicked() {
        return completeButton2Clicked;
    }

    public static void setCompleteButton2Clicked(boolean completeButton2Clicked) {
        DataHolder.completeButton2Clicked = completeButton2Clicked;
    }

    public static boolean isLevel1ButtonClicked() {
        return level1ButtonClicked;
    }

    public static void setLevel1ButtonClicked(boolean level1ButtonClicked) {
        DataHolder.level1ButtonClicked = level1ButtonClicked;
    }

    public static boolean isLevel2ButtonClickable() {
        return level2ButtonClickable;
    }

    public static void setLevel2ButtonClickable(boolean level2ButtonClickable) {
        DataHolder.level2ButtonClickable = level2ButtonClickable;
    }

    public static boolean isLevel2ButtonClicked() {
        return level2ButtonClicked;
    }

    public static void setLevel2ButtonClicked(boolean level2ButtonClicked) {
        DataHolder.level2ButtonClicked = level2ButtonClicked;
    }

    public static boolean isLevel3ButtonClicked() {
        return level3ButtonClicked;
    }

    public static void setLevel3ButtonClicked(boolean level3ButtonClicked) {
        DataHolder.level3ButtonClicked = level3ButtonClicked;
    }

    public static boolean isLevel4ButtonClicked() {
        return level4ButtonClicked;
    }

    public static void setLevel4ButtonClicked(boolean level4ButtonClicked) {
        DataHolder.level4ButtonClicked = level4ButtonClicked;
    }

    public static boolean isLevel3ButtonClickable() {
        return level3ButtonClickable;
    }

    public static void setLevel3ButtonClickable(boolean level3ButtonClickable) {
        DataHolder.level3ButtonClickable = level3ButtonClickable;
    }

    public static boolean isLevel4ButtonClickable() {
        return level4ButtonClickable;
    }

    public static void setLevel4ButtonClickable(boolean level4ButtonClickable) {
        DataHolder.level4ButtonClickable = level4ButtonClickable;
    }

    public static int getPercentageComplete2() {
        return percentageComplete2;
    }

    public static void setPercentageComplete2(int percentageComplete2) {
        DataHolder.percentageComplete2 = percentageComplete2;
    }

    public static int getPercentageComplete3() {
        return percentageComplete3;
    }

    public static void setPercentageComplete3(int percentageComplete3) {
        DataHolder.percentageComplete3 = percentageComplete3;
    }

    public static int getPercentageComplete4() {
        return percentageComplete4;
    }

    public static void setPercentageComplete4(int percentageComplete4) {
        DataHolder.percentageComplete4 = percentageComplete4;
    }

    public static boolean isCompleteButtonClicked() {
        return completeButtonClicked;
    }

    public static void setCompleteButtonClicked(boolean completeButtonClicked) {
        DataHolder.completeButtonClicked = completeButtonClicked;
    }

    public static boolean isCompleteButton3Clicked() {
        return completeButton3Clicked;
    }

    public static void setCompleteButton3Clicked(boolean completeButton3Clicked) {
        DataHolder.completeButton3Clicked = completeButton3Clicked;
    }

    public static boolean isCompleteButton4Clicked() {
        return completeButton4Clicked;
    }

    public static void setCompleteButton4Clicked(boolean completeButton4Clicked) {
        DataHolder.completeButton4Clicked = completeButton4Clicked;
    }

    public static boolean isHelpExitButtonClicked() {
        return helpExitButtonClicked;
    }

    public static void setHelpExitButtonClicked(boolean helpExitButtonClicked) {
        DataHolder.helpExitButtonClicked = helpExitButtonClicked;
    }
}
