package lists.ExercicioProposto002;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PerguntasCrime {

    public static void main(String[] args) {
        List<String> respostas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Perguntas(S ou N)");

        System.out.print("Telefonou para vítima? ");
        String resposta = scanner.next();
        respostas.add(resposta.toLowerCase());

        System.out.print("Esteve no local do crime? ");
        resposta = scanner.next();
        respostas.add(resposta.toLowerCase());

        System.out.print("Mora perto da vítima? ");
        resposta = scanner.next();
        respostas.add(resposta.toLowerCase());

        System.out.print("Devia para vítima? ");
        resposta = scanner.next();
        respostas.add(resposta.toLowerCase());

        System.out.print("Já trabalhou com a vítima? ");
        resposta = scanner.next();
        respostas.add(resposta.toLowerCase());

        System.out.printf("\nResultado de repostas:: %s\n", respostas);

        var countAfirmacao = 0;
        Iterator<String> iterator = respostas.iterator();
        while (iterator.hasNext()) {
            String respostaAfirmativa = iterator.next();
            if (respostaAfirmativa.contains("s")) {
                countAfirmacao++;
            }
        }

        switch (countAfirmacao) {
            case 2 -> System.out.println(">>>SUSPEITO<<<");
            case 3, 4 -> System.out.println(">>>CÚMPLICE<<<");
            case 5 -> System.out.println(">>>ASSASSINA<<<");
            default -> System.out.println(">>>INOCENTE<<<");
        }
    }
}
