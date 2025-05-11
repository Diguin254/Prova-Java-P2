package controller;

import dao.FuncionarioDao;
import dao.TelefoneDao;
import dto.FuncionarioDTO;
import dto.TelefoneDTO;
import implementsDao.FuncionarioImplementsDAO;
import implementsDao.TelefoneImplementsDAO;
import java.sql.SQLException;
import model.Funcionario;
import model.Telefone;
import java.util.LinkedList;
import java.util.List;

public class FuncionarioController {

    private final FuncionarioDao funcionarioDao;
    private final TelefoneDao telefoneDao;

    public FuncionarioController() {
        this.funcionarioDao = new FuncionarioImplementsDAO();
        this.telefoneDao = new TelefoneImplementsDAO();
    }

    public void salvar(FuncionarioDTO funcionarioDTO) throws SQLException {
        Funcionario f = funcionarioDTO.builder();
        funcionarioDao.salvar(f);

        if (f.getTelefones() != null) {
            for (Telefone t : f.getTelefones()) {
                t.setFuncionario(f);
                telefoneDao.salvar(t);
            }
        }
    }

    public void editar(FuncionarioDTO funcionarioDTO) throws SQLException {
        Funcionario f = funcionarioDTO.builder();
        funcionarioDao.editar(f);

        if (f.getTelefones() != null) {
            for (Telefone t : f.getTelefones()) {
                t.setFuncionario(f);
                if (t.getId() == 0) {
                    telefoneDao.salvar(t);
                } else {
                    telefoneDao.editar(t);
                }
            }
        }
    }

    public void deletar(int id) throws SQLException {
        List<Telefone> todos = telefoneDao.listar();

        for (Telefone tel : todos) {
            if (tel.getFuncionario() != null && tel.getFuncionario().getId().equals(id)) {
                telefoneDao.deletar(tel.getId());
            }
        }

        funcionarioDao.deletar(id);
    }

    public List<FuncionarioDTO> listar() throws SQLException {
        List<Funcionario> lista = funcionarioDao.listar();
        List<Telefone> listaTel = telefoneDao.listar();

        List<FuncionarioDTO> listaDTO = new LinkedList<>();
        for (Funcionario f : lista) {
            List<Telefone> telefones = new LinkedList<>();
            for (Telefone tel : listaTel) {
                if (tel.getFuncionario() != null && tel.getFuncionario().getId() == f.getId()) {
                    telefones.add(tel);
                }
            }
            f.setTelefones(telefones);

            FuncionarioDTO dto = new FuncionarioDTO();
            dto.idFuncionario = String.valueOf(f.getId());
            dto.nomeFun = f.getNome();
            dto.cpfFun = f.getCpf();
            dto.rgFun = f.getRg();
            dto.idLogin = String.valueOf(f.getLogin().getId());

            if (telefones != null) {
                List<TelefoneDTO> teleDtos = new LinkedList<>();
                for (Telefone tel : telefones) {
                    TelefoneDTO tDto = new TelefoneDTO();
                    tDto.idTel = String.valueOf(tel.getId());
                    tDto.numTel = tel.getNumero();
                    teleDtos.add(tDto);
                }
                dto.telefones = teleDtos;
            }
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
