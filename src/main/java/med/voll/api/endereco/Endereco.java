package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.medico.DadosAtualizacaoMedico;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados){

        this.logradouro = dados.endereco().logradouro() != null? dados.endereco().logradouro() : this.logradouro;
        this.bairro = dados.endereco().bairro() != null? dados.endereco().bairro() : this.bairro;
        this.cep = dados.endereco().cep() != null? dados.endereco().cep() : this.cep;
        this.numero = dados.endereco().numero() != null? dados.endereco().numero() : this.numero;
        this.complemento =dados.endereco().complemento() != null? dados.endereco().complemento() : this.complemento;
        this.cidade = dados.endereco().cidade() != null? dados.endereco().cidade() : this.cidade;
        this.uf = dados.endereco().uf() != null? dados.endereco().uf() : this.uf;
    }
}
