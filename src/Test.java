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
        Scanner scan=new Scanner(System.in);
        List<Student> students=new ArrayList<>();
        int count = 0;
        do {
            System.out.println(UserQuestions.askToJoin);
            if (scan.nextLine().equalsIgnoreCase("Y"))
                continue;

            System.out.println(UserQuestions.askFirstName);
            String firstNameE = scan.nextLine();

            System.out.println(UserQuestions.askLastName);
            String lastNameE = scan.nextLine();


            int age = 0;
            try {
                System.out.println(UserQuestions.askAge);
                age = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(UserQuestions.askGender);
            String gender = scan.next();


            String classNameE = null;
            try {
                System.out.println(UserQuestions.askClassName);
                classNameE = scan.nextLine();

            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Congratulations ! You are register for " + classNameE + "classes.");
            if(classNameE.toLowerCase().equals("math")){
                Student student =new MathStudent(firstNameE,lastNameE,age,gender,classNameE);
                students.add(student);
            }else if(classNameE.toLowerCase().equals("science")){
                Student student =new ScienceStudent(firstNameE,lastNameE,age,gender,classNameE);
                students.add(student);
            }
            count++;
        }while(count<3);

        int mathStudents=0;
        int scienceStudents=0;
            for(Student s :students)
            if(s.getClassName().toLowerCase().equals("math"))mathStudents++;
            else scienceStudents++;
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println(mathStudents);
        System.out.println(scienceStudents);
        }

    }


