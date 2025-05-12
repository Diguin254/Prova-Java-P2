package controller;

import dao.EnderecoDao;
import dto.EnderecoDTO;
import implementsDao.EnderecoImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Endereco;

public class EnderecoController {

    private final EnderecoDao enderecoDao;

    public EnderecoController() {
        this.enderecoDao = new EnderecoImplementsDAO();
    }

    public void salvar(EnderecoDTO enderecoDTO) throws SQLException {
        Endereco end = enderecoDTO.builder();
        enderecoDao.salvar(end);
    }
    
    public void editar(EnderecoDTO enderecoDTO) throws SQLException{
        Endereco end = enderecoDTO.builder();
        enderecoDao.editar(end);
    }
    
    public void deletar(int id) throws SQLException{
        enderecoDao.deletar(id);
    }
    
    public List<EnderecoDTO> listar() throws SQLException{
        List<Endereco> lista = enderecoDao.listar();
        List<EnderecoDTO> listaDTO = new LinkedList<>();
        
        for(Endereco end : lista){
            EnderecoDTO dto = new EnderecoDTO();
            dto.idEndereco = String.valueOf(end.getId());
            dto.ruaEnd = end.getRua();
            dto.cepEnd = end.getCep();
            dto.idBairro = String.valueOf(end.getBairro().getId());
            dto.distanciaEnd = end.getDistancia();
            listaDTO.add(dto);
        }
        
        return listaDTO;
    }
}
