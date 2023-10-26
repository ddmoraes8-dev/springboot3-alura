package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.endereco.Endereco;

@Table(name="medicos")
@Entity(name="Medico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private EspecialidadeEnum especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());

    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados){
        this.nome = dados.nome() != null ? dados.nome(): this.nome;
        this.telefone = dados.telefone() != null ? dados.telefone(): this.telefone;
        if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados);
        }

    }

    public void desativarMedico(Long id) {
        this.ativo = false;
    }
}
