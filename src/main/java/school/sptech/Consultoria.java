package school.sptech;


import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria extends DesenvolvedorWeb {
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

    public Desenvolvedor buscarMenorSalario(){

        if (desenvolvedores.isEmpty()){
            return null;
        }
        Desenvolvedor menorSalario = desenvolvedores.get(0);
        for (Desenvolvedor desenvolvedorDaVez : desenvolvedores) {
            if (desenvolvedorDaVez.calcularSalario().compareTo(menorSalario.calcularSalario()) <0 ) {

                menorSalario = desenvolvedorDaVez;

            }
        }return menorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> devsComTecnologia = new ArrayList<>();

        for (Desenvolvedor dev : desenvolvedores) {
            if (dev instanceof DesenvolvedorWeb) {
                DesenvolvedorWeb devWeb = (DesenvolvedorWeb) dev;
                if (tecnologia.equalsIgnoreCase(devWeb.getFrontend()) || tecnologia.equalsIgnoreCase(devWeb.getBackend()) || tecnologia.equalsIgnoreCase(devWeb.getSgbd())) {
                    devsComTecnologia.add(devWeb);
                }
            } else if (dev instanceof DesenvolvedorMobile) {
                DesenvolvedorMobile devMobile = (DesenvolvedorMobile) dev;
                if (tecnologia.equalsIgnoreCase(devMobile.getPlataforma()) || tecnologia.equalsIgnoreCase(devMobile.getLinguagem())) {
                    devsComTecnologia.add(devMobile);
                }
            }
        }
        return devsComTecnologia;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        Double totalSalarios = 0.0;

        List<Desenvolvedor> devsComTecnologia = buscarPorTecnologia(tecnologia);

        for (Desenvolvedor dev : devsComTecnologia) {
            totalSalarios += dev.calcularSalario();
        }

        return totalSalarios;
    }






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
