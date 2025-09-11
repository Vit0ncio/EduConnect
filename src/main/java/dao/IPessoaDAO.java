package main.java.dao;

import main.java.data.Pessoa;
import java.util.Optional;

public interface IPessoaDAO {
    boolean salvar(Pessoa pessoa, String tipoUsuario) throws DAOException;
    Optional<Pessoa> login(String email, String senha) throws DAOException;
    Optional<Pessoa> buscarPorEmail(String email) throws DAOException;
}
