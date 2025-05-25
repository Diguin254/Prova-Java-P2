package controller;

import dao.EnderecoDao;
import dto.EnderecoDTO;
import dto.InterfaceDTO;
import implementsDao.EnderecoImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Endereco;

public class EnderecoController extends InterfaceController {

    private final EnderecoDao enderecoDao;

    public EnderecoController() {
        this.enderecoDao = new EnderecoImplementsDAO();
    }

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        enderecoDao.salvar(((EnderecoDTO) dto).builder());
    }

    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        enderecoDao.editar(((EnderecoDTO) dto).builder());
    }

    @Override
    public void deletar(int id) throws SQLException {
        enderecoDao.deletar(id);
    }

    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<Endereco> lista = enderecoDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();
        for (Endereco end : lista) {
            EnderecoDTO dto = new EnderecoDTO();
            dto.idEndereco = String.valueOf(end.getId());
            dto.ruaEnd = end.getRua();
            dto.cepEnd = end.getCep();
            dto.idBairro = String.valueOf(end.getBairro().getId());
            dto.distanciaEnd = end.getDistancia();
            listaDTO.add((InterfaceDTO) dto);
        }
        return listaDTO;
    }
}
