package controller;

import dao.BairroDao;
import dto.BairroDTO;
import dto.InterfaceDTO;
import implementsDao.BairroImplementsDAO;
import model.Bairro;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BairroController extends InterfaceController{

    private final BairroDao bairroDao;

    public BairroController() {
        this.bairroDao = new BairroImplementsDAO();
    }
    
    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        bairroDao.salvar(((BairroDTO)dto).builder());
    }
    
    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        bairroDao.editar(((BairroDTO)dto).builder());
    }
    
    @Override
    public void deletar(int id) throws SQLException {
        bairroDao.deletar(id);
    }
    
    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<Bairro> lista = bairroDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();
        for (Bairro b : lista) {
            BairroDTO dto = new BairroDTO();
            dto.idBairro = String.valueOf(b.getId());
            dto.nomeBairro = b.getNome();
            listaDTO.add((InterfaceDTO) dto);
        }
        return listaDTO;
    }
}
