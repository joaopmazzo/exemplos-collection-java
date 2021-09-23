package map.ExercicioProposto001;

import java.util.*;

public class PopulacaoNordeste {
/*
    1) Dada a população estimada de alguns estados do NE brasileiro, faça: -done
        a) Estado = PE - População = 9.616.621
        b) Estado = AL - População = 3.351.543
        c) Estado = CE - População = 9.187.103
        d) Estado = RN - População = 3.534.264
    2) Crie um dicionário e relacione os estados e suas populações conforme apresentado no item 1); -done
    3) Substitua a população do estado do RN por 3.534.165; -done
    4) Confira se o estado PB está no dicionário, caso não adicione: PB - 4.039.277; -done...
    5) Exiba a população de PE; -done
    6) Exiba todos os estados e suas populações na ordem que foi informado; -done
    7) Exiba os estados e suas populações em ordem alfabética; -done
    8) Exiba o estado com a menor população e sua quantidade; -done
    9) Exiba o estado com a maior população e sua quantidade; -done
   10) Exiba a soma da população desses estados; -done
   11) Exiba a média da população deste dicionário de estados; -done
   12) Exiba os estados com a população menor que 4.000.000;
   13) Apague o dicionário de estados; -done
   14) Confirme se o dicionário está vazio. -done
*/
    public static void main(String[] args) {
        Map<String, Integer> PopulacaoNE1 = new HashMap<>() {{
           put("PE", 9616621);
           put("AL", 3351543);
           put("CE", 9187103);
           put("RN", 3534264);
        }};
        System.out.println("População estimada nos estados do NE: \n"+PopulacaoNE1);

        System.out.println("Substituindo a população do estado do RN por 3.534.165");
        PopulacaoNE1.put("RN", 3534165);
        System.out.println(PopulacaoNE1);

        System.out.println("Confira se o estado PB está no dicionário, caso não adicione:");
        PopulacaoNE1.put("PB", 4039277);
        System.out.println(PopulacaoNE1);

        System.out.println("Exiba a população de PE: " + PopulacaoNE1.get("PE"));

        Map<String, Integer> PopulacaoNE2 = new LinkedHashMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534264);
        }};
        System.out.println("Exiba todos os estados e suas populações na ordem que foi informado: \n"+PopulacaoNE2);

        Map<String, Integer> PopulacaoNE3 = new TreeMap<>(PopulacaoNE2);
        System.out.println("Exiba os estados e suas populações em ordem alfabética: \n"+PopulacaoNE3);

        System.out.println("Exiba o estado com a menor população e sua quantidade: ");
        Integer menorPopulacao = Collections.min(PopulacaoNE3.values());
        String cidadeComMenorPopulacao = "";
        for (Map.Entry<String, Integer> entry1 : PopulacaoNE3.entrySet()) {
            if (entry1.getValue().equals(menorPopulacao)){
                cidadeComMenorPopulacao = entry1.getKey();
                System.out.println("A cidade com menor população é: " + cidadeComMenorPopulacao + " - " + menorPopulacao);
            }
        }

        System.out.println("Exiba o estado com a maior população e sua quantidade: ");
        Integer maiorPopulacao = Collections.max(PopulacaoNE3.values());
        String cidadeComMaiorPopulacao = "";
        for (Map.Entry<String, Integer> entry2 : PopulacaoNE3.entrySet()) {
            if (entry2.getValue().equals(maiorPopulacao)) {
                cidadeComMaiorPopulacao = entry2.getKey();
                System.out.println("A cidade com maior população é: " + cidadeComMaiorPopulacao + " - " + maiorPopulacao);
            }
        }

        Iterator<Integer> somaPopulacao = PopulacaoNE3.values().iterator();
        Integer soma = 0;
        while (somaPopulacao.hasNext()) {
            soma += somaPopulacao.next();
        }
        System.out.println("A soma da população desses estados é: " + soma);

        System.out.println("A média da população deste dicionário de estados é: " + (soma/PopulacaoNE3.size()));

        System.out.println("Exiba os estados com a população menor que 4.000.000:");
        Set<Map.Entry<String, Integer>> populacao = PopulacaoNE3.entrySet();
        String cidadeMenorQue4M = "";
        Integer populacaoMenorQue4M = 0;
        for (Map.Entry<String, Integer> entry2 : PopulacaoNE3.entrySet()) {
            if (entry2.getValue() < 4000000){
                cidadeMenorQue4M = entry2.getKey();
                populacaoMenorQue4M = entry2.getValue();
                System.out.println(cidadeMenorQue4M + " - " + populacaoMenorQue4M);
            }
        }

        System.out.println("Apague o dicionário de estados");
        PopulacaoNE3.clear();

        System.out.println("Confirmando se o dicionário está vazio: " + PopulacaoNE3.isEmpty());
    }
}