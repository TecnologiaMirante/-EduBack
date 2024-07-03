package br.com.mirante.eduapi.specifications;

import br.com.mirante.eduapi.models.Aula;
import br.com.mirante.eduapi.models.Escola;
import br.com.mirante.eduapi.models.Usuario;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;
import java.util.UUID;

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
           @Spec(path = "titulo", spec = Like.class),
           @Spec(path = "decricao", spec = Equal.class),
           @Spec(path = "link", spec = Like.class),
           @Spec(path = "arquivo", spec = Like.class),
           @Spec(path = "avaliacao", spec = Equal.class),
           @Spec(path = "img", spec = Like.class),
    })
    public interface AulaSpec extends Specification<Aula> {}

    public interface UsuarioSpec extends Specification<Usuario> {}


}