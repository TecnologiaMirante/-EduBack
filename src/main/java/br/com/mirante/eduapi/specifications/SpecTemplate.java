package br.com.mirante.eduapi.specifications;

import br.com.mirante.eduapi.models.*;
import br.com.mirante.eduapi.models.Aula;
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
            @Spec(path = "nome", spec = Like.class),
            @Spec(path = "email", spec = Equal.class),
            @Spec(path = "telefone", spec = Equal.class),
            @Spec(path = "cpf", spec = Equal.class),
            @Spec(path = "matricula", spec = Equal.class)
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

    public interface  OpcoesSpec extends Specification<Opcoes> {}

    public interface ProfessorSpec extends Specification<Professor> {}

    public interface AlunoSpec extends Specification<Aluno> {}

    public interface UsuarioResponsavelSpec extends Specification<UsuarioResponsavel> {}

    public interface ConquistaSpec extends Specification<Conquistas> {}

    public interface EloSpec extends Specification<Elo> {}

    public interface AlunoInterecaoSpec extends Specification<AlunoInteracao>{}

    public interface AdminSpec extends Specification<Admin> {}

}
