package taskBD;

import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        try {
            BDConnectionSS db = BDConnectionSS.getInstance();
            // Создание таблиц
            //db.create(Table.PARENT.getSql());
//            db.create(Table.CHILD.getSql());
            Integer i = 0;
            while (true){
                if (i > 4){
                    break;
                }
                // Добавление записей в таблицы Parent и Child
                Scanner sc = new Scanner(System.in);
                System.out.println("Добавление родителя: ");
                System.out.println("Введите имя: ");
                String firstName = sc.nextLine();
                System.out.println("Введите фимилию: ");
                String lastName = sc.nextLine();
                System.out.println("Введите возраст: ");
                String age = sc.nextLine();
                UUID uuidParent = UUID.randomUUID();
                db.insertParent(INSERT.IntoParent.getSql(), uuidParent.toString(), lastName, firstName, age);

                System.out.println("Добавление ребенка: ");
                System.out.println("Введите имя: ");
                String firstNameChild = sc.nextLine();
                System.out.println("Введите фимилию: ");
                String lastNameChild = sc.nextLine();
                System.out.println("Введите возраст: ");
                String ageChild = sc.nextLine();
                UUID uuidChild = UUID.randomUUID();
                db.insertChild(INSERT.IntoChild.getSql(), uuidChild.toString(), uuidParent.toString(), lastNameChild, firstNameChild, ageChild);
                i++;
            }

            ResultSet resultSet = db.select(Select.ParentAndChild.getSql());
            while (resultSet.next()){
                System.out.println(String.format("У родителя %s %s в возврасте %s имеется ребенок %s %s в возрасте %s ", resultSet.getString("lastnameParent"),
                        resultSet.getString("firstnameParent"),resultSet.getInt("ageParent"),resultSet.getString("lastnameChild"), resultSet.getString("firstChild"),resultSet.getInt("ageChild") ));
            }
            db.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
