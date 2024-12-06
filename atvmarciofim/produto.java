package ControledeEstoque;
public class Produto {   



    private String nome;
    private int quantidade;
    private double preco;
    private String categoria;
   
    public Produto() {
    }
    public Produto(String nome, int quantidade, double preco, String categoria) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.categoria = categoria;
    }
   
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    @Override
    public String toString() {
        return String.format("Produto {nome='%s', quantidade=%d, preco=R$%.2f, categoria='%s'}",
                nome, quantidade, preco, categoria);
    }
}