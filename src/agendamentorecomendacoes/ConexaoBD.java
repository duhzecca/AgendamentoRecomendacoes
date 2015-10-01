/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agendamentorecomendacoes;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ConexaoBD {

    private Connection myConnection;    
    private Statement st;   
    private static ConexaoBD instance;

    // Construtor
    public ConexaoBD() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String conexao = "jdbc:mysql://localhost/es_projeto";
            String usuario = "root";
            String senha = "";
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost/es_projeto?user=root&password=" + senha);

            //Cria um comando (statement) vinculado a conexao
            st = myConnection.createStatement();            
        } catch (Exception e) {
            System.out.println("Conexao mal sucedida");
            e.printStackTrace();
        }
    }
    
    public static ConexaoBD getInstance(){
        instance = new ConexaoBD();
        return instance;
    }
    
    //Busca os objetos cadastrados no banco de dados
    public ArrayList<ObjRecomendacao> buscaObjetos() throws SQLException{
        Statement s = myConnection.createStatement();
        ResultSet rs = s.executeQuery("SELECT titulo,cod FROM objeto_de_aprendizagem;");
        ArrayList<ObjRecomendacao> objetos = new ArrayList<ObjRecomendacao>();
        
        while(rs.next()){
            objetos.add(new ObjRecomendacao(rs.getString(1)));
        }
        
        s.close();
        rs.close();
        myConnection.close();
        
        return objetos;
    }

        public ArrayList<ObjRecomendacao> buscaPorTitulo(String titulo) throws SQLException{
        Statement s = myConnection.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM historico WHERE titulo LIKE '%" + titulo + "%';");                        
        ArrayList<ObjRecomendacao> objetos = new ArrayList<ObjRecomendacao>();
        
        while(rs.next()){
            objetos.add(new ObjRecomendacao(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
        }
        
        s.close();
        rs.close();
        myConnection.close();
        
        return objetos;
    }
        
        public ArrayList<ObjRecomendacao> buscaPorTurma(String turma) throws SQLException{
        Statement s = myConnection.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM historico WHERE turma LIKE '%" + turma + "%';");                        
        ArrayList<ObjRecomendacao> objetos = new ArrayList<ObjRecomendacao>();
        
        while(rs.next()){
            objetos.add(new ObjRecomendacao(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
        }
        
        s.close();
        rs.close();
        myConnection.close();
        
        return objetos;
    }
        
        
        public ArrayList<ObjRecomendacao> buscaPorTema(String tema) throws SQLException{
        Statement s = myConnection.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM historico WHERE tema LIKE '%" + tema + "%';");                        
        ArrayList<ObjRecomendacao> objetos = new ArrayList<ObjRecomendacao>();
        
        while(rs.next()){
            objetos.add(new ObjRecomendacao(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
        }
        
        s.close();
        rs.close();
        myConnection.close();
        
        return objetos;
    }
    
        public ArrayList<ObjRecomendacao> buscaPorAluno(String aluno) throws SQLException{
        Statement s = myConnection.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM historico WHERE aluno LIKE '%" + aluno + "%';");                        
        ArrayList<ObjRecomendacao> objetos = new ArrayList<ObjRecomendacao>();
        
        while(rs.next()){
            objetos.add(new ObjRecomendacao(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
        }
        
        s.close();
        rs.close();
        myConnection.close();
        
        return objetos;
    }
        
        public ArrayList<ObjRecomendacao> buscaPorData(String data) throws SQLException{
        Statement s = myConnection.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM historico WHERE data LIKE '%" + data + "%';");                        
        ArrayList<ObjRecomendacao> objetos = new ArrayList<ObjRecomendacao>();
        
        while(rs.next()){
            objetos.add(new ObjRecomendacao(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
        }
        
        s.close();
        rs.close();
        myConnection.close();
        
        return objetos;
    }
    
    //Busca os alunos cadastrados no banco de dados
    public ArrayList<Aluno> buscaAlunos() throws SQLException{
        Statement s = myConnection.createStatement();
        ResultSet rs = s.executeQuery("SELECT nome FROM aluno;");
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        
        while(rs.next()){
            alunos.add(new Aluno(rs.getString(1)));
        }
        
        s.close();
        rs.close();
        myConnection.close();
        
        return alunos;
    }
    
    public void insereRecomendacao(String titulo, String tema, String data, String aluno, String obj, String turma) throws SQLException {
        Statement s = myConnection.createStatement();
        
        String SQL = "INSERT INTO historico(titulo, tema, aluno, turma, titulo_obj, data) VALUES('"+titulo+"','"+tema+"','"+aluno+"','"+turma+"','"+obj+"','"+data+"');";
        boolean rs = s.execute(SQL);
        
        s.close();
    }
        
    
    public void atualizaRecomendacao(String titulo, String tema, String data, String aluno, String obj, String turma, String gambs) throws SQLException {
        Statement s = myConnection.createStatement();
                        
        String SQL = "UPDATE historico SET titulo = '"+titulo+"', tema = '"+tema+"', aluno = '"+aluno+"', turma = '"+turma+"', titulo_obj= '"+obj+"', data = '"+data+"'"
                +" WHERE titulo LIKE '%"+gambs+"%' ;"; 
        boolean rs = s.execute(SQL);
        
        s.close();
    }
    
    public void insereTemp(String nome) throws SQLException {
        Statement s = myConnection.createStatement();
        
        String SQL = "INSERT INTO tempaluno(nome) VALUES('"+nome+"');";
        boolean rs = s.execute(SQL);
        
        s.close();
    }
    
    public void insereTempObj(String titulo) throws SQLException {
        Statement s = myConnection.createStatement();
        
        String SQL = "INSERT INTO tempobjeto(titulo) VALUES('"+titulo+"');";
        boolean rs = s.execute(SQL);
        
        s.close();
    }
    


 public ArrayList<Aluno> buscaTempAlunos() throws SQLException{ //mudei o nome
        Statement s = myConnection.createStatement();
        ResultSet rs = s.executeQuery("SELECT nome FROM tempaluno;"); //mudei
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        
        while(rs.next()){
            alunos.add(new Aluno(rs.getString(1)));
        }
        
        s.close();
        rs.close();
        myConnection.close();
        
        return alunos;
    }
 
  public ArrayList<ObjRecomendacao> buscaTempObjetos() throws SQLException{ //mudei o nome
        Statement s = myConnection.createStatement();
        ResultSet rs = s.executeQuery("SELECT titulo FROM tempobjeto;"); //mudei
        ArrayList<ObjRecomendacao> objetos = new ArrayList<ObjRecomendacao>();
        
        while(rs.next()){
            objetos.add(new ObjRecomendacao(rs.getString(1)));
        }
        
        s.close();
        rs.close();
        myConnection.close();
        
        return objetos;
    }
 
 
  public void deleteTemp() throws SQLException{ //mudei o nome
         Statement s = myConnection.createStatement();
        
        String SQL = "TRUNCATE TABLE tempaluno;";
        boolean rs = s.execute(SQL);
        
        s.close();
    }
  
  public void deleteTempObj() throws SQLException{
        Statement s = myConnection.createStatement();
        
        String SQL = "TRUNCATE TABLE tempobjeto;";
        boolean rs = s.execute(SQL);
        
        s.close();
  }
  
    public void deleteRecomendacao(String rem) throws SQLException{
        Statement s = myConnection.createStatement();
        
        String SQL = "DELETE from historico where titulo = '" + rem + "' ;";
        boolean rs = s.execute(SQL);
        
        s.close();
  }
    
    public void removeRecomendacaoAntiga() throws SQLException{
        Statement s = myConnection.createStatement();
        
        String SQL = "DELETE from historico where data LIKE '%2010' or data LIKE '%2008' or data LIKE '%2009' ;";
        System.out.println(SQL);
        boolean rs = s.execute(SQL);
        
        s.close();
    }
 }
