package controller;

import dto.InterfaceDTO;
import java.sql.SQLException;
import java.util.List;

public abstract class InterfaceController {
    public abstract void salvar(InterfaceDTO dto) throws SQLException;
    public abstract void editar(InterfaceDTO dto) throws SQLException;
    public abstract List<InterfaceDTO> listar() throws SQLException;
    public abstract void deletar(int id) throws SQLException;
}
