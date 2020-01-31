package 反射;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

///**首先用来编写一个注释构造方法的Annotation类型，@Constructor_Annotation
// * 在有效范围为运行时加载到JVM中
// * */
////用于构造方法
//@Target(ElementType.CONSTRUCTOR)
////运行时加载到JVM中
//@Retention(RetentionPolicy.RUNTIME)
//public @interface Construct_Annotation {
//    //定义一具有默认值的String类型·成员吧变量
//    String value() default "默认构造方法";
//}
///**定义一个用来注释字段，方法和参数的Annotation类型@Field_Method_Parameter_Annotation
// * 有效范围为在运行时加载到JVM中
// * */
////用于字段方法和参数
//@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
////运行时加载到JVM中
//@Retention(RetentionPolicy.RUNTIME)
//public @interface Field_Method_Parameter_Annotation {
//    String describe();
//    Class type() default void.class;
//}
public class Record {
    //注释字段
    @Field_Method_Parameter_Annotation(describe = "编号" , type = int.class)
    int id;
    @Field_Method_Parameter_Annotation(describe = "姓名" , type = String.class)
    String name;
    @Construct_Annotation()
    //采用默认值注释构造方法
    public Record() {

    }
    @Construct_Annotation("立即初始化构造方法")
    public Record(
            //注释构造方法
            @Field_Method_Parameter_Annotation(describe = "编号" , type = int.class) int id,
            @Field_Method_Parameter_Annotation(describe = "姓名" ,type = int.class) String name
    ) {
        this.id = id;
        this.name = name;
    }
    @Field_Method_Parameter_Annotation(describe = "获得编号" , type = int.class)
    public int getId() {
        //注释方法
        return id;
    }
    @Field_Method_Parameter_Annotation(describe = "设置编号" )
    public void setId(
            //成员type采用默认值的注释方法
            //注释方法的参数
            @Field_Method_Parameter_Annotation(describe = "编号" , type = int.class) int id
    ){
        this.id = id;
    }
    @Field_Method_Parameter_Annotation(describe = "获得姓名" , type = String.class)
    public String getName() {
        return name;
    }
    @Field_Method_Parameter_Annotation(describe = "设置姓名")
    public void setName(
            @Field_Method_Parameter_Annotation(describe = "姓名" , type = String.class) String name1
    ){
        this.name = name;
    }
}
