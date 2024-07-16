import java.util.Scanner;

/**
 * @ClassName
 * @Description
 * @Author 房奕伯
 * @Date 2024/4/15 14:16
 * @Version 1.0
 */
public class Game {

    int gameTimes=0;         //游戏次数
    int personScore=0;        //玩家得分
    int computerScore=0;       //电脑得分
    Computer computer = new Computer();
    Person person = new Person();

    /**
     * 初始化
     */
    public void initial(){
        System.out.println("----------------欢迎进入游戏世界----------------");
        System.out.println();
        System.out.println("              *****************");
        System.out.println("              ***  猜拳，开始 ***");
        System.out.println("              *****************");
        System.out.println();
        System.out.println("出拳规则：1.剪刀 2.石头 3.布");
    }

    /**
     * 游戏运行部分
     */
    public void startGame(){
        Scanner input = new Scanner(System.in);
        System.out.print("请选择对方角色（1.刘备 2.孙权 3.曹操）：");
        int role;

        while (true) {
            if (input.hasNextInt()) {         //输入是不是整型
                role = input.nextInt();
                if (role >=1 && role <=3) {         //数字是不是123
                    break;
                } else {
                    System.out.println("请输入1或2或3");
                }
            } else {
                System.out.println("您输入的不是数字。");
                String clear = input.next();          //清空hasNextInt
            }
        }
        System.out.print("请输入你的名字：");
        person.name = input.next();

        switch (role){
            case 1:
                System.out.println(person.name+" VS 刘备");
                computer.name = "刘备";
                break;
            case 2:
                System.out.println(person.name+" VS 孙权");
                computer.name = "孙权";
                break;
            case 3:
                System.out.println(person.name+" VS 曹操");
                computer.name = "曹操";
                break;
        }

        String isStart;
        System.out.print("要开始吗？(y/n)");

        isStart = input.next();
        while (true){
            if(isStart.equals("y")){
                gameTimes++;
                person.finger = person.showFinger();
                computer.finger = computer.showFinger();
                if (person.finger == computer.finger){
                    System.out.println("和局，真衰！嘿嘿，等着瞧吧！");
                }else if ((person.finger-computer.finger == 1)
                        ||(person.finger-computer.finger == -2)){
                    System.out.println("恭喜，你赢了！");
                    personScore++;
                }else {
                    System.out.println("^_^,你真笨，输了。");
                    computerScore++;
                }

                System.out.print("是否开始下一轮（y/n）：");
                isStart = input.next();
            }else if (isStart.equals("n")){
                System.out.println("结束对战。");
                break;
            }else {
                System.out.println("请按提示输入正确的字母。");
                break;
            }
        }
    }

    /**
     * 比赛结果输出
     */
    public void showResult(){
        System.out.println("------------------------------");
        System.out.println(computer.name+"  VS  "+person.name);
        System.out.println("对战次数："+gameTimes);
        System.out.println("姓名    得分");
        System.out.println(computer.name+"    "+computerScore);
        System.out.println(person.name+"    "+personScore);
        System.out.print("结果：");
        if (personScore > computerScore){
            System.out.println("呜呜，你赢了，算你厉害。");
        }else if (personScore < computerScore){
            System.out.println("呵呵，笨笨，下次加油吧。");
        }else {
            System.out.println("打成平手，下次再和你一教高下。");
        }
        System.out.println("------------------------------");
    }

}
