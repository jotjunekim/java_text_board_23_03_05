package com.text.exam;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("==프로그램 시작 ==");
    int lastId = 1;
    Article lastArticle = null;

    while (true) {
      System.out.printf("명령어 입력 : ");
      String cmd = sc.nextLine();
      System.out.println(cmd);

      if (cmd.equals("나가기")) {
        break;
      } else if (cmd.equals("게시물 작성")) {
        System.out.println("=========게시물=========");
        System.out.printf("제목 : ");
        String title = sc.nextLine();
        System.out.printf("내용 : ");
        String contents = sc.nextLine();


        Article article = new Article(lastId, title, contents);
        lastArticle = article;
        System.out.println(article);

        int id = lastId++;
        System.out.printf("%d번 게시물이 작성되었습니다.\n", id);

      }
      else if (cmd.equals("게시물 상세보기")) {
        if(lastArticle == null){              /// 고객이 정보를 입력하지 않았을 시에 대한 출력도 넣어줌
          System.out.println("게시물이 존재 하지 않습니다");
          continue; // 밑에 내용(다음내용)으로 넘어가지고 않고 다시 while 반복문으로 올라감
        }
        Article article = lastArticle;        ///새로운 객체를 생성함으로써 class article의 인스턴스변수와 매소드의 정보를 이어서 넣어줌

        System.out.println("======마지막 게시물 상세보기=======");
        System.out.printf("제목 : %s\n",article.title);
        System.out.printf("내용 : %s\n",article.contents);
        System.out.printf("번호 : %s\n",article.lastId);


      }
      else {
        System.out.printf("잘못된 명령어 입니다. 다시 입력해주세요\n", cmd);
      }
    }
    System.out.println("=======프로그램 종료=========");
    sc.close();
  }
}

class Article {
  int lastId;
  String title;
  String contents;

  public Article(int lastId, String title, String contents) {
    this.lastId = lastId;
    this.title = title;
    this.contents = contents;
  }

  @Override
  public String toString(){
    return String.format("제목 : \"%s\", 내용 : %s, ID :\" %s \"",title,contents,lastId);
  }
    }