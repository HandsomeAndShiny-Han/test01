package com.hisoft.exam.test;

import com.hisoft.d12_08.Student;
import com.hisoft.exam.domain.Questions;
import com.hisoft.exam.domain.Teacher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: ch06-dynamic-sql
 * @description:
 * @author: 玉树临风的寒
 * @create: 2020-12-12 20:34:33
 **/
public class Test01 {
    public static void main(String[] args)throws Exception {
        File in = new  File("D:\\IdeaProjects\\EL工作空间\\Test课间\\src\\com\\hisoft\\exam\\properties\\Questions");
        BufferedReader isr=new BufferedReader(new FileReader(in));
        String s,qname=null,title=null,answer=null,answerA=null,
                answerB=null,answerC=null,answerD=null;

        List<Questions> questionsList=new ArrayList<>();
        for(int i=1;((s=isr.readLine())!=null);i++){
            if ( i % 8 == 1)  {qname =s; }
            else   if ( i % 8 == 2)  {title=s ; }
            else   if ( i % 8 == 3)  {answer=s;}
            else   if ( i % 8 == 4)  {answerA=s; }
            else   if ( i % 8 == 5)  {answerB=s; }
            else   if ( i % 8 == 6)  {answerC=s; }
            else   if ( i % 8 == 7)  {answerD=s; }
            else if(i%8==0){
                Questions que = new Questions(qname,title,answer,answerA,answerB,answerC,answerD);
                questionsList.add(que);
            }
        }
        Questions que = new Questions(qname,title,answer,answerA,answerB,answerC,answerD);
        questionsList.add(que);
        isr.close();
        questionsList.stream().forEach(System.out::println);
    }
}
