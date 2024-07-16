import java.util.Scanner;

/**
 * @ClassName
 * @Description
 * @Author 房奕伯
 * @Date 2024/4/15 11:40
 * @Version 1.0
 */
public class Person {
    String name;
    int finger;


    /**
     * 玩家出拳
     * @return  玩家出的拳    1.剪刀 2.石头 3.布
     */
    public int showFinger() {
        while (true) {
            System.out.println("请出拳：1.剪刀 2.石头 3.布（输入对应数字）：");
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()) {         //输入是不是整型
                this.finger = input.nextInt();
                if (this.finger >= 1 && this.finger <= 3) {         //数字是不是123
                    break;
                } else {
                    System.out.println("请输入1或2或3");
                }
            } else {
                System.out.println("您输入的不是数字。");
                String clear = input.next();          //清空hasNextInt
            }
        }

        switch (finger) {
            case 1:
                System.out.println("你出拳：剪刀");
                return finger;
            case 2:
                System.out.println("你出拳：石头");
                return finger;
            case 3:
                System.out.println("你出拳：布");
                return finger;
            default:
                return 0;
        }

    }
}