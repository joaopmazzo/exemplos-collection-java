package lists.ExercicioProposto001;

import java.util.*;

public class Temperatura {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Double> temperatura = new ArrayList<>();

        for(var count = 0; count < 6; count++) {
            System.out.print("Digite a tempereratura:: ");
            Double temp = scan.nextDouble();
            temperatura.add(temp);
        }
        System.out.println("--------------------------------------------------------------");

        System.out.print("As temperaturas digitadar foram:: ");
        temperatura.forEach(t -> System.out.print(t + ", "));

        double mediaSemestral = temperatura.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0d);
        System.out.printf("\nMédia semestral das temperatuas:: %.1f\n", mediaSemestral);

        System.out.print("Temperaturas acima da média e seus meses::\n");
        Iterator<Double> iterator = temperatura.iterator();
        var count = 0;
        while (iterator.hasNext()) {
            Double temp = iterator.next();
            if (temp > mediaSemestral) {
                switch (count) {
                    case (0) -> System.out.printf("1 - janeiro: %.1f\n ", temp);
                    case (1) -> System.out.printf("2 - fevereiro: %.1f\n", temp);
                    case (2) -> System.out.printf("3 - março: %.1f\n", temp);
                    case (3) -> System.out.printf("4 - abril: %.1f\n", temp);
                    case (4) -> System.out.printf("5 - maio: %.1f\n", temp);
                    case (5) -> System.out.printf("6 - junho: %.1f\n", temp);
                    default -> System.out.println("Não houve temperatura acima da média.");
                }
            }
            count++;
        }
    }
}