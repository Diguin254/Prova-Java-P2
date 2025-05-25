package controller;

import controller.InterfaceController;
import dao.TelefoneDao;
import dto.InterfaceDTO;
import dto.TelefoneDTO;
import implementsDao.TelefoneImplementsDAO;
import model.Telefone;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TelefoneController extends InterfaceController {

    private final TelefoneDao telefoneDao;

    public TelefoneController() {
        this.telefoneDao = new TelefoneImplementsDAO();
    }

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        telefoneDao.salvar(((TelefoneDTO)dto).builder());
    }

    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        telefoneDao.editar(((TelefoneDTO)dto).builder());
    }

    @Override
    public void deletar(int id) throws SQLException {
        telefoneDao.deletar(id);
    }

    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<Telefone> lista = telefoneDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();
        for (Telefone tel : lista) {
            TelefoneDTO dto = new TelefoneDTO();
            dto.idTel = String.valueOf(tel.getId());
            dto.dddTel = String.valueOf(tel.getDdd());
            dto.numTel = String.valueOf(tel.getNumero());
            dto.idCliente = tel.getCliente() != null ? String.valueOf(tel.getCliente().getId()) : null;
            dto.idFuncionario = tel.getFuncionario() != null ? String.valueOf(tel.getFuncionario().getId()) : null;
            listaDTO.add((InterfaceDTO) dto);
        }
        return listaDTO;
    }
}
