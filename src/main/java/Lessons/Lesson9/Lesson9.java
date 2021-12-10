package Lessons.Lesson9;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lesson9 {
    public static void main(String[] args) throws Exception {
        Class classCat = Cat.class;
        Method[] methods = classCat.getDeclaredMethods();
        for(Method o : methods){
            System.out.println(o.getName());
        }
        Cat cat = new Cat(1,2,3);
        methods[0].invoke(cat);
        methods[1].setAccessible(true);
        methods[1].invoke(cat);

        int mods = methods[0].getModifiers();
        System.out.println("isStatic " + Modifier.isStatic(mods));
        System.out.println("isFinal" + Modifier.isFinal(mods));
        System.out.println("isPublic " + Modifier.isPublic(mods));

        Cat cat1 = (Cat) classCat.getConstructor(int.class,int.class,int.class).newInstance(10,20,30);

        Class testClass = TestClass.class;
        Method[] methods1 = testClass.getDeclaredMethods();
        List<Method> executionList = new ArrayList<>();
        for(Method o : methods1){
            if(o.isAnnotationPresent(MyAnnotation.class)){
                executionList.add(o);
            }
        }
        executionList.sort((o1, o2) -> o2.getAnnotation(MyAnnotation.class).priority() - o1.getAnnotation(MyAnnotation.class).priority());
        executionList = Arrays.stream(methods1)
                .filter(m -> m.isAnnotationPresent(MyAnnotation.class))
                .sorted((o1, o2) -> o2.getAnnotation(MyAnnotation.class).priority() - o1.getAnnotation(MyAnnotation.class).priority())
                .collect(Collectors.toList());
        for(Method m : executionList){
            m.invoke(null);
        }
    }
}
