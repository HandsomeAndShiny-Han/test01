package com.hisoft.exam.service;

import com.hisoft.customer.CustomerList;
import com.hisoft.exam.domain.Questions;
import com.hisoft.exam.domain.Teacher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * @program: ch06-dynamic-sql
 * @description:
 * @author: 玉树临风的寒
 * @create: 2020-12-12 20:40:56
 **/
public class MainService {
    static Scanner sc = new Scanner(System.in);
    static int choose;
    static int point=0;
    static Map<String,String> map=new HashMap<>();
    public static List<Teacher> getTeachers() throws Exception{
        File in = new  File("D:\\IdeaProjects\\EL工作空间\\Test课间\\src\\com\\hisoft\\exam\\properties\\Teacher.txt");
        BufferedReader isr=new BufferedReader(new FileReader(in));
        String s;
        String grade=null;
        String name=null;
        String gender=null;
        String age = null;
        List<Teacher> teacherList=new ArrayList<>();
        for(int i=1;((s=isr.readLine())!=null);i++){
            if ( i % 5 == 1)  {name =s; }
            else   if ( i % 5 == 2)  {gender=s ; }
            else   if ( i % 5 == 3)  {age=s;}
            else   if ( i % 5 == 4)  {grade=s; }
            else if(i%5==0){
                Teacher tea = new Teacher(name,gender,age,grade);
                teacherList.add(tea);
            }
        }
        Teacher tea = new Teacher(name,gender,age,grade);
        teacherList.add(tea);
        isr.close();
     return teacherList;
    }
    public static List<Questions> getQuestions()throws Exception{
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
       return questionsList;
    }
    public static void printMenu() throws Exception {
        System.out.println("-------------信息管理软件------------");
        System.out.println();
        System.out.println("1 参加考试");
        System.out.println("2 我的信息");
        System.out.println("3 考试成绩");
        System.out.println("4 试题列表");
        System.out.println("5 退   出");
        System.out.println();
        System.out.println("请选择(1-5):");
        choose=sc.nextInt();
        if (choose == 1) {
            try {
                kaoshi();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (choose == 2) {
            System.out.println("---------我的信息-------");
            try {
                MainService.getTeachers().stream().forEach(System.out::println);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (choose == 3) {
            Set<String> strings = map.keySet();
            System.out.println("---------展示成绩-------");
//            for (String s :strings) {
//                System.out.print(s);
//                sc.nextLine();
//                System.out.println();
//                System.err.println("你的答案为 "+map.get(s));
//            }

            int chengji = chengji();
            System.err.println(MainService.getTeachers().get(0).getName()+"你的成绩为"+chengji);

        }else if(choose ==4){
            System.out.println("---------展示试题-------");
            try {
                MainService.getQuestions().stream().forEach((s)-> System.out.println(s.myString()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (choose == 5) {
            System.out.println("下次见");
            System.exit(0);
        }
    }
    public static void kaoshi() throws Exception{
        String an = null;
        List<Questions> questions = getQuestions();
        for (int i = 0; i <questions.size() ; i++) {
            System.out.println(questions.get(i));
            an=sc.next();
            sc.nextLine();
            map.put(questions.get(i).getqName()+"正确答案为"+questions.get(i).getAnswer(),an);
        }
        //System.out.println(map.size());
    }
    public static int chengji() throws Exception{
        List<Questions> questions = getQuestions();
        point=0;
        for (int i=0;i<questions.size();i++){
            String s=questions.get(i).getAnswer();
            char c=s.charAt(0);
        //    System.out.println(c);

            if(map.get(questions.get(i).getqName()+"正确答案为"+questions.get(i).getAnswer()).trim().equalsIgnoreCase(String.valueOf(c)))
            {
                //System.out.println(map.get(questions.get(i).getqName()+"正确答案为"+questions.get(i).getAnswer()).equalsIgnoreCase(s));
                point=point+10;
            }
            //System.out.println(map.get(questions.get(i).getqName()+"正确答案为"+questions.get(i).getAnswer()));
            //System.out.println("Test");
        }
        int a=point;
        return point;
    }
}
