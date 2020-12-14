package com.hisoft.exam.domain;

/**
 * @program: ch06-dynamic-sql
 * @description:
 * @author: 玉树临风的寒
 * @create: 2020-12-12 20:28:07
 **/
public class Questions {
    private String qName;
    private String title;
    private String answer;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getqName() {
        return qName;
    }

    public void setqName(String qName) {
        this.qName = qName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Questions(String qName, String title, String answer, String answerA, String answerB, String answerC, String answerD) {
        this.qName = qName;
        this.title = title;
        this.answer = answer;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
    }

    @Override
    public String toString() {
        return  //qName +
                "\n " + title  +
         //       "\n answer=" + answer +
                "\n A " + answerA +
                "\n B " + answerB +
                "\n C " + answerC +
                "\n D " + answerD
                ;
    }
    public String myString() {
        return  qName +
                "\n " + title  +
                "\n " + answer
               // "\n A " + answerA +
               // "\n B " + answerB +
               // "\n C " + answerC +
               // "\n D " + answerD
                ;
    }
}
