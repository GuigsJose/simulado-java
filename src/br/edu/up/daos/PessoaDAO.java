package br.edu.up.daos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.up.model.Pessoa;

public class PessoaDAO {
    String arquivo = "C:\\Users\\guize\\Desktop\\simulado-java\\simulado-java\\src\\br\\edu\\up\\daos";

    private static final String FILE_NAME = "C:\\Users\\guize\\Desktop\\simulado-java\\simulado-java\\src\\br\\edu\\up\\daos\\Pessoas.csv";

    public List<Pessoa> getAll(){
        List<Pessoa> pessoas = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split("\\;");
                pessoas.add(new Pessoa(Integer.parseInt(dados[0].trim()), dados[1].trim()));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return pessoas;
    }

    public void salvar(Pessoa pessoa){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))){
            bw.write(pessoa.toCsv() + "\n");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
