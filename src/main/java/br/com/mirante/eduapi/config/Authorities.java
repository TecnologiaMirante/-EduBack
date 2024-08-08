package br.com.mirante.eduapi.config;

import org.springframework.stereotype.Component;

@Component("AUTHORITIES")
public final class Authorities {
    public static final String ESCOLA_CONSULTAR  = "ESCOLA_CONSULTAR";
    public static final String ESCOLA_CADASTRAR  = "ESCOLA_CADASTRAR";
    public static final String ESCOLA_DELETAR  = "ESCOLA_DELETAR";
    public static final String ESCOLA_ATUALIZAR  = "ESCOLA_ATUALIZAR";


    public static final String USUARIO_CONSULTAR  = "USUARIO_CONSULTAR";
    public static final String USUARIO_CADASTRAR  = "USUARIO_CADASTRAR";
    public static final String USUARIO_DELETAR  = "USUARIO_DELETAR";
    public static final String USUARIO_ATUALIZAR  = "USUARIO_ATUALIZAR";

}
