package controller;

import dto.InterfaceDTO;
import java.sql.SQLException;
import java.util.List;

public abstract interface InterfaceController {
    public abstract void salvar(InterfaceDTO dto) throws SQLException;
    public abstract void editar(InterfaceDTO dto) throws SQLException;
    public abstract List<InterfaceDTO> listar() throws SQLException;
    public abstract void remover(int id) throws SQLException;
}
