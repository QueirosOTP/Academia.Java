package academia.main;

public class Treino {
    private int id;
    private int idAluno;
    private String tipo;
    private String descricao;
    private int duracao;
    private String dataInicio;

    public Treino(int idAluno, String tipo, String descricao, int duracao, String dataInicio) {
        this.idAluno = idAluno;
        this.tipo = tipo;
        this.descricao = descricao;
        this.duracao = duracao;
        this.dataInicio = dataInicio;
    }

    public Treino(int id, int idAluno, String tipo, String descricao, int duracao, String dataInicio) {
        this.id = id;
        this.idAluno = idAluno;
        this.tipo = tipo;
        this.descricao = descricao;
        this.duracao = duracao;
        this.dataInicio = dataInicio;
    }

    public int getId() { return id; }
    public int getIdAluno() { return idAluno; }
    public String getTipo() { return tipo; }
    public String getDescricao() { return descricao; }
    public int getDuracao() { return duracao; }
    public String getDataInicio() { return dataInicio; }
}