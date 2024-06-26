package br.edu.up.model;

public class PessoasComEndereco {
    private Pessoa pessoa;
    private Endereco endereco;

    public PessoasComEndereco(Pessoa pessoa, Endereco endereco){
        this.pessoa = pessoa;
        this.endereco = endereco;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String toCsv(){
        return pessoa.getCodigo() + ";" + pessoa.getNome() + ";" + endereco.getRua() + ";" + endereco.getCidade();
    }
}

