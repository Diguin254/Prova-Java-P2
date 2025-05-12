package controller;

import dao.IngredienteAdicionalDao;
import dao.IngredienteEscolhaDao;
import dao.IngredienteRemoverDao;
import dto.IngredienteAdicionalDTO;
import dto.IngredienteEscolhaDTO;
import dto.IngredienteRemoverDTO;
import model.IngredienteEscolha;
import model.IngredienteRemover;
import model.IngredienteAdicional;
import implementsDao.IngredienteAdicionalImplementsDAO;
import implementsDao.IngredienteEscolhaImplementsDAO;
import implementsDao.IngredienteRemoverImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class IngredienteEscolhaController {

    private final IngredienteEscolhaDao ingredienteEscolhaDao;
    private final IngredienteRemoverDao ingredienteRemoverDao;
    private final IngredienteAdicionalDao ingredienteAdicionalDao;

    public IngredienteEscolhaController() {
        this.ingredienteEscolhaDao = new IngredienteEscolhaImplementsDAO();
        this.ingredienteRemoverDao = new IngredienteRemoverImplementsDAO();
        this.ingredienteAdicionalDao = new IngredienteAdicionalImplementsDAO();
    }

    public void salvar(IngredienteEscolhaDTO ingredienteEscolhaDTO) throws SQLException {
        IngredienteEscolha ingE = ingredienteEscolhaDTO.builder();
        ingredienteEscolhaDao.salvar(ingE);

        if (ingE.getIngredientesRemover() != null) {
            for (IngredienteRemover ingR : ingE.getIngredientesRemover()) {
                ingR.setIngredienteEscolha(ingE);
                ingredienteRemoverDao.salvar(ingR);
            }
        }
        if (ingE.getIngredientesAdicional() != null) {
            for (IngredienteAdicional ingA : ingE.getIngredientesAdicional()) {
                ingA.setIngredienteEscolha(ingE);
                ingredienteAdicionalDao.salvar(ingA);
            }
        }
    }

    public void editar(IngredienteEscolhaDTO ingredienteEscolhaDTO) throws SQLException {
        IngredienteEscolha ingE = ingredienteEscolhaDTO.builder();
        ingredienteEscolhaDao.editar(ingE);

        if (ingE.getIngredientesRemover() != null) {
            for (IngredienteRemover ingR : ingE.getIngredientesRemover()) {
                ingR.setIngredienteEscolha(ingE);
                if (ingR.getId() == 0) {
                    ingredienteRemoverDao.salvar(ingR);
                } else {
                    ingredienteRemoverDao.editar(ingR);
                }
            }
        }
        if (ingE.getIngredientesAdicional() != null) {
            for (IngredienteAdicional ingA : ingE.getIngredientesAdicional()) {
                ingA.setIngredienteEscolha(ingE);
                if (ingA.getId() == 0) {
                    ingredienteAdicionalDao.salvar(ingA);
                } else {
                    ingredienteAdicionalDao.editar(ingA);
                }
            }
        }
    }

    public List<IngredienteEscolhaDTO> listar() throws SQLException {
        List<IngredienteEscolha> listaIngrediente = ingredienteEscolhaDao.listar();
        List<IngredienteRemover> todosIngrRemove = ingredienteRemoverDao.listar();
        List<IngredienteAdicional> todosIngrAdicional = ingredienteAdicionalDao.listar();

        List<IngredienteEscolhaDTO> listaDTO = new LinkedList<>();

        for (IngredienteEscolha ingE : listaIngrediente) {

            List<IngredienteRemover> ingRemoves = new LinkedList<>();
            for (IngredienteRemover ingR : todosIngrRemove) {
                if (ingR.getIngredienteEscolha() != null && ingR.getIngredienteEscolha().getId().equals(ingE.getId())) {
                    ingRemoves.add(ingR);
                }
            }
            ingE.setIngredientesRemover(ingRemoves);

            List<IngredienteAdicional> ingAdicionais = new LinkedList<>();
            for (IngredienteAdicional ingA : todosIngrAdicional) {
                if (ingA.getIngredienteEscolha() != null && ingA.getIngredienteEscolha().getId().equals(ingE.getId())) {
                    ingAdicionais.add(ingA);
                }
            }
            ingE.setIngredientesAdicional(ingAdicionais);

            IngredienteEscolhaDTO dto = new IngredienteEscolhaDTO();
            dto.idIngrEsc = String.valueOf(ingE.getId());
            dto.idCarrinho = String.valueOf(ingE.getCarrinho().getId());

            if (!ingRemoves.isEmpty()) {
                List<IngredienteRemoverDTO> removDtos = new LinkedList<>();
                for (IngredienteRemover ingRe : ingRemoves) {
                    IngredienteRemoverDTO irDto = new IngredienteRemoverDTO();
                    irDto.idIngrRem = String.valueOf(ingRe.getId());
                    irDto.nomeIngrRem = ingRe.getNome();
                    irDto.idIngrEsco = String.valueOf(ingRe.getIngredienteEscolha().getId());
                    removDtos.add(irDto);
                }
                dto.ingrRemovs = removDtos;
            }

            if (!ingAdicionais.isEmpty()) {
                List<IngredienteAdicionalDTO> adicDtos = new LinkedList<>();
                for (IngredienteAdicional ingAdc : ingAdicionais) {
                    IngredienteAdicionalDTO adcDto = new IngredienteAdicionalDTO();
                    adcDto.idIngrAdc = String.valueOf(ingAdc.getId());
                    adcDto.nomeIngrAdc = ingAdc.getNome();
                    adcDto.valorIngrAdc = String.valueOf(ingAdc.getValor());
                    adcDto.idIngrEsc = String.valueOf(ingAdc.getIngredienteEscolha().getId());
                    adicDtos.add(adcDto);
                }
                dto.ingrAdcs = adicDtos;
            }
            listaDTO.add(dto);
        }

        return listaDTO;
    }
}
