package main.java.service;

import java.util.Optional;
import main.java.dao.DAOException;
import main.java.dao.IPessoaDAO;
import main.java.data.Pessoa;

public class PessoaService {
    private final IPessoaDAO pessoaDAO;
    
    public PessoaService(IPessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }
    
    public boolean registrarAluno(Pessoa pessoa) throws ServiceException {
        if (pessoa.getEmail() == null || pessoa.getEmail().isBlank()) {
            throw new ServiceException("Email não pode ser vazio");
        }
        if (pessoa.getSenha() == null || pessoa.getSenha().length() < 6) {
            throw new ServiceException("Senha deve ter pelo menos 6 caracteres");
        }
        
        try {
            return pessoaDAO.salvar(pessoa, "aluno");
        } catch (ServiceException se) {
            throw new ServiceException("Erro ao registrar aluno", se);
        }
    }
    
    public boolean registrarInstituicao(Pessoa pessoa) throws ServiceException {
        if (pessoa.getEmail() == null || pessoa.getEmail().isBlank()) {
            throw new ServiceException("Email não pode ser vazio");
        }
        if (pessoa.getSenha() == null || pessoa.getSenha().length() < 6) {
            throw new ServiceException("Senha deve ter pelo menos 6 caracteres");
        }
        
        try {
            return pessoaDAO.salvar(pessoa, "instituicao");
        } catch (ServiceException se) {
            throw new ServiceException("Erro ao registrar instituição", se);
        }
    }
    
    public boolean registrarProfessor(Pessoa pessoa) throws ServiceException {
        if (pessoa.getEmail() == null || pessoa.getEmail().isBlank()) {
            throw new ServiceException("Email não pode ser vazio");
        }
        if (pessoa.getSenha() == null || pessoa.getSenha().length() < 6) {
            throw new ServiceException("Senha deve ter pelo menos 6 caracteres");
        }
        
        try {
            return pessoaDAO.salvar(pessoa, "professor");
        } catch (ServiceException se) {
            throw new ServiceException("Erro ao registrar professor", se);
        }
    }
    
    public Optional<Pessoa> login(String email, String senha) throws ServiceException {
        try {
             return pessoaDAO.login(email, senha);
        } catch (ServiceException se) {
            throw new ServiceException("Erro ao efetuar login", se);
        }
    }
     
    public void alterarSenha(String email, String novaSenha) throws ServiceException {
        try {
            Optional<Pessoa> pessoaOpt = pessoaDAO.buscarPorEmail(email);

            if (pessoaOpt.isEmpty()) {
                throw new ServiceException("Usuário não encontrado para o email informado");
            }

            Pessoa pessoa = pessoaOpt.get();
            pessoa.setSenha(novaSenha);

            boolean sucesso = pessoaDAO.salvar(pessoa, "aluno"); 
            if (!sucesso) {
                throw new ServiceException("Falha ao atualizar a senha no banco de dados");
            }
        } catch (DAOException | ServiceException e) {
            throw new ServiceException("Erro ao alterar a senha", e);
        }
    }
     
    public Optional<Pessoa> buscarPorEmail(String email) throws ServiceException {
        try {
            return pessoaDAO.buscarPorEmail(email);
        } catch (DAOException daoe) {
            throw new ServiceException("Erro ao buscar usuário por email", daoe);
        }
    }
}
