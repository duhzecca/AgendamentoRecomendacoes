/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agendamentorecomendacoes;

/**
 *
 * @author user
 */
public class Aluno {
    
    private String nome;
    private String turma;
    private String curso;
    private int ano;

    Aluno(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
    
    
}
