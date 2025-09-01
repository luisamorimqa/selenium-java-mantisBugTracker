package support;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Random;

public class FakeData {

    private static final Faker faker = new Faker();
    private static final List<String> estado = List.of("desenvolvimento", "release", "estável", "obsoleto");
    private static final List<String> visibilidade = List.of("público", "privado");
    private static final List<String> frequencia = List.of("sempre", "às vezes", "aleatório", "não se tentou", "incapaz de reproduzir", "N/D");
    private static final List<String> gravidade = List.of("recurso", "trivial", "texto", "mínimo", "pequeno", "grande", "travamento", "obstáculo");
    private static final List<String> prioridade = List.of("nenhuma", "baixa", "normal", "alta", "urgente", "imediato");
    private static final List<String> usuarios = List.of("administrator");
    private static Random random = new Random();

    public static String getProjectName() {
        return "Project " + faker.app().name() + " " + faker.app().version();
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

    public static String getIssueFrequencia() {
        return frequencia.get(random.nextInt(frequencia.size()));
    }

    public static String getIssueGravidade() {
        return gravidade.get(random.nextInt(gravidade.size()));
    }

    public static String getIssuePrioridade() {
        return prioridade.get(random.nextInt(prioridade.size()));
    }

    public static String getRandomUser() {
        return usuarios.get(random.nextInt(usuarios.size()));
    }

    public static String getRandomParagrph() {
        return faker.lorem().paragraph();
    }
}
