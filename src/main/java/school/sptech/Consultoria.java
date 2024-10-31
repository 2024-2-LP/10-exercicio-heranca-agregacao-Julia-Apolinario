package school.sptech;


import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria extends DesenvolvedorWeb{
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria() {
    }

    public Consultoria(String nome, Integer vagas, List<Desenvolvedor> desenvolvedores) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = desenvolvedores;
    }

    public Boolean contratar (Desenvolvedor desenvolvedor){
       if (vagas > desenvolvedores.size() ){
           desenvolvedores.add(desenvolvedor);
           return true;
       }return false;
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor){

                if (desenvolvedor.isFullstack()){
                    desenvolvedores.add(desenvolvedor);
                    return true;
                }
        return false;
    }

    public Double getTotalSalarios(){
        Double soma = 0.0;
        for (Desenvolvedor desenvolvedorDaVez : desenvolvedores){
            soma += desenvolvedorDaVez.calcularSalario();

        }
        return soma;
    }

    public Integer qtdDesenvolvedoresMobile() {
        Integer cont = 0;
        for (Desenvolvedor desenvolvedorDaVez : desenvolvedores) {
            if (desenvolvedorDaVez instanceof DesenvolvedorMobile) {
                cont++;
            }

        }return cont;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> maiorSalario = new ArrayList<>();
        for (Desenvolvedor desenvolvedorDaVez : desenvolvedores) {
            if (desenvolvedorDaVez.calcularSalario() >= salario) {

                maiorSalario.add(desenvolvedorDaVez);

            }
        }return maiorSalario;
    }

//    public Desenvolvedor buscarMenorSalario(){
//        List<Desenvolvedor> maiorSalario = new ArrayList<>();
//        for (Desenvolvedor desenvolvedorDaVez : desenvolvedores) {
//            if (desenvolvedorDaVez.calcularSalario() >= salario) {
//
//                maiorSalario.add(desenvolvedorDaVez);
//
//            }
//        }return maiorSalario;
//    }





    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }
}
