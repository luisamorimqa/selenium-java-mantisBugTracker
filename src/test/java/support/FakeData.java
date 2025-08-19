package support;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Random;

public class FakeData {

    private static final Faker faker = new Faker();
    private static final List<String> estado = List.of("desenvolvimento", "release", "estável", "obsoleto");
    private static final List<String> visibilidade = List.of("público", "privado");
    private static Random random = new Random();

    public static String getProjectName() {
        return "Project " + faker.app().name();
    }

    public static String getProjectState() {
        return estado.get(random.nextInt(estado.size()));
    }

    public static Boolean getBoolean() {
        return random.nextBoolean();
    }

    public static String getProjectVisibilidade() {
        return visibilidade.get(random.nextInt(visibilidade.size()));
    }

    public static String getProjectDescription() {
        return faker.lorem().paragraph();
    }

    public static String getUsernameUnregistered() {
        return faker.name().username();
    }

    public static String getEmailUnregistered() {
        return faker.internet().emailAddress();
    }

    public static String getNewPassword() {
        return faker.internet().password(8, 15);
    }

}
