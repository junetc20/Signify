package com.example.signify;

/**
 * A class that holds data on user progression and location.
 * It is used by multiple classes.
 *
 *
 * @author June Caldwell
 * @version 0.1 (01.08.21)
 */

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
    private static boolean userGuideViewed = false;
    private static int activityCount1;
    private static int activityCount2;
    private static int activityCount3;
    private static int activityCount4;

    /**
     * Get the int value of percentageComplete1.
     * @return int percentageComplete1.
     */
    public static int getPercentageComplete1() {
        return percentageComplete1;
    }

    /**
     * Set the int value of percentageComplete1.
     * @param percentageComplete1 The new int value of percentageComplete1.
     */
    public static void setPercentageComplete1(int percentageComplete1) {
         DataHolder.percentageComplete1 = percentageComplete1;
    }

    /**
     * Get the boolean value of completeButton2Clicked.
     * @return boolean completeButton2Clicked.
     */
    public static boolean isCompleteButton2Clicked() {
        return completeButton2Clicked;
    }

    /**
     * Set the boolean value of percentageComplete1.
     * @param completeButton2Clicked The new boolean value of completeButton2Clicked.
     */
    public static void setCompleteButton2Clicked(boolean completeButton2Clicked) {
        DataHolder.completeButton2Clicked = completeButton2Clicked;
    }

    /**
     * Get the boolean value of level1ButtonClicked.
     * @return boolean level1ButtonClicked.
     */
    public static boolean isLevel1ButtonClicked() {
        return level1ButtonClicked;
    }

    /**
     * Set the boolean value of level1ButtonClicked.
     * @param level1ButtonClicked The new boolean value of level1ButtonClicked.
     */
    public static void setLevel1ButtonClicked(boolean level1ButtonClicked) {
        DataHolder.level1ButtonClicked = level1ButtonClicked;
    }

    /**
     * Get the boolean value of level2ButtonClickable.
     * @return boolean level2ButtonClickable.
     */
    public static boolean isLevel2ButtonClickable() {
        return level2ButtonClickable;
    }

    /**
     * Set the boolean value of level2ButtonClickable.
     * @param level2ButtonClickable The new boolean value of level2ButtonClickable.
     */
    public static void setLevel2ButtonClickable(boolean level2ButtonClickable) {
        DataHolder.level2ButtonClickable = level2ButtonClickable;
    }

    /**
     * Get the boolean value of level2ButtonClicked.
     * @return boolean level2ButtonClicked.
     */
    public static boolean isLevel2ButtonClicked() {
        return level2ButtonClicked;
    }

    /**
     * Set the boolean value of level2ButtonClicked.
     * @param level2ButtonClicked The new boolean value of level2ButtonClicked.
     */
    public static void setLevel2ButtonClicked(boolean level2ButtonClicked) {
        DataHolder.level2ButtonClicked = level2ButtonClicked;
    }

    /**
     * Get the boolean value of level3ButtonClicked.
     * @return boolean level3ButtonClicked.
     */
    public static boolean isLevel3ButtonClicked() {
        return level3ButtonClicked;
    }

    /**
     * Set the boolean value of level3ButtonClicked.
     * @param level3ButtonClicked The new boolean value of level3ButtonClicked.
     */
    public static void setLevel3ButtonClicked(boolean level3ButtonClicked) {
        DataHolder.level3ButtonClicked = level3ButtonClicked;
    }

    /**
     * Get the boolean value of level4ButtonClicked.
     * @return boolean level4ButtonClicked.
     */
    public static boolean isLevel4ButtonClicked() {
        return level4ButtonClicked;
    }

    /**
     * Set the boolean value of level4ButtonClicked.
     * @param level4ButtonClicked The new boolean value of level4ButtonClicked.
     */
    public static void setLevel4ButtonClicked(boolean level4ButtonClicked) {
        DataHolder.level4ButtonClicked = level4ButtonClicked;
    }

    /**
     * Get the boolean value of level3ButtonClickable.
     * @return boolean level3ButtonClickable.
     */
    public static boolean isLevel3ButtonClickable() {
        return level3ButtonClickable;
    }

    /**
     * Set the boolean value of level3ButtonClickable.
     * @param level3ButtonClickable The new boolean value of level3ButtonClickable.
     */
    public static void setLevel3ButtonClickable(boolean level3ButtonClickable) {
        DataHolder.level3ButtonClickable = level3ButtonClickable;
    }

    /**
     * Get the boolean value of level4ButtonClickable.
     * @return boolean level4ButtonClickable.
     */
    public static boolean isLevel4ButtonClickable() {
        return level4ButtonClickable;
    }

    /**
     * Set the boolean value of level4ButtonClickable.
     * @param level4ButtonClickable The new boolean value of level4ButtonClickable.
     */
    public static void setLevel4ButtonClickable(boolean level4ButtonClickable) {
        DataHolder.level4ButtonClickable = level4ButtonClickable;
    }

    /**
     * Get the int value of percentageComplete2.
     * @return int percentageComplete2.
     */
    public static int getPercentageComplete2() {
        return percentageComplete2;
    }

    /**
     * Set the int value of percentageComplete2.
     * @param percentageComplete2 The new int value of percentageComplete2.
     */
    public static void setPercentageComplete2(int percentageComplete2) {
        DataHolder.percentageComplete2 = percentageComplete2;
    }

    /**
     * Get the int value of percentageComplete3.
     * @return int percentageComplete3.
     */
    public static int getPercentageComplete3() {
        return percentageComplete3;
    }

    /**
     * Set the int value of percentageComplete3.
     * @param percentageComplete3 The new int value of percentageComplete3.
     */
    public static void setPercentageComplete3(int percentageComplete3) {
        DataHolder.percentageComplete3 = percentageComplete3;
    }

    /**
     * Get the int value of percentageComplete4.
     * @return int percentageComplete4.
     */
    public static int getPercentageComplete4() {
        return percentageComplete4;
    }

    /**
     * Set the int value of percentageComplete4.
     * @param percentageComplete4 The new int value of percentageComplete4.
     */
    public static void setPercentageComplete4(int percentageComplete4) {
        DataHolder.percentageComplete4 = percentageComplete4;
    }

    /**
     * Get the boolean value of completeButtonClicked.
     * @return boolean completeButtonClicked.
     */
    public static boolean isCompleteButtonClicked() {
        return completeButtonClicked;
    }

    /**
     * Set the boolean value of completeButtonClicked.
     * @param completeButtonClicked The new boolean value of completeButtonClicked.
     */
    public static void setCompleteButtonClicked(boolean completeButtonClicked) {
        DataHolder.completeButtonClicked = completeButtonClicked;
    }

    /**
     * Get the boolean value of completeButton3Clicked.
     * @return boolean completeButton3Clicked.
     */
    public static boolean isCompleteButton3Clicked() {
        return completeButton3Clicked;
    }

    /**
     * Set the boolean value of completeButton3Clicked.
     * @param completeButton3Clicked The new boolean value of completeButton3Clicked.
     */
    public static void setCompleteButton3Clicked(boolean completeButton3Clicked) {
        DataHolder.completeButton3Clicked = completeButton3Clicked;
    }

    /**
     * Get the boolean value of completeButton4Clicked.
     * @return boolean completeButton4Clicked.
     */
    public static boolean isCompleteButton4Clicked() {
        return completeButton4Clicked;
    }

    /**
     * Set the boolean value of completeButton4Clicked.
     * @param completeButton4Clicked The new boolean value of completeButton4Clicked.
     */
    public static void setCompleteButton4Clicked(boolean completeButton4Clicked) {
        DataHolder.completeButton4Clicked = completeButton4Clicked;
    }

    /**
     * Get the boolean value of userGuideViewed.
     * @return boolean userGuideViewed.
     */
    public static boolean isUserGuideViewed() {
        return userGuideViewed;
    }

    /**
     * Set the boolean value of userGuideViewed.
     * @param userGuideViewed The new boolean value of userGuideViewed.
     */
    public static void setUserGuideViewed(boolean userGuideViewed) {
        DataHolder.userGuideViewed = userGuideViewed;
    }

    /**
     * Get the int value of activityCount1.
     * @return int activityCount1.
     */
    public static int getActivityCount1() {
        return activityCount1;
    }

    /**
     * Set the int value of activityCount1.
     * @param activityCount1 The new int value of activityCount1.
     */
    public static void setActivityCount1(int activityCount1) {
        DataHolder.activityCount1 = activityCount1;
    }

    /**
     * Get the int value of activityCount2.
     * @return int activityCount2.
     */
    public static int getActivityCount2() {
        return activityCount2;
    }

    /**
     * Set the int value of activityCount2.
     * @param activityCount2 The new int value of activityCount2.
     */
    public static void setActivityCount2(int activityCount2) {
        DataHolder.activityCount2 = activityCount2;
    }

    /**
     * Get the int value of activityCount3.
     * @return int activityCount3.
     */
    public static int getActivityCount3() {
        return activityCount3;
    }

    /**
     * Set the int value of activityCount3.
     * @param activityCount3 The new int value of activityCount3.
     */
    public static void setActivityCount3(int activityCount3) {
        DataHolder.activityCount3 = activityCount3;
    }

    /**
     * Get the int value of activityCount4.
     * @return int activityCount4.
     */
    public static int getActivityCount4() {
        return activityCount4;
    }

    /**
     * Set the int value of activityCount4.
     * @param activityCount4 The new int value of activityCount4.
     */
    public static void setActivityCount4(int activityCount4) {
        DataHolder.activityCount4 = activityCount4;
    }
}
