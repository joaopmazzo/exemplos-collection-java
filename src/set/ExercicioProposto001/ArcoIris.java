package set.ExercicioProposto001;

import java.lang.reflect.Array;
import java.util.*;

public class ArcoIris {

    public static void main(String[] args) {
        //1 - criar um conjunto contendo as cores do arco-iris - done
        //2 - exibir todas as cores uma abaixo da outra - done
        //3 - a quantidade de cores que o arco iris tem - done
        //4 - exiba as cores em ordem alfabetica - done
        //6 - exiba todas as cores que começam com a letra "v" - done
        //7 - remova todas as cores que não começam com a letra "v" - done
        //8 - limpe o conjunto - done
        //9 - confira se o conjunto esta vazio - done

        //5 - exiba as cores na ordem inversa da que foi informada

        Set<String> coresArcoIris = new LinkedHashSet<>(Arrays.asList("vermelho", "laranja", "amarelo", "verde", "azul", "anil", "violeta"));

        System.out.println("Exibir todas as cores uma abixo da outra:");
        for (String cores : coresArcoIris) System.out.println(cores);

        System.out.println("A quantidade de cores que o arco iris tem: " + coresArcoIris.size());

        System.out.println("Exiba as cores em ordem alfabética:");
        Set<String> coresArcoIrisOrdemAlfatebica = new TreeSet<>(coresArcoIris);
        System.out.println(coresArcoIrisOrdemAlfatebica);

        System.out.println("Exiba as cores na ordem inversa da que foi informada: ");
        List<String> coresInversas = new ArrayList<>(coresArcoIris);
        Collections.reverse(coresInversas);
        System.out.println(coresInversas);
//        Outra opção de se inverter o array.
//        ListIterator listaInversa = coresInversas.listIterator(coresInversas.size());
//        while (listaInversa.hasPrevious()) System.out.println(listaInversa.previous());

        System.out.println("Exiba as cores que começam a letra 'v':");
        Iterator<String> iterator1 = coresArcoIris.iterator();
        while (iterator1.hasNext()) {
            String coresComV = iterator1.next();
            if (coresComV.toLowerCase().startsWith("v")) System.out.println(coresComV);
        }

        System.out.println("Remova todas as cores que não começam com a letra 'v':");
        Iterator<String> iterator2 = coresArcoIris.iterator();
        while (iterator2.hasNext()) {
            String coresSemV = iterator2.next();
            if (coresSemV.toLowerCase().startsWith("v")) iterator2.remove();
        }
        System.out.println(coresArcoIris);

        System.out.println("Limpando o conjunto");
        coresArcoIris.clear();

        System.out.println("Conferindo se o conjunto está vazio: " + coresArcoIris.isEmpty());
    }
}
