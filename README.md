# 1. criar um repositório com nome: simulado
# 2. criar os arquivos A e B com editor de texto
# 3. criar um projeto java para ler os arquivos A e B e gerar o C com Orientação a objetos(Listas também)
# 4. versionar no git.

A: pessoas.csv:

| codigo | nome |
|--------|------|
|  1     | Paulo|
|2|Carlos       |
|3|Ana          |

B: enderecos.csv:
| rua; | cidade; | codigo(pessoa); |
|-----|--------|----------------|
| Rua A;| Curitiba;|1;|
| Rua B;| São paulo;|1;|
| Rua C;| blumenau;|3;|

C: pessoasComEnderecos.csv:
|codigo;|nome;|rua;|cidade|
|-------|-----|----|------|
|1;|paulo|rua A| curitiba|
|1;|paulo|rua B| São Paulo|
|3;|Ana|rua C| Blumenau|

## Classe Pessoa:

```
public class Pessoa{
    private int codigo;
    private String nome;
    private String rua;
    private String cidade;

    // getters and setters

    public String toCsv(){
        return codigo + ";" nome + ";" + rua + ";" + cidade + ";";
    }
}

```


