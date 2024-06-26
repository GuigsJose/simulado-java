package br.edu.up.daos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.up.model.Endereco;
import br.edu.up.model.Pessoa;
import br.edu.up.model.PessoasComEndereco;

public class PessoaComEnderecoDAO {
    private PessoaDAO pessoaDAO;
    private EnderecoDAO enderecoDAO;
    
    private static final String FILE_NAME = "C:\\Users\\guize\\Desktop\\simulado-java\\simulado-java\\src\\br\\edu\\up\\daos\\PessoasComEnderecos.csv";

    public PessoaComEnderecoDAO(PessoaDAO pessoaDAO, EnderecoDAO enderecoDAO){
        this.pessoaDAO = pessoaDAO;
        this.enderecoDAO = enderecoDAO;
    }

    public List<PessoasComEndereco> getAll(){
        List<PessoasComEndereco> pessoasComEnderecos = new ArrayList<>();
        List<Pessoa> pessoas = new ArrayList<>();
        List<Endereco> enderecos = new ArrayList<>();

        for (Endereco endereco : enderecos) {
            Pessoa pessoa = pessoas.stream()
                                    .filter(p-> p.getCodigo() == endereco.getPessoa().getCodigo())
                                    .findFirst()
                                    .orElse(null);
            if (pessoa != null) {
                pessoasComEnderecos.add(new PessoasComEndereco(pessoa, endereco));                
            }
        }
        return pessoasComEnderecos;
    }

    public void salvar(PessoasComEndereco pessoasComEndereco){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME,true))){
            bw.write(pessoasComEndereco.toCsv() + "\n");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
