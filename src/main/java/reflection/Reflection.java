package reflection;

import java.lang.reflect.Field;

public class Reflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student("Nikita", 15);
        Class studentReflection = student.getClass();
        Field reflectionStudent = studentReflection.getDeclaredField("name");
        reflectionStudent.setAccessible(true);
        reflectionStudent.set(studentReflection, "new value");
        System.out.println(reflectionStudent.getName());
    }
}
