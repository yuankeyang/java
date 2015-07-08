/******************
* 设计模式学习：
* java单例模式的学习
* 
***************/
public class SingletonClass{
  private static SingletonClass instance=null;
  public static SingletonClass getInstance(){
    if(instance==null){
      synchronized(SingletonClass.class){
        if(instance==null){
          instance=new SingletonClass();
        }
      }
    }
  }
}
