import java.util.Random;

/**
 * @ClassName
 * @Description
 * @Author 房奕伯
 * @Date 2024/4/15 14:10
 * @Version 1.0
 */
public class Computer {
    String name;
    int finger;

    /**
     * 电脑出拳
     * @return  电脑出的拳   1.剪刀 2.石头 3.布
     */
    public int showFinger(){
        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1;
        switch (randomNumber){
            case 1:
                System.out.println("电脑出拳：剪刀");
                this.finger = 1;
                return finger;
            case 2:
                System.out.println("电脑出拳：石头");
                this.finger = 2;
                return finger;
            case 3:
                System.out.println("电脑出拳：布");
                this.finger = 3;
                return finger;
            default:
                return 0;
        }
    }
}
