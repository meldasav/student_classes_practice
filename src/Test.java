import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        //COMPLETE THIS CLASS AFTER ALL THE OTHER CLASSES

        /**
         Write a code that asks user to if they would like join your classes
         If the answer is "Yes" from user,then ask user information; firstName, lastName, age, gender, class to join
         ***If user is age is not more than 20, do not allow them to join
         ***If user wants to join any other class except Math and Science, do not allow them to join

         REMEMBER - checkAge and checkClassName methods may throw exceptions. You have to handle them

         Keep asking users the question they would to like join until you have got 3 students overall
         Create MathStudent or ScienceStudent objects based on user's answer for the class they want to join
         Print a "Congratulations! You are registered for {className} class."

         Store all these 3 objects in a collection and print them

         EXPECTED OUTPUT OF THE PROGRAM:
         Print information of all 3 students
         Print how many students are MathStudent with message -> "Math students = {numberOfMathStudents}"
         Print how many students are ScienceStudent with message -> "Science students = {numberOfScienceStudents}"
         */
        Scanner scan = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int mathStudents = 0;
        int scienceStudents = 0;
        do {
            System.out.println(UserQuestions.askToJoin);
            String attend = scan.next();
            if (attend.equalsIgnoreCase("y"))
                System.out.println(UserQuestions.askFirstName);
            String firstNameE = scan.nextLine();

            System.out.println(UserQuestions.askLastName);
            String lastNameE = scan.nextLine();

            System.out.println(UserQuestions.askAge);
            int age = scan.nextInt();
            scan.nextLine();


            try {
                Permission.checkAge(age);

            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            System.out.println(UserQuestions.askGender);
            String gender = scan.next();

            String classNameE;
            System.out.println(UserQuestions.askClassName);
            classNameE = scan.nextLine();

            try {
                Permission.checkClassName(classNameE);

            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }


            if (classNameE.equalsIgnoreCase("Math")) {
                System.out.println("Congratulations ! You are register for " + classNameE + "classes.");
                Student student = new MathStudent(firstNameE, lastNameE, age, gender, classNameE);
                students.add(student);
            } else if (classNameE.equalsIgnoreCase("science")) {
                System.out.println("Congratulations ! You are register for " + classNameE + "classes.");
                students.add(new ScienceStudent(firstNameE, lastNameE, age, gender, classNameE));
            }

        } while (students.size() < 3);

        for (Student s : students) {
            System.out.println(s);
        }
        for (Student s : students) {
            if (s.getClassName().equalsIgnoreCase("Math")) mathStudents++;
            else if (s.getClassName().equalsIgnoreCase("Science")) scienceStudents++;
        }
        System.out.println("Math students  " + mathStudents);
        System.out.println("Science srudents  " + scienceStudents);

    }

}
