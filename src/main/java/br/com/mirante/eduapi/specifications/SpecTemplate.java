package br.com.mirante.eduapi.specifications;

import br.com.mirante.eduapi.models.*;
import br.com.mirante.eduapi.models.Escola;
import br.com.mirante.eduapi.models.Questoes;
import br.com.mirante.eduapi.models.Usuario;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

public class SpecTemplate {
    @And({
            @Spec(path = "nome", spec = Like.class),
            @Spec(path = "email", spec = Equal.class),
            @Spec(path = "telefone", spec = Equal.class),
            @Spec(path = "estado", spec = Equal.class),
            @Spec(path = "cidade", spec = Like.class)
    })
    public interface EscolaSpec extends Specification<Escola> {}

    @And({
            @Spec(path = "nome_usuario", spec = Like.class),
            @Spec(path = "email_usuario", spec = Equal.class),
            @Spec(path = "telefone_usuario", spec = Equal.class),
            @Spec(path = "cpf_usuario", spec = Equal.class),
            @Spec(path = "matricula_usuario", spec = Equal.class)
    })
    public interface UsuarioSpec extends Specification<Usuario> {}

    @And({
           @Spec(path = "titulo", spec = Like.class),
           @Spec(path = "decricao", spec = Equal.class),
           @Spec(path = "link", spec = Like.class),
           @Spec(path = "arquivo", spec = Like.class),
           @Spec(path = "avaliacao", spec = Equal.class),
           @Spec(path = "img", spec = Like.class),
    })
    public interface AulaSpec extends Specification<Aula> {}


    @And({
            @Spec(path = "titulo",spec = Like.class)
    })
    public interface QuestoesSpac extends Specification<Questoes>{}

    @And({
            @Spec(path = "descricao",spec = Like.class)
    })
    public interface  OpcoesSpec extends Specification<Opcoes> {}

    @And({
            @Spec(path = "formacao", spec = Like.class),
            @Spec(path = "materias", spec = Equal.class),
            @Spec(path = "experiencia", spec = Equal.class),
    })
    public interface  RankAlunoSpec extends  Specification<RankAluno>{}
    @And({
            @Spec( path = "primeiro", spec = Like.class),
            @Spec( path = "segundo", spec = Like.class),
            @Spec( path = "terceiro", spec = Like.class),
    })
    public interface RankGeralSpec extends Specification<RankGeral>{}
    @And({
            @Spec( path = "primeiro", spec = Like.class),
            @Spec( path = "segundo", spec = Like.class),
            @Spec( path = "terceiro", spec = Like.class),
    })
    public interface RankTurmaSpec extends Specification<RankTurma>{}
    @And({
            @Spec( path = "primeiro", spec = Like.class),
            @Spec( path = "segundo", spec = Like.class),
            @Spec( path = "terceiro", spec = Like.class),
    })
    public interface RankSerieSpec extends Specification<RankSerie>{}


    @And({

    })
    public interface ProfessorSpec extends Specification<Professor> {}

    @And({
            @Spec(path = "permissoes", spec = Equal.class)
    })
    public interface AlunoSpec extends Specification<Aluno> {}

    @And({
            @Spec(path = "nome", spec = Like.class),
            @Spec(path = "email", spec = Equal.class),
            @Spec(path = "telefone", spec = Equal.class),
            @Spec(path = "cpf", spec = Equal.class),
    })
    public interface UsuarioResponsavelSpec extends Specification<UsuarioResponsavel> {}

    @And({
            @Spec(path = "nome_conquista", spec = Like.class),
            @Spec(path = "descricao_conquista", spec = Like.class),
            @Spec(path = "meta", spec = Like.class)
    })
    public interface ConquistaSpec extends Specification<Conquistas> {}

    @And({
            @Spec(path = "nome_elo", spec = Like.class),
            @Spec(path = "pontuacao_elo", spec = Equal.class)
    })
    public interface EloSpec extends Specification<Elo> {}

    @And({
            @Spec(path = "anotar", spec = Like.class),
            @Spec(path = "avaliar", spec = Equal.class),
            @Spec(path = "comentario", spec = Like.class)
    })
    public interface AlunoInterecaoSpec extends Specification<AlunoInteracao>{}

    @And({

    })
    public interface AdminSpec extends Specification<Admin> {}

    @And({
            @Spec(path = "pontuacao_aluno", spec = Equal.class)
    })
    public interface AlunoEloSpec extends Specification<AlunosElo>{}

}
