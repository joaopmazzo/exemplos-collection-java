package set.ExercicioProposto002;

import java.util.*;

public class LinguagemFavorita {

/*
    1) Criar um array que possua os atributos NOME, ANO DE CRIAÇÃO e IDE; -done
    2) Em seguida adicione três conjuntos de linguagem e ordene por: -done
        a) ordem de inserção; -done
        b) ordem natural (nome); -done
        c) IDE; -done
        d) ano de criação e nome; -done
        f) nome, ano de criação e ide;
    3) Ao final exiba as linguagens no console uma abaixo da oura.
*/
    public static void main(String[] args) {

        Set<Linguagem> linguagemFavorita = new HashSet<>() {{
            add(new Linguagem("Python", 1991, "Pycharm"));
            add(new Linguagem("JavaScript", 1995, "Visual Studio Code"));
            add(new Linguagem("Java", 1991, "Intellij"));
        }};

        Set<Linguagem> linguagemFavorita2 = new LinkedHashSet<>() {{
            add(new Linguagem("Python", 1991, "Pycharm"));
            add(new Linguagem("JavaScript", 1995, "Visual Studio Code"));
            add(new Linguagem("Java", 1991, "Intellij"));
        }};
        System.out.println("ordem de inserção: \n" + linguagemFavorita2);

        Set<Linguagem> linguagemFavorita3 = new TreeSet<>(linguagemFavorita);
        System.out.println("ordem natural: \n" + linguagemFavorita3);

        Set<Linguagem> linguagemFavorita4 = new TreeSet<>(new OdernaPorIDE());
        linguagemFavorita4.addAll(linguagemFavorita);
        System.out.println("Ordenando por IDEs: \n" + linguagemFavorita4);

        Set<Linguagem> linguagemFavorita5 = new TreeSet<>(new OrdenarPorAnoDeCriacaoNome());
        linguagemFavorita5.addAll(linguagemFavorita);
        System.out.println("Ordenando por Ano de Criação/Nome \n" + linguagemFavorita5);

        Set<Linguagem> linguagemFavorita6 = new TreeSet<>(new OrdernarPorNomeAnoDeCriacaoIDE());
        linguagemFavorita6.addAll(linguagemFavorita);
        System.out.println("Ordenando por Nome/Ano de Criação/IDEs: \n" + linguagemFavorita6);
    }
}

class Linguagem implements Comparable<Linguagem> {
    private String nome;
    private Integer anoDeCriacao;
    private String ide;

    public Linguagem(String nome, Integer anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", anoDeCriacao=" + anoDeCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linguagem linguagem = (Linguagem) o;
        return nome.equals(linguagem.nome) && anoDeCriacao.equals(linguagem.anoDeCriacao) && ide.equals(linguagem.ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeCriacao, ide);
    }


    @Override
    public int compareTo(Linguagem linguagem) {
        return this.nome.compareToIgnoreCase(linguagem.nome);
    }
}

class OdernaPorIDE implements Comparator<Linguagem> {

    @Override
    public int compare(Linguagem s1, Linguagem s2) {
        return s1.getIde().compareToIgnoreCase(s2.getIde());
    }
}

class OrdenarPorAnoDeCriacaoNome implements Comparator<Linguagem> {

    @Override
    public int compare(Linguagem s1, Linguagem s2) {
        int anoDeCriacao = Integer.compare(s1.getAnoDeCriacao(), s2.getAnoDeCriacao());
        if (anoDeCriacao != 0) return anoDeCriacao;

        return s1.getNome().compareToIgnoreCase(s2.getNome());
    }
}

class OrdernarPorNomeAnoDeCriacaoIDE implements Comparator<Linguagem> {

    @Override
    public int compare(Linguagem s1, Linguagem s2) {
        int nome = s1.getNome().compareToIgnoreCase(s2.getNome());
        if (nome != 0) return nome;

        int anoDeCriacao = Integer.compare(s1.getAnoDeCriacao(), s2.getAnoDeCriacao());
        if (anoDeCriacao != 0) return anoDeCriacao;

        return s1.getIde().compareToIgnoreCase(s2.getIde());
    }
}