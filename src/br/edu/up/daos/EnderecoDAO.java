package br.edu.up.daos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.up.model.Endereco;
import br.edu.up.model.Pessoa;

public class EnderecoDAO {
    private static final String FILE_NAME = "C:\\Users\\guize\\Desktop\\simulado-java\\simulado-java\\src\\br\\edu\\up\\daos\\Enderecos.csv";

    private PessoaDAO pessoaDAO;

    public EnderecoDAO(PessoaDAO dao){
        this.pessoaDAO = dao;
    }

    public List<Endereco> getrAll(){
        List<Endereco> enderecos = new ArrayList<>();
        List<Pessoa> pessoas = pessoaDAO.getAll();

        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            String linha;
            while((linha = br.readLine())!= null){
                String[] dados = linha.split(";");
                int codigoPessoa = Integer.parseInt(dados[2].trim());
                Pessoa pessoa = pessoas.stream()
                                        .filter(p -> p.getCodigo() == codigoPessoa)
                                        .findFirst()
                                        .orElse(null);
                if (pessoa != null) {
                    Endereco endereco = new Endereco(dados[0].trim(), dados[1].trim(), pessoa);
                    enderecos.add(endereco);
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return enderecos;
    }

    public void salvar(Endereco endereco){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))){
            bw.write(endereco.toCsv() + "\n");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
