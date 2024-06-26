package br.edu.up.model;

public class Endereco {

    private String rua;
    private String cidade;
    private Pessoa pessoa;

    public Endereco(String rua, String cidade, Pessoa pessoa){
        this.rua = rua;
        this.cidade = cidade;
        this.pessoa = pessoa;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    

    public String toCsv(){
        return rua + ";" + cidade + ";" + pessoa.getCodigo();
    }
}
