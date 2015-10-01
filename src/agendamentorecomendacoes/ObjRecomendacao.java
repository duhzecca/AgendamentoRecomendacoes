/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agendamentorecomendacoes;

/**
 *
 * @author user
 */
public class ObjRecomendacao {
    
    private String titulo;
    private String tema;
    private String observacao;
    private String  dataAgenda;
    private String aluno;
    private String objAprendizagem;
    private String turma;

    
    public ObjRecomendacao(String titulo, String tema, String aluno, String observacao, String objAprendizagem, String dataAgenda){
        this.titulo = titulo;
        this.tema = tema;
        this.aluno = aluno;
        this.observacao = observacao;
        this.objAprendizagem = objAprendizagem;
        this.dataAgenda = dataAgenda;
    }      

    public ObjRecomendacao(String titulo, String tema, String observacao, String dataAgenda) {
        this.titulo = titulo;
        this.tema = tema;
        this.observacao = observacao;
        this.dataAgenda = dataAgenda;
    }

    public ObjRecomendacao(String titulo, String tema, String observacao, String dataAgenda, String aluno, String objAprendizagem, String turma) {
        this.titulo = titulo;
        this.tema = tema;
        this.observacao = observacao;
        this.dataAgenda = dataAgenda;
        this.aluno = aluno;
        this.objAprendizagem = objAprendizagem;
        this.turma = turma;
    }
    
    public ObjRecomendacao() {

    }

    public ObjRecomendacao(String titulo, String objAprendizagem) {
        this.titulo = titulo;
        this.objAprendizagem = objAprendizagem;
    }
    
    
    public ObjRecomendacao(String titulo) {
        this.titulo = titulo;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
    
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getDataAgenda() {
        return dataAgenda;
    }

    public void setDataAgenda(String dataAgenda) {
        this.dataAgenda = dataAgenda;
    }

    public String getObjAprendizagem() {
        return objAprendizagem;
    }

    public void setObjAprendizagem(String objAprendizagem) {
        this.objAprendizagem = objAprendizagem;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}
