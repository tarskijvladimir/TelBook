import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserDataInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные (Фамилия Имя Отчество дата_рождения номер_телефона пол):");
        String userData = scanner.nextLine();

        String[] userDataArray = userData.split(" ");
        if (userDataArray.length != 6) {
            System.out.println("Ошибка: Вы ввели неверное количество данных.");
            return;
        }

        String lastName = userDataArray[0];
        String firstName = userDataArray[1];
        String middleName = userDataArray[2];
        String birthDate = userDataArray[3];
        long phoneNumber = Long.parseLong(userDataArray[4]);
        char gender = userDataArray[5].charAt(0);

        try {
            FileWriter fileWriter = new FileWriter(lastName + ".txt", true);
            fileWriter.write(lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender + "\n");
            fileWriter.close();
            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}