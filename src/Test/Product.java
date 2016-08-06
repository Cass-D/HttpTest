package Test;

/**
 * Created by Cass on 2016/6/15.
 */
public class Product {
    public static final int PAGE_SIZE=2; //每页记录数
    private int odId;            //编号
    private int orderReference;      //对应订单编号，外键
    private int dishes;        //对应菜品编号，外键
    private int cookingStatus;        //烹饪状态：0-未烹饪，1-正在烹饪，2-烹饪完毕
    private int num;        //菜品的数量
    public int getOdId() {return odId;}
    public void setOdId(int odId) {this.odId = odId;}
    public int getOrderReference() {return orderReference;}
    public void setOrderReference(int orderReference) {this.orderReference = orderReference;}
    public int getDishes() {return dishes;}
    public void setDishes(int dishes) {this.dishes = dishes;}
    public int getCookingStatus() {return cookingStatus;}
    public void setCookingStatus(int cookingStatus) {this.cookingStatus = cookingStatus;}
    public int getNum() {return num;}
    public void setNum(int num) {this.num = num;}
}