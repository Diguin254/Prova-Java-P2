package controller;

import dao.TelefoneDao;
import dto.TelefoneDTO;
import implementsDao.TelefoneImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Telefone;

public class TelefoneController {

    private final TelefoneDao telefoneDao;

    public TelefoneController() {
        this.telefoneDao = new TelefoneImplementsDAO();
    }

    public void salvar(TelefoneDTO telefoneDTO) throws SQLException {
        Telefone te = telefoneDTO.builder();
        telefoneDao.salvar(te);
    }

    public void editar(TelefoneDTO telefoneDTO) throws SQLException {
        Telefone te = telefoneDTO.builder();
        telefoneDao.editar(te);
    }

    public void deletar(int id) throws SQLException {
        telefoneDao.deletar(id);
    }

    public List<TelefoneDTO> listar() throws SQLException {
        List<Telefone> lista = telefoneDao.listar();
        List<TelefoneDTO> listaDTO = new LinkedList<>();

        for (Telefone tel : lista) {
            TelefoneDTO dto = new TelefoneDTO();
            dto.idTel = String.valueOf(tel.getId());
            dto.dddTel = String.valueOf(tel.getDdd());
            dto.numTel = String.valueOf(tel.getNumero());
            dto.idCliente = String.valueOf(tel.getCliente().getId());
            dto.idFuncionario = String.valueOf(tel.getFuncionario().getId());
            listaDTO.add(dto);
        }

        return listaDTO;
    }
}
