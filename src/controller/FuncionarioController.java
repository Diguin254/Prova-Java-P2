package controller;

import dao.FuncionarioDao;
import dao.TelefoneDao;
import dto.FuncionarioDTO;
import dto.InterfaceDTO;
import dto.TelefoneDTO;
import implementsDao.FuncionarioImplementsDAO;
import implementsDao.TelefoneImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Funcionario;
import model.Telefone;

public class FuncionarioController extends InterfaceController {

    private final FuncionarioDao funcionarioDao = new FuncionarioImplementsDAO();
    private final TelefoneDao telefoneDao = new TelefoneImplementsDAO();

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        Funcionario f = ((FuncionarioDTO) dto).builder();
        funcionarioDao.salvar(f);

        if (f.getTelefones() != null) {
            for (Telefone t : f.getTelefones()) {
                t.setFuncionario(f);
                telefoneDao.salvar(t);
            }
        }
    }

    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        Funcionario f = ((FuncionarioDTO) dto).builder();
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

    @Override
    public void deletar(int id) throws SQLException {
        for (Telefone tel : telefoneDao.listar()) {
            if (tel.getFuncionario() != null && tel.getFuncionario().getId().equals(id)) {
                telefoneDao.deletar(tel.getId());
            }
        }

        funcionarioDao.deletar(id);
    }

    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<Funcionario> lista = funcionarioDao.listar();
        List<Telefone> listaTel = telefoneDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();

        for (Funcionario f : lista) {
            List<Telefone> telefones = new LinkedList<>();
            for (Telefone tel : listaTel) {
                if (tel.getFuncionario() != null && tel.getFuncionario().getId().equals(f.getId())) {
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

            if (!telefones.isEmpty()) {
                dto.telefones = new LinkedList<>();
                for (Telefone tel : telefones) {
                    TelefoneDTO tDto = new TelefoneDTO();
                    tDto.idTel = String.valueOf(tel.getId());
                    tDto.numTel = tel.getNumero();
                    dto.telefones.add(tDto);
                }
            }

            listaDTO.add((InterfaceDTO) dto);
        }

        return listaDTO;
    }
}
