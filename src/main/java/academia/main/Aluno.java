package academia.main;

public class Aluno {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String dataNascimento;
    private String telefone;

    public Aluno(String nome, String email, String cpf, String dataNascimento, String telefone) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public Aluno(int id, String nome, String email, String cpf, String dataNascimento, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getCpf() { return cpf; }
    public String getDataNascimento() { return dataNascimento; }
    public String getTelefone() { return telefone; }
}